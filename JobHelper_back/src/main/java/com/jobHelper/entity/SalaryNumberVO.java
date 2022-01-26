package com.jobHelper.entity;

public class SalaryNumberVO {
	private String salary;
	private long number;
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public SalaryNumberVO() {
		
	}
	
	public SalaryNumberVO(String salary,long number) {
		this.salary = salary;
		this.number = number;
	}
}
