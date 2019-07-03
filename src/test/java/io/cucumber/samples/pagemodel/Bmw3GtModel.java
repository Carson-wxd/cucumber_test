package io.cucumber.samples.pagemodel;

public class Bmw3GtModel {

	//金融重购绿色通道 
	private String greenChannel;
	
	//悠贷金融方案320i M运动套装价格
	private String car320iPrice;
	
	public Bmw3GtModel(){
		this.greenChannel = "/html/body/div[4]/main/div[1]/div[3]/div/div[2]/div/h2";
		this.car320iPrice = "/html/body/div[1]/div[1]/ul[3]/li[2]/span[2]";
	}
	
	public String getGreenChannel(){
		return this.greenChannel;
	}
	
	public String getCar320iPrice(){
		return this.car320iPrice;
	}
	
}
