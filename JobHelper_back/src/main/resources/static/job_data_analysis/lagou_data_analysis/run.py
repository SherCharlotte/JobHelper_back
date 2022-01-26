from flask import Flask, render_template, jsonify

# 实例化flask
from job_reptile import handle_insert_data

app = Flask(__name__)

# 注册路由
@app.route("/")
def index():
    return "Hello World"

@app.route("/get_echart_data")
def get_echart_data():
    info = {}
    # 行业发布数量分析
    info['echart_1'] = handle_insert_data.lagou_mysql.query_industryfield_result()
    # 薪资发布数量分析
    info['echart_2'] = handle_insert_data.lagou_mysql.query_salary_result()
    # 岗位数量分析,折线图
    info['echart_4'] = handle_insert_data.lagou_mysql.query_job_result()
    #工作年限分析
    info['echart_5'] = handle_insert_data.lagou_mysql.query_workyear_result()
    #学历情况分析
    info['echart_6'] = handle_insert_data.lagou_mysql.query_education_result()
    #融资情况
    info['echart_31'] = handle_insert_data.lagou_mysql.query_financestage_result()
    #公司规模
    info['echart_32'] = handle_insert_data.lagou_mysql.query_companysize_result()
    #岗位要求
    info['echart_33'] = handle_insert_data.lagou_mysql.query_jobNature_result()
    #各地区发布岗位数
    info['map'] = handle_insert_data.lagou_mysql.query_city_result()
    return jsonify(info)

@app.route("/lagou",methods=['GET','POST'])
def lagou():
    # 库内数据总量，今日抓取量
    result = handle_insert_data.lagou_mysql.count_result()
    return render_template('index.html',result=result)

if __name__ == '__main__':
    # 启动flask
    app.run(debug = True,host="0.0.0.0",port=80)