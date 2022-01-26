package com.jobHelper.imp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobHelper.dao.JobDataDao;
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
import com.jobHelper.service.JobDataService;

@Service
public class JobDataImp implements JobDataService{

	@Autowired
	JobDataDao jobDataDao;
	@Autowired
	HttpSession session;

	@Override
	public JobDataEntity findone(long id) {
		// TODO Auto-generated method stub
		JobDataEntity job = new JobDataEntity();
		job = jobDataDao.findById(id).get();
		return job;
	}

	@Override
	public long jobNumber() {
		// TODO Auto-generated method stub
		return jobDataDao.count();
	}

	@Override
	public long itemNumber(String catchItem) {
		// TODO Auto-generated method stub
		return jobDataDao.countByCatchItem(catchItem);
	}

	@Override
	public List<ItemNumberVO> itemGroupBy() {
		// TODO Auto-generated method stub
		List<ItemNumberVO> itemNumbers = jobDataDao.getNumberByCatchItem();

		for (int i = 0; i < itemNumbers.size(); i++) {
			System.out.println(itemNumbers.get(i).getCatchItem() + ": " + itemNumbers.get(i).getNumber());
		}

		return itemNumbers;
	}

	@Override
	public List<ItemNumberVO> itemInOneDayGroupBy(String crawlDate) {
		// TODO Auto-generated method stub

		List<ItemNumberVO> itemNumbers = jobDataDao.getNumberInOneDayByCatchItem(crawlDate);
		System.out.println(crawlDate + ":");
		for (int i = 0; i < itemNumbers.size(); i++) {
			System.out.println(itemNumbers.get(i).getCatchItem() + ": " + itemNumbers.get(i).getNumber());
		}
		return itemNumbers;
	}

	@Override
	public List<IndustryFieldNumberVO> industryFieldGroupBy() {
		// TODO Auto-generated method stub
		List<IndustryFieldNumberVO> industryFields = jobDataDao.getNumberByIndustryField();
		System.out.println("所有行业信息数量: ");
		for (int i = 0; i < industryFields.size(); i++) {
			System.out.println(industryFields.get(i).getIndustryField() + ": " + industryFields.get(i).getNumber());
		}
		return industryFields;
	}

	@Override
	public List<IndustryFieldNumberVO> industryFieldInOneIndustryFieldGroupBy(String catchItem) {
		// TODO Auto-generated method stub
		System.out.println(catchItem+": 行业信息");
		List<IndustryFieldNumberVO> industryFields = jobDataDao.getNumberInOneIndustryFieldByIndustryField(catchItem);
		for (int i = 0; i < industryFields.size(); i++) {
			System.out.println(industryFields.get(i).getIndustryField() + ": " + industryFields.get(i).getNumber());
		}
		return industryFields;
	}

	@Override
	public List<SalaryNumberVO> salaryGroupBy() {
		// TODO Auto-generated method stub
		List<SalaryNumberVO> salarys = jobDataDao.getNumberBySalary();
		System.out.println("薪酬信息: ");
		for(int i = 0;i < salarys.size();i++) {
			System.out.println(salarys.get(i).getSalary() + ": " + salarys.get(i).getNumber());
		}
		return salarys;
	}

	@Override
	public List<SalaryNumberVO> salaryInOneCatchItemGroupBy(String catchItem) {
		// TODO Auto-generated method stub
		List<SalaryNumberVO> salarys = jobDataDao.getNumberInOneCatchItemBySalary(catchItem);
		System.out.println(catchItem+": 薪酬信息: ");
		for(int i = 0;i < salarys.size();i++) {
			System.out.println(salarys.get(i).getSalary() + ": " + salarys.get(i).getNumber());
		}
		return salarys;
	}

	@Override
	public List<FinanceStageNumberVO> financeStageGroupBy() {
		// TODO Auto-generated method stub
		List<FinanceStageNumberVO> financeStages  = jobDataDao.getNumberByFinanceStage();
		System.out.println("融资信息: ");
		for(int i = 0;i < financeStages.size();i++) {
			System.out.println(financeStages.get(i).getFinanceStage() + ": " + financeStages.get(i).getNumber());
		}
		return financeStages;
	}

