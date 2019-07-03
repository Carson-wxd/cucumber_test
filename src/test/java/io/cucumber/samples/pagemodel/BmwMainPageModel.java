package io.cucumber.samples.pagemodel;

public class BmwMainPageModel {

	//title
	private String title;
	
	//大客户业务
	private String bigCustomerBusi;
	
	//BMW3系GT
	private String bmw3GtUrl;
	
	//BMW3系GT了解详情
	private String bmw3GtDetail;
	
	//轮询图片的右方按钮
	private String theNextButton;
	
	//电动性能
	private String electrcEnger;
	
	public BmwMainPageModel(){
		this.title = "BMW 中国";
		this.bigCustomerBusi = "//*[@id='ds2-globalnav']/ul[3]/li[1]/a";
		this.bmw3GtUrl = "/html/body/div[1]/main/div[1]/div[4]/div/div/div/div[2]/div/div/div/div[3]/a/div/span";
		this.bmw3GtDetail = "/html/body/div[1]/main/div[1]/div[4]/div/div/div/div[3]/div/div/div[4]/div/div[2]/div[2]/div/ul/li/a";
		this.theNextButton = "/html/body/div[1]/main/div[1]/div[4]/div/div/div/div[3]/button[2]";
		this.electrcEnger = "/html/body/div[1]/main/div[1]/div[3]/div/ul/li[14]/a/div[1]/img";
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getBigCustomerBusi(){
		return this.bigCustomerBusi;
	}
	
	public String getBmw3GtUrl(){
		return this.bmw3GtUrl;
	}
	
	public String getBmw3GtDetail(){
		return this.bmw3GtDetail;
	}
	
	public String getTheNextButton(){
		return this.theNextButton;
	}
	
	public String getElectrcEnger(){
		return this.electrcEnger;
	}

}
