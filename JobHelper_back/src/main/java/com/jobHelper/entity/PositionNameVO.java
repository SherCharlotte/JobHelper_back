package com.jobHelper.entity;

public class PositionNameVO {
	private String positionName;
	private long number;
	
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	public PositionNameVO() {
		
	}
	
	public PositionNameVO(String positionName,long number) {
		this.positionName = positionName;
		this.number = number;
	}
}
