package io.cucumber.samples.pagemodel;

public class BaiduModel {
	private String url;
	private String title;
	private String input;
	private String search;
	public BaiduModel(){
		this.url = "http://www.baidu.com";
		this.title = "百度一下，你就知道";
		this.input = "//*[@id='kw']";
		this.search = "//*[@id='su']";
	}
	public String getUrl() {
		return url;
	}
	public String getTitle() {
		return title;
	}
	public String getInput() {
		return input;
	}
	public String getSearch() {
		return search;
	}
	
}

