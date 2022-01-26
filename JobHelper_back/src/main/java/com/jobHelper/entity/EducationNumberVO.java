package com.jobHelper.entity;

public class EducationNumberVO {
	private String education;
	private long number;
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	public EducationNumberVO() {
		
	}
	
	public EducationNumberVO(String education,long number) {
		this.education = education;
		this.number = number;
	}
}
