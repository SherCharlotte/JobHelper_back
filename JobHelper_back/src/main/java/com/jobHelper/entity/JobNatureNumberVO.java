package com.jobHelper.entity;

public class JobNatureNumberVO {
	private String jobNature;
	private long number;
	
	public String getJobNature() {
		return jobNature;
	}
	public void setJobNature(String jobNature) {
		this.jobNature = jobNature;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	public JobNatureNumberVO() {
		
	}
	
	public JobNatureNumberVO(String jobNature,long number) {
		this.jobNature = jobNature;
		this.number = number;
	}
}
