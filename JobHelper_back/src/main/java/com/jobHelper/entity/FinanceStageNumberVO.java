package com.jobHelper.entity;

public class FinanceStageNumberVO {
	private String financeStage;
	private long number;
	public String getFinanceStage() {
		return financeStage;
	}
	public void setFinanceStage(String financeStage) {
		this.financeStage = financeStage;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	public FinanceStageNumberVO() {
		
	}
	
	public FinanceStageNumberVO(String financeStage,long number) {
		this.financeStage = financeStage;
		this.number = number;
	}
}
