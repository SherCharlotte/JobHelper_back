package com.jobHelper.service;

import java.util.List;

import com.jobHelper.entity.CityNumberVO;
import com.jobHelper.entity.CompanySizeNumberVO;
import com.jobHelper.entity.CrawlDateNumberVO;
import com.jobHelper.entity.EducationNumberVO;
import com.jobHelper.entity.FinanceStageNumberVO;
import com.jobHelper.entity.IndustryFieldNumberVO;
import com.jobHelper.entity.ItemNumberVO;
import com.jobHelper.entity.JobDataEntity;
import com.jobHelper.entity.JobNatureNumberVO;
import com.jobHelper.entity.PositionNameVO;
import com.jobHelper.entity.SalaryNumberVO;
import com.jobHelper.entity.WorkYearNumberVO;

public interface JobDataService {
	public JobDataEntity findone(long id);//查询一条记录
	public long jobNumber();//返回总数据条数
	public long itemNumber(String catchItem);//返回某个项目的数据条数
	
	public List<ItemNumberVO> itemGroupBy();//根据项目分组返回总数据条数
	public List<ItemNumberVO> itemInOneDayGroupBy(String crawlDate);//根据项目分组返回某天数据条数
	
	public List<IndustryFieldNumberVO> industryFieldGroupBy();//根据行业分组
	public List<IndustryFieldNumberVO> industryFieldInOneIndustryFieldGroupBy(String catchItem);
	
	public List<SalaryNumberVO> salaryGroupBy();//根据薪酬分组
	public List<SalaryNumberVO> salaryInOneCatchItemGroupBy(String catchItem);
	
	public List<FinanceStageNumberVO> financeStageGroupBy();//根据融资分组
	public List<FinanceStageNumberVO> financeStageInOneCatchItemGroupBy(String catchItem);
	
	public List<CompanySizeNumberVO> companySizeGroupBy();//根据公司规模分组
	public List<CompanySizeNumberVO> companySizeInOneCatchItemGroupByCompanySize(String catchItem);
	
	public List<EducationNumberVO> educationGroupBy();//根据学历要求分组
	public List<EducationNumberVO> educationInOneCatchItemGroupByEducation(String catchItem);
	
	public List<CityNumberVO> cityGroupBy();//根据城市分组
	public List<CityNumberVO> cityInOneCatchItemGroupByCity(String catchItem);
	
	public List<CrawlDateNumberVO> crawlDateGroupBy();//根据抓取日期分组
	public List<CrawlDateNumberVO> crawlDateInOneCatchItemGroupByCrawlDate(String catchItem);
	
	public List<WorkYearNumberVO> workYearGroupBy();//根据工作年限要求分组
	public List<WorkYearNumberVO> workYearInOneCatchItemGroupByWorkYear(String catchItem);
	
	public List<JobNatureNumberVO> jobNatureGroupBy();//根据工作性质分组
	public List<JobNatureNumberVO> jobNatureInOneCatchItemGroupByJobNature(String catchItem);
	
	public List<PositionNameVO> positionNameGroupBy();//根据工作名称分组
	public List<PositionNameVO> positionInOneCatchItemGroupByPositionName(String catchItem);
}
