package com.jobHelper.entity;

public class CompanySizeNumberVO {
	private String companySize;
	private long number;
	public String getCompanySize() {
		return companySize;
	}
	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	public CompanySizeNumberVO() {
		
	}
	
	public CompanySizeNumberVO(String companySize,long number) {
		this.companySize = companySize;
		this.number = number;
	}
}
