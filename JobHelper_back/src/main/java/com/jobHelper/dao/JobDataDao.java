package com.jobHelper.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

public interface JobDataDao extends JpaRepository<JobDataEntity, Long>{
	int countByCatchItem(String catchItem);
	@Query(value="select new com.jobHelper.entity.ItemNumberVO(a.catchItem,count(a.catchItem) as number)"
			+ "from JobDataEntity a"
			+" group by a.catchItem")
	List<ItemNumberVO> getNumberByCatchItem();
	
	@Query(value="select new com.jobHelper.entity.ItemNumberVO(a.catchItem,count(a.catchItem) as number)"
			+ "from JobDataEntity a"
			+" where a.crawlDate = ?1"
			+" group by a.catchItem")
	List<ItemNumberVO> getNumberInOneDayByCatchItem(String crawlDate);
	
	@Query(value="select new com.jobHelper.entity.IndustryFieldNumberVO(a.industryField,count(a.industryField) as number)"
			+ "from JobDataEntity a"
			+" group by a.industryField"
			+" order by number desc")
	List<IndustryFieldNumberVO> getNumberByIndustryField();
	
	@Query(value="select new com.jobHelper.entity.IndustryFieldNumberVO(a.industryField,count(a.industryField) as number)"
			+ "from JobDataEntity a"
			+" where a.catchItem = ?1"
			+" group by a.industryField"
			+" order by number desc")
	List<IndustryFieldNumberVO> getNumberInOneIndustryFieldByIndustryField(String catchItem);
	
	@Query(value="select new com.jobHelper.entity.SalaryNumberVO(a.salary,count(a.salary) as number)"
			+ "from JobDataEntity a"
			+" group by a.salary"
			+" order by number desc")
	List<SalaryNumberVO> getNumberBySalary();
	
	@Query(value="select new com.jobHelper.entity.SalaryNumberVO(a.salary,count(a.salary) as number)"
			+ "from JobDataEntity a"
			+" where a.catchItem = ?1"
			+" group by a.salary"
			+" order by number desc")
	List<SalaryNumberVO> getNumberInOneCatchItemBySalary(String catchItem);
	
	@Query(value="select new com.jobHelper.entity.FinanceStageNumberVO(a.financeStage,count(a.financeStage) as number)"
			+ "from JobDataEntity a"
			+" group by a.financeStage"
			+" order by number desc")
	List<FinanceStageNumberVO> getNumberByFinanceStage();
	
	@Query(value="select new com.jobHelper.entity.FinanceStageNumberVO(a.financeStage,count(a.financeStage) as number)"
			+ "from JobDataEntity a"
			+" where a.catchItem = ?1"
			+" group by a.financeStage"
			+" order by number desc")
	List<FinanceStageNumberVO> getNumberInOneCatchItemByFinanceStage(String catchItem);
	
	@Query(value="select new com.jobHelper.entity.CompanySizeNumberVO(a.companySize,count(a.companySize) as number)"
			+ "from JobDataEntity a"
			+" group by a.companySize"
			+" order by number desc")
	List<CompanySizeNumberVO> getNumberByCompanySize();
	
	@Query(value="select new com.jobHelper.entity.CompanySizeNumberVO(a.companySize,count(a.companySize) as number)"
			+ "from JobDataEntity a"
			+" where a.catchItem = ?1"
			+" group by a.companySize"
			+" order by number desc")
	List<CompanySizeNumberVO> getNumberInOneCatchItemByCompanySize(String catchItem);
	
	@Query(value="select new com.jobHelper.entity.EducationNumberVO(a.education,count(a.education) as number)"
			+ "from JobDataEntity a"
			+" group by a.education"
			+" order by number desc")
	List<EducationNumberVO> getNumberByEducation();
	
	@Query(value="select new com.jobHelper.entity.EducationNumberVO(a.education,count(a.education) as number)"
			+ "from JobDataEntity a"
			+" where a.catchItem = ?1"
			+" group by a.education"
			+" order by number desc")
	List<EducationNumberVO> getNumberInOneCatchItemByEducation(String catchItem);
	
	@Query(value="select new com.jobHelper.entity.CityNumberVO(a.city,count(a.city) as number)"
			+ "from JobDataEntity a"
			+" group by a.city"
			+" order by number desc")
	List<CityNumberVO> getNumberByCity();
	
	@Query(value="select new com.jobHelper.entity.CityNumberVO(a.city,count(a.city) as number)"
			+ "from JobDataEntity a"
			+" where a.catchItem = ?1"
			+" group by a.city"
			+" order by number desc")
	List<CityNumberVO> getNumberInOneCatchItemByCity(String catchItem);
	
	@Query(value="select new com.jobHelper.entity.CrawlDateNumberVO(a.crawlDate,count(a.crawlDate) as number)"
			+ "from JobDataEntity a"
			+" group by a.crawlDate")
	List<CrawlDateNumberVO> getNumberByCrawlDate();
	
	@Query(value="select new com.jobHelper.entity.CrawlDateNumberVO(a.crawlDate,count(a.crawlDate) as number)"
			+ "from JobDataEntity a"
			+" where a.catchItem = ?1"
			+" group by a.crawlDate")
	List<CrawlDateNumberVO> getNumberInOneCatchItemByCrawlDate(String catchItem);
	
	
	@Query(value="select new com.jobHelper.entity.WorkYearNumberVO(a.workYear,count(a.workYear) as number)"
			+ "from JobDataEntity a"
			+" group by a.workYear"
			+" order by number desc")
	List<WorkYearNumberVO> getNumberByWorkYear();
	
	@Query(value="select new com.jobHelper.entity.WorkYearNumberVO(a.workYear,count(a.workYear) as number)"
			+ "from JobDataEntity a"
			+" where a.catchItem = ?1"
			+" group by a.workYear"
			+" order by number desc")
	List<WorkYearNumberVO> getNumberInOneCatchItemByWorkYear(String catchItem);
	
	@Query(value="select new com.jobHelper.entity.JobNatureNumberVO(a.jobNature,count(a.jobNature) as number)"
			+ "from JobDataEntity a"
			+" group by a.jobNature"
			+" order by number desc")
	List<JobNatureNumberVO> getNumberByJobNature();
	
	@Query(value="select new com.jobHelper.entity.JobNatureNumberVO(a.jobNature,count(a.jobNature) as number)"
			+ "from JobDataEntity a"
			+" where a.catchItem = ?1"
			+" group by a.jobNature"
			+" order by number desc")
	List<JobNatureNumberVO> getNumberInOneCatchItemByJobNature(String catchItem);
	
	@Query(value="select new com.jobHelper.entity.PositionNameVO(a.positionName,count(a.positionName) as number)"
			+ "from JobDataEntity a"
			+" group by a.positionName"
			+" order by number desc")
	List<PositionNameVO> getNumberByPositionName();
	
	@Query(value="select new com.jobHelper.entity.PositionNameVO(a.positionName,count(a.positionName) as number)"
			+ "from JobDataEntity a"
			+" where a.catchItem = ?1"
			+" group by a.positionName"
			+" order by number desc")
	List<PositionNameVO> getNumberInOneCatchItemByPositionName(String catchItem);
}
