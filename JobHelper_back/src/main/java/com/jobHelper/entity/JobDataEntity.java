package com.jobHelper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="T_jobData")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})

public class JobDataEntity extends IdEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private Integer positionID;//岗位ID
	
	@Column
	private Float longitude;//经度
	
	@Column
	private Float latitude;//纬度
	
	@Column
	private String positionName;//岗位名称
	
	@Column
	private String workYear;//工作年限
	
	@Column
	private String education;//学历
	
	@Column
	private String jobNature;//岗位性质
	
	@Column
	private String financeStage;//公司类型
	
	@Column
	private String companySize;//公司规模
	
	@Column
	private String industryField;//业务方向
	
	@Column
	private String city;//所在城市
	
	@Column
	private String positionAdvantage;//岗位标签
	
	@Column
	private String companyShortName;//公司简称
	
	@Column
	private String companyFullName;//公司全称
	
	@Column 
	private String district;//公司所在区
	
	@Column
	private String companyLabelList;//公司福利标签
	
	@Column
	private String salary;//工资
	
	@Column
	private String crawlDate;//抓取日期
	
	@Column
	private String catchItem;//抓取项目

	public Integer getPositionID() {
		return positionID;
	}

	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getJobNature() {
		return jobNature;
	}

	public void setJobNature(String jobNature) {
		this.jobNature = jobNature;
	}

	public String getFinanceStage() {
		return financeStage;
	}

	public void setFinanceStage(String financeStage) {
		this.financeStage = financeStage;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getIndustryField() {
		return industryField;
	}

	public void setIndustryField(String industryField) {
		this.industryField = industryField;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPositionAdvantage() {
		return positionAdvantage;
	}

	public void setPositionAdvantage(String positionAdvantage) {
		this.positionAdvantage = positionAdvantage;
	}

	public String getCompanyShortName() {
		return companyShortName;
	}

	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}

	public String getCompanyFullName() {
		return companyFullName;
	}

	public void setCompanyFullName(String companyFullName) {
		this.companyFullName = companyFullName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCompanyLabelList() {
		return companyLabelList;
	}

	public void setCompanyLabelList(String companyLabelList) {
		this.companyLabelList = companyLabelList;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCrawlDate() {
		return crawlDate;
	}

	public void setCrawlDate(String crawlDate) {
		this.crawlDate = crawlDate;
	}

	public String getCatchItem() {
		return catchItem;
	}

	public void setCatchItem(String catchItem) {
		this.catchItem = catchItem;
	}


	
	
}
