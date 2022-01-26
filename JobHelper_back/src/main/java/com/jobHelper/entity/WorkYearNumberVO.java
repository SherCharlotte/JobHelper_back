package com.jobHelper.entity;

public class WorkYearNumberVO {
	private String workYear;
	private long number;
	public String getWorkYear() {
		return workYear;
	}
	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	public WorkYearNumberVO() {
		
	}
	
	public WorkYearNumberVO(String workYear,long number) {
		this.workYear = workYear;
		this.number = number;
	}
}
