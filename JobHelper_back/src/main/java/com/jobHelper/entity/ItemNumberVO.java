package com.jobHelper.entity;

public class ItemNumberVO {
	private String catchItem;
	private long number;
	public String getCatchItem() {
		return catchItem;
	}
	public void setCatchItem(String catchItem) {
		this.catchItem = catchItem;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	public ItemNumberVO() {
		
	}
	
	public ItemNumberVO(String catchItem,long number) {
		this.catchItem = catchItem;
		this.number = number;
	}
}
