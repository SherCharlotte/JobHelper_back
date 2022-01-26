package com.jobHelper.controller;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobHelper.bean.Result;
import com.jobHelper.entity.AddEntity;
import com.jobHelper.entity.CityNumberVO;
import com.jobHelper.entity.CompanySizeNumberVO;
import com.jobHelper.entity.CrawlDateNumberVO;
import com.jobHelper.entity.EducationNumberVO;
import com.jobHelper.entity.FinanceStageNumberVO;
import com.jobHelper.entity.IndustryFieldNumberVO;
import com.jobHelper.entity.ItemNumberVO;
import com.jobHelper.entity.JobNatureNumberVO;
import com.jobHelper.entity.PositionNameVO;
import com.jobHelper.entity.SalaryNumberVO;
import com.jobHelper.entity.WorkYearNumberVO;
import com.jobHelper.service.JobDataService;

@Controller
public class JobDataController {

	@Autowired
	HttpSession session;
	@Autowired
	private JobDataService jobDataService;
	
//	@RequestMapping("/findOne")
//	@ResponseBody
//	public JobDataEntity findone() {
//		JobDataEntity job = jobDataService.findone(1);
//		return job;
//	}
	
	@RequestMapping("/addJob")
	@ResponseBody
	public Result addJob(@RequestBody AddEntity add) throws IOException, InterruptedException {
		String[] args = new String[] {"C:\\Users\\XZQ\\AppData\\Local\\Programs\\Python\\Python37\\python.exe","D:\\JobHelp\\job_data_analysis\\job_reptile\\handle_crawl_lagou.py",String.valueOf(add.getItem())};
		Process proc = Runtime.getRuntime().exec(args);//执行Python文件
		BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"GBK"));
		String line = null;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		in.close();
		proc.waitFor();
		return new Result(0, "数据获取成功", "", "");
	}
	
	@RequestMapping("/returnJobNumber")//获取总工作数量
	@ResponseBody
	public Result returnJobNumber() {
		long num = jobDataService.jobNumber();
		return new Result(0, "总数据量", num, "");
	}
	
	@RequestMapping("/returnItemNumber")//获取单个项目的职位数量
	@ResponseBody
	public long returnItemNumber() {
		long num = jobDataService.itemNumber("python");
		return num;
	}
	
	@RequestMapping("/getItemNumberGroupByItem")
	@ResponseBody
	public Result getItemNumberGroupByItem() {
		List<ItemNumberVO> itemNumbers = jobDataService.itemGroupBy();
		Result result = new Result(0, "获取工作项目分组数量", itemNumbers, "");
		return result;
		
	}
	@RequestMapping("/getItemNumberTodayGroupByItem")
	@ResponseBody
	public Result getItemNumberTodayGroupByItem() {
//		Calendar calender = Calendar.getInstance();
//		String today = calender.get(Calendar.YEAR)+"-"+(calender.get(Calendar.MONTH)+1)+"-"+calender.get(Calendar.DATE);
		Date day=new Date();    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String today = sdf.format(day);
		System.out.println(today+":");  
		List<ItemNumberVO> itemNumbers = jobDataService.itemInOneDayGroupBy(today);
		Result result = new Result(0, "获取当日工作项目分组数量", itemNumbers, "");
		return result;
	}
	
	
	
	@RequestMapping("/getIndustryFieldNumberGroupByIndustryField")
	@ResponseBody
	public Result getIndustryFieldNumberGroupByIndustryField() {
		List<IndustryFieldNumberVO> industFields = jobDataService.industryFieldGroupBy();
		
		return new Result(0, "获取行业分组", industFields, "");
	}
	
	@RequestMapping("/getIndustryFieldNumberInOneIndustryFieldGroupByIndustryField")
	@ResponseBody
	public Result getIndustryFieldNumberInOneIndustryFieldGroupByIndustryField(@RequestBody String item) { 
		item = item.substring(1,item.length()-1);
		
		List<IndustryFieldNumberVO> industFieldList = jobDataService.industryFieldInOneIndustryFieldGroupBy(item);
		return new Result(0, "获取"+item+"行业分组", industFieldList, "");
	}
	
	
	
	@RequestMapping("/getSalaryNumberGroupBySalary")
	@ResponseBody
	public Result getSalaryNumberGroupBySalary() {
		List<SalaryNumberVO> salarys = jobDataService.salaryGroupBy();
		return new Result(0,"获取薪酬情况",salarys,"");
	}
	
	@RequestMapping("/getSalaryNumberInOneCatchItemGroupBySalary")
	@ResponseBody
	public Result getSalaryNumberInOneCatchItemGroupBySalary(@RequestBody String item) {
		item = item.substring(1,item.length()-1);
		
		List<SalaryNumberVO> salarys = jobDataService.salaryInOneCatchItemGroupBy(item);
		return new Result(0, "获取"+item+"薪酬情况", salarys, "");
		
	}
	
	
	
	@RequestMapping("/getFinanceStageNumberGroupByFinanceStage")
	@ResponseBody
	public Result getFinanceStageNumberGroupByFinanceStage() {
		List<FinanceStageNumberVO> financeStages = jobDataService.financeStageGroupBy();
		return new Result(0,"获取融资情况",financeStages,"");
	}
	
	@RequestMapping("/getFinanceStageNumberInOneCatchItemGroupByFinanceStage")
	@ResponseBody
	public Result getFinanceStageNumberInOneCatchItemGroupByFinanceStage(@RequestBody String item) {
		item = item.substring(1,item.length()-1);
		List<FinanceStageNumberVO> financeStages = jobDataService.financeStageInOneCatchItemGroupBy(item);
		return new Result(0,"获取"+item+"融资情况",financeStages,"");
	}
	
	
	
	@RequestMapping("/getCompanySizeNumberGroupByCompanySize")
	@ResponseBody
	public Result getCompanySizeNumberGroupByCompanySize() {
		List<CompanySizeNumberVO> companySizes = jobDataService.companySizeGroupBy();
		return new Result(0, "获取公司规模", companySizes, "");
	}
	
	@RequestMapping("/getCompanySizeNumberInOneCatchItemGroupByCompanySize")
	@ResponseBody
	public Result getCompanySizeNumberInOneCatchItemGroupByCompanySize(@RequestBody String item) {
		item = item.substring(1,item.length()-1);
		List<CompanySizeNumberVO> companySizes = jobDataService.companySizeInOneCatchItemGroupByCompanySize(item);
		return new Result(0, "获取"+item+"获取公司规模", companySizes, "");
	}
	
	
	
	@RequestMapping("/getEducationNumberGroupByEducation")
	@ResponseBody
	public Result getEducationNumberGroupByEducation() {
		List<EducationNumberVO> educations = jobDataService.educationGroupBy();
		return new Result(0,"获取学历要求信息",educations,"");
	}
	
	@RequestMapping("/getEducationNumberInOneCatchItemGroupByEducation")
	@ResponseBody
	public Result getEducationNumberInOneCatchItemGroupByEducation(@RequestBody String item) {
		item = item.substring(1,item.length()-1);
		List<EducationNumberVO> educations = jobDataService.educationInOneCatchItemGroupByEducation(item);
		return new Result(0,"获取"+item+"获取学历要求信息",educations,"");
	}
	
	
	
	
	@RequestMapping("/getCityNumberGroupByCity")
	@ResponseBody
	public Result getCityNumberGroupByCity() {
		List<CityNumberVO> citys = jobDataService.cityGroupBy();
		return new Result(0, "获取城市信息", citys, "");
	}
	
	@RequestMapping("/getCityNumberInOneCatchItemGroupByCity")
	@ResponseBody
	public Result getCityNumberInOneCatchItemGroupByCity(@RequestBody String item) {
		item = item.substring(1,item.length()-1);
		List<CityNumberVO> citys = jobDataService.cityInOneCatchItemGroupByCity(item);
		return new Result(0, "获取"+item+"获取城市信息", citys, "");
	}
	
	
	
	
	@RequestMapping("/getCrawlDateNumberGroupByCrawlDate")
	@ResponseBody
	public Result getCrawlDateNumberGroupByCrawlDate() {
		List<CrawlDateNumberVO> crawlDates = jobDataService.crawlDateGroupBy();
		return new Result(0, "获取抓取日期信息", crawlDates, "");
	}
	
	@RequestMapping("/getCrawlDateNumberInOneCatchItemGroupByCrawlDate")
	@ResponseBody
	public Result getCrawlDateNumberInOneCatchItemGroupByCrawlDate(@RequestBody String item) {
		item = item.substring(1,item.length()-1);
		List<CrawlDateNumberVO> crawlDates = jobDataService.crawlDateInOneCatchItemGroupByCrawlDate(item);
		return new Result(0, "获取"+item+"获取抓取日期信息", crawlDates, "");
	}
	
	@RequestMapping("/getWorkYearNumberGroupByWorkYear")
	@ResponseBody
	public Result getWorkYearNumberGroupByWorkYear() {
		List<WorkYearNumberVO> workYears = jobDataService.workYearGroupBy();
		return new Result(0, "获取工作年限信息", workYears, "");
	}
	
	@RequestMapping("/getWorkYearNumberInOneCatchItemGroupByWorkYear")
	@ResponseBody
	public Result getWorkYearNumberInOneCatchItemGroupByWorkYear(@RequestBody String item) {
		item = item.substring(1,item.length()-1);
		List<WorkYearNumberVO> workYears = jobDataService.workYearInOneCatchItemGroupByWorkYear(item);
		return new Result(0, "获取"+item+"获取工作年限信息", workYears, "");
	}
	
	@RequestMapping("/getJobNatureNumberGroupByJobNature")
	@ResponseBody
	public Result getJobNatureNumberGroupByJobNature() {
		List<JobNatureNumberVO> jobNatures = jobDataService.jobNatureGroupBy();
		return new Result(0, "获取工作性质信息", jobNatures, "");
	}
	
	@RequestMapping("/getJobNatureNumberInOneCatchItemGroupByJobNature")
	@ResponseBody
	public Result getJobNatureNumberInOneCatchItemGroupByJobNature(@RequestBody String item) {
		item = item.substring(1,item.length()-1);
		List<JobNatureNumberVO> jobNatures = jobDataService.jobNatureInOneCatchItemGroupByJobNature(item);
		return new Result(0, "获取"+item+"获取工作性质信息", jobNatures, "");
	}
	
	@RequestMapping("/getNumberGroupByPositionName")
	@ResponseBody
	public Result getNumberGroupByPositionName() {
		List<PositionNameVO> positionNames = jobDataService.positionNameGroupBy();
		return new Result(0, "获取工作信息", positionNames, "");
	}
	
	@RequestMapping("/getPositionNameInOneCatchItemGroupByPositionName")
	@ResponseBody
	public Result getPositionNameInOneCatchItemGroupByPositionName(@RequestBody String item) {
		item = item.substring(1,item.length()-1);
		List<PositionNameVO> positionNames = jobDataService.positionInOneCatchItemGroupByPositionName(item);
		return new Result(0, "获取"+item+"获取工作信息", positionNames, "");
	}
	
}