	@Override
	public List<FinanceStageNumberVO> financeStageInOneCatchItemGroupBy(String catchItem) {
		// TODO Auto-generated method stub
		List<FinanceStageNumberVO> financeStages = jobDataDao.getNumberInOneCatchItemByFinanceStage(catchItem);
		System.out.println(catchItem+"融资信息: ");
		for(int i = 0;i < financeStages.size();i++) {
			System.out.println(financeStages.get(i).getFinanceStage() + ": " + financeStages.get(i).getNumber());
		}
		return financeStages;
	}

	@Override
	public List<CompanySizeNumberVO> companySizeGroupBy() {
		// TODO Auto-generated method stub
		List<CompanySizeNumberVO> companySizes = jobDataDao.getNumberByCompanySize();
		System.out.println("公司规模信息: ");
		for(int i = 0;i < companySizes.size();i++) {
			System.out.println(companySizes.get(i).getCompanySize() + ": " + companySizes.get(i).getNumber());
		}
		return companySizes;
	}

	@Override
	public List<CompanySizeNumberVO> companySizeInOneCatchItemGroupByCompanySize(String catchItem) {
		// TODO Auto-generated method stub
		List<CompanySizeNumberVO> companySizes = jobDataDao.getNumberInOneCatchItemByCompanySize(catchItem);
		System.out.println(catchItem+"公司规模信息: ");
		for(int i = 0;i < companySizes.size();i++) {
			System.out.println(companySizes.get(i).getCompanySize() + ": " + companySizes.get(i).getNumber());
		}
		return companySizes;
	}

	@Override
	public List<EducationNumberVO> educationGroupBy() {
		// TODO Auto-generated method stub
		List<EducationNumberVO> educations = jobDataDao.getNumberByEducation();
		System.out.println("学历要求信息: ");
		for(int i = 0;i < educations.size();i++) {
			System.out.println(educations.get(i).getEducation() + ": " + educations.get(i).getNumber());
		}
		return educations;
	}

	@Override
	public List<EducationNumberVO> educationInOneCatchItemGroupByEducation(String catchItem) {
		// TODO Auto-generated method stub
		List<EducationNumberVO> educations = jobDataDao.getNumberInOneCatchItemByEducation(catchItem);
		System.out.println(catchItem+"学历要求信息: ");
		for(int i = 0;i < educations.size();i++) {
			System.out.println(educations.get(i).getEducation() + ": " + educations.get(i).getNumber());
		}
		return educations;
	}

	@Override
	public List<CityNumberVO> cityGroupBy() {
		// TODO Auto-generated method stub
		List<CityNumberVO> citys = jobDataDao.getNumberByCity();
		System.out.println("城市信息: ");
		for(int i = 0;i < citys.size();i++) {
			System.out.println(citys.get(i).getCity() + ": " + citys.get(i).getNumber());
		}
		return citys;
	}

	@Override
	public List<CityNumberVO> cityInOneCatchItemGroupByCity(String catchItem) {
		// TODO Auto-generated method stub
		List<CityNumberVO> citys = jobDataDao.getNumberInOneCatchItemByCity(catchItem);
		System.out.println(catchItem+"城市信息: ");
		for(int i = 0;i < citys.size();i++) {
			System.out.println(citys.get(i).getCity() + ": " + citys.get(i).getNumber());
		}
		return citys;
	}

	@Override
	public List<CrawlDateNumberVO> crawlDateGroupBy() {
		// TODO Auto-generated method stub
		List<CrawlDateNumberVO> crawlDates = jobDataDao.getNumberByCrawlDate();
		System.out.println("抓取日期信息: ");
		for(int i = 0;i < crawlDates.size();i++) {
			System.out.println(crawlDates.get(i).getCrawlDate() + ": " + crawlDates.get(i).getNumber());
		}
		return crawlDates;
	}

