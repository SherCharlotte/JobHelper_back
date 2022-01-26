import json
import re
import time
import requests
import multiprocessing
from job_reptile.handle_insert_data import lagou_mysql


class HandleLaGou(object):
    def __init__(self):
        # 使用session保存cookies信息
        self.lagou_session = requests.session()
        self.header = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36'
        }
        self.city_list = ""

    # 获取全国所有城市列表的方法
    def handle_city(self):
        city_search = re.compile(r'www\.lagou\.com\/.*\/">(.*?)</a>')
        city_url = "https://www.lagou.com/jobs/allCity.html"
        city_result = self.handle_request(method="GET", url=city_url)
        # 使用正则表达式获取城市列表
        self.city_list = city_search.findall(city_result)
        self.lagou_session.cookies.clear()
        # print(city_result)

    def handle_city_job(self, city):
        first_request_url = "https://www.lagou.com/jobs/list_python?city=%s&cl=false&fromSearch=true&labelWords=&suginput=" % city
        first_response = self.handle_request(method="GET", url=first_request_url)
        total_page_search = re.compile(r'class="span\stotalNum">(\d+)</span>')
        try:
            total_page = total_page_search.search(first_response).group(1)
            print(city, total_page)
        # 由于没有岗位信息造成的exception
        except:
            return
        else:
            for i in range(1, int(total_page) + 1):
                data = {
                    "pn": i,
                    "kd": "python"
                }
                page_url = "https://www.lagou.com/jobs/positionAjax.json?city=%s&needAddtionalResult=false" % city
                referer_url = "https://www.lagou.com/jobs/list_python?city=%s&cl=false&fromSearch=true&labelWords=&suginput=" % city
                # referer的URL需要进行encode
                self.header['Referer'] = referer_url.encode()
                response = self.handle_request(method="POST", url=page_url, data=data, info=city)
                lagou_data = json.loads(response)
                job_list = lagou_data['content']['positionResult']['result']
                for job in job_list:
                    lagou_mysql.insert_item(job)
                    print(job)

    def handle_request(self, method, url, data=None, info=None):
        while True:
            try:
                if method == "GET":
                    response = self.lagou_session.get(url=url, headers=self.header, timeout=6)
                    # response = self.lagou_session.get(url=url,headers=self.header,timeout=6)
                elif method == "POST":
                    response = self.lagou_session.post(url=url, headers=self.header, data=data,
                                                       timeout=6)
                    # response = self.lagou_session.post(url=url,headers=self.header,data=data,timeout=6)
            except:
                # 需要先清除cookies信息
                self.lagou_session.cookies.clear()
                # 重新获取cookies信息
                first_request_url = "https://www.lagou.com/jobs/list_python?city=%s&cl=false&fromSearch=true&labelWords=&suginput=" % info
                self.handle_request(method="GET", url=first_request_url)
                time.sleep(15)
                continue
            response.encoding = 'utf-8'
            if '频繁' in response.text:
                print(response.text)
                # 需要先清除cookies信息
                self.lagou_session.cookies.clear()
                # 重新获取cookies信息
                first_request_url = "https://www.lagou.com/jobs/list_python?city=%s&cl=false&fromSearch=true&labelWords=&suginput=" % info
                self.handle_request(method="GET", url=first_request_url)
                time.sleep(10)
                continue
            return response.text


if __name__ == '__main__':
    lagou = HandleLaGou()
    lagou.handle_city()
    pool = multiprocessing.Pool(4)
    for city in lagou.city_list:
        pool.apply_async(lagou.handle_city_job, args=(city,))
    pool.close()
    pool.join()
    lagou_mysql.query_city_result()
