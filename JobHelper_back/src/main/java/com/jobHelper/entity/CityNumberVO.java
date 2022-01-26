package com.jobHelper.entity;

public class CityNumberVO {
	private String city;
	private long number;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	public CityNumberVO() {
		
	}
	
	public CityNumberVO(String city,long number) {
		this.city = city;
		this.number = number;
	}
}