	@Override
	public List<CrawlDateNumberVO> crawlDateInOneCatchItemGroupByCrawlDate(String catchItem) {
		// TODO Auto-generated method stub
		List<CrawlDateNumberVO> crawlDates = jobDataDao.getNumberInOneCatchItemByCrawlDate(catchItem);
		System.out.println(catchItem+"抓取日期信息: ");
		for(int i = 0;i < crawlDates.size();i++) {
			System.out.println(crawlDates.get(i).getCrawlDate() + ": " + crawlDates.get(i).getNumber());
		}
		return crawlDates;
	}

	@Override
	public List<WorkYearNumberVO> workYearGroupBy() {
		// TODO Auto-generated method stub
		List<WorkYearNumberVO> workYears = jobDataDao.getNumberByWorkYear();
		System.out.println("工作年限信息: ");
		for(int i = 0;i < workYears.size();i++) {
			System.out.println(workYears.get(i).getWorkYear() + ": " + workYears.get(i).getNumber());
		}
		return workYears;
	}

	@Override
	public List<WorkYearNumberVO> workYearInOneCatchItemGroupByWorkYear(String catchItem) {
		// TODO Auto-generated method stub
		List<WorkYearNumberVO> workYears = jobDataDao.getNumberInOneCatchItemByWorkYear(catchItem);
		System.out.println(catchItem+"工作年限信息: ");
		for(int i = 0;i < workYears.size();i++) {
			System.out.println(workYears.get(i).getWorkYear() + ": " + workYears.get(i).getNumber());
		}
		return workYears;
	}

	@Override
	public List<JobNatureNumberVO> jobNatureGroupBy() {
		// TODO Auto-generated method stub
		List<JobNatureNumberVO> jobNatures = jobDataDao.getNumberByJobNature();
		System.out.println("工作性质信息: ");
		for(int i = 0;i < jobNatures.size();i++) {
			System.out.println(jobNatures.get(i).getJobNature() + ": " + jobNatures.get(i).getNumber());
		}
		return jobNatures;
	}

	@Override
	public List<JobNatureNumberVO> jobNatureInOneCatchItemGroupByJobNature(String catchItem) {
		// TODO Auto-generated method stub
		List<JobNatureNumberVO> jobNatures = jobDataDao.getNumberInOneCatchItemByJobNature(catchItem);
		
		System.out.println(catchItem+"工作工作性质信息: ");
		for(int i = 0;i < jobNatures.size();i++) {
			System.out.println(jobNatures.get(i).getJobNature() + ": " + jobNatures.get(i).getNumber());
		}
		return jobNatures;
	}

	@Override
	public List<PositionNameVO> positionNameGroupBy() {
		// TODO Auto-generated method stub
		List<PositionNameVO> positionNames = jobDataDao.getNumberByPositionName();
		List<PositionNameVO> NewPositionNames = new ArrayList<>();
		System.out.println("工作信息: ");
		for(int i = 0;i < positionNames.size();i++) {
			if(positionNames.get(i).getNumber()>=3) {
				NewPositionNames.add(positionNames.get(i));
				System.out.println(positionNames.get(i).getPositionName() + ": " + positionNames.get(i).getNumber());
			}
		}
		return NewPositionNames;

	}

	@Override
	public List<PositionNameVO> positionInOneCatchItemGroupByPositionName(String catchItem) {
		// TODO Auto-generated method stub
		List<PositionNameVO> positionNames = jobDataDao.getNumberInOneCatchItemByPositionName(catchItem);
		List<PositionNameVO> NewPositionNames = new ArrayList<>();
		System.out.println(catchItem+"工作信息: ");
		for(int i = 0;i < positionNames.size();i++) {
			if(positionNames.get(i).getNumber()>=3) {
				NewPositionNames.add(positionNames.get(i));
				System.out.println(positionNames.get(i).getPositionName() + ": " + positionNames.get(i).getNumber());
			}
		}
		return NewPositionNames;

	}

}
