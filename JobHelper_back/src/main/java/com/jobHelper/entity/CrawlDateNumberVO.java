package com.jobHelper.entity;

public class CrawlDateNumberVO {
	private String crawlDate;
	private long number;
	public String getCrawlDate() {
		return crawlDate;
	}
	public void setCrawlDate(String crawlDate) {
		this.crawlDate = crawlDate;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	public CrawlDateNumberVO() {
		
	}
	
	public CrawlDateNumberVO(String crawlDate,long number) {
		this.crawlDate = crawlDate;
		this.number = number;
	}
}
