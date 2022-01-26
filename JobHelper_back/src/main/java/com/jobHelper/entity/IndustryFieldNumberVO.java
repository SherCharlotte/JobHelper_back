package com.jobHelper.entity;

public class IndustryFieldNumberVO {
	private String industryField;
	private long number;
	public String getIndustryField() {
		return industryField;
	}
	public void setIndustryField(String industryField) {
		this.industryField = industryField;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	public IndustryFieldNumberVO() {
		
	}
	
public IndustryFieldNumberVO(String industryField,long number) {
		this.industryField = industryField;
		this.number = number;
	}
	
}
