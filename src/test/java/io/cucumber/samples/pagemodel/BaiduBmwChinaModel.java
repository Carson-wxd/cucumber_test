package io.cucumber.samples.pagemodel;

public class BaiduBmwChinaModel {

	//宝马汽车中国有限公司_百度百科
	private String bmw_baike;
	//BMW 中国
	private String bmw_china;
	public BaiduBmwChinaModel(){
		this.bmw_baike="//*[@id='7']/h3/a";
		this.bmw_china="//*[@id='1']/h3/a";
	}
	public String getBmw_baike(){
		return bmw_baike;
	}
	public String getBmw_china() {
		return bmw_china;
	}
}
