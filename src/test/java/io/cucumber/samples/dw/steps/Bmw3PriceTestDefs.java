package io.cucumber.samples.dw.steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.samples.pagemodel.BaiduBmwChinaModel;
import io.cucumber.samples.pagemodel.BaiduModel;
import io.cucumber.samples.pagemodel.Bmw3GtModel;
import io.cucumber.samples.pagemodel.BmwMainPageModel;

public class Bmw3PriceTestDefs {

	private static WebDriver driver = null;
	
	private static BaiduModel bai = new BaiduModel();
	
	private static BaiduBmwChinaModel bmwBaidu = new BaiduBmwChinaModel();
	
	private static BmwMainPageModel bmwMainPage = new BmwMainPageModel();
	
	private static Bmw3GtModel bmw3gt = new Bmw3GtModel();
	
	private void initBrowserAndOpenIt() throws Exception {
    	System.setProperty("webdriver.gecko.driver", "C:\\automation_mozila_jar\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(bai.getUrl());
    }
	
	private void closeDriverAndBrowser() throws IOException, InterruptedException {
        driver.quit();
    }

	@Given("^打开浏览器，进入百度的网页$")
	public void openBrowserAndAccessBaidu() throws Throwable {
		initBrowserAndOpenIt();
	}

	@When("^在浏览器框中输入\"(.*?)\"$")
	public void inputArgs(String arg1) throws Throwable {
		driver.findElement(By.xpath(bai.getInput())).sendKeys(arg1);
	}
	
	@Then("^点击百度搜索按钮$")
    public void clickSearchButton() throws Throwable {
        driver.findElement(By.xpath(bai.getSearch())).click();
    }

	@Then("^页面跳转,查看页面是否存在宝马中国链接$")
	public void pageChangeAndCheckIsExistBmw() throws Throwable {
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   Boolean isExistBmwChina = driver.findElement(By.xpath(bmwBaidu.getBmw_china())).isDisplayed();
	   if(isExistBmwChina){
		   System.out.println("exist bmw china");
	   }
	}

	@When("^点击宝马中国链接$")
	public void clickBmwChina() throws Throwable {
		String navigateUrl = driver.findElement(By.xpath(bmwBaidu.getBmw_china())).getAttribute("href");
		driver.navigate().to(navigateUrl);
	}

	@Then("^查看是否跳转到宝马中国页面$")
	public void checkBmwChina() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement web = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bmwMainPage.getBigCustomerBusi())));
		if(web.isDisplayed() == true){
			System.out.println("has changed bmw china");
		}
	}

	
	private static void waitForElementToLoad(WebDriver driver, int timeOut, final By by) throws InterruptedException{
		try{
			(new WebDriverWait(driver,timeOut)).until(new ExpectedCondition<Boolean>(){
				@Override
				public Boolean apply(WebDriver driver) {
					WebElement element = driver.findElement(by);
					System.out.println(element.isDisplayed()+"sssssssssssssss");
					return element.isDisplayed();
				}
			});
		}catch(TimeoutException e){
			System.out.println("loading timeoutexception");
		}
	}
	
	@When("^滑动滚动条到新(\\d+)款BMW(\\d+)系GT的位置$")
	public void movePointToBmw3GtLocation(int arg1, int arg2) throws Throwable {
	   System.out.println(driver.getCurrentUrl());
	   Boolean gt3Flag = false;
	   while(gt3Flag == false){
		   try{
			   waitForElementToLoad(driver,10,By.xpath(bmwMainPage.getElectrcEnger()));
			   if(driver.findElement(By.xpath(bmwMainPage.getElectrcEnger())).isDisplayed() == true){
				   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath(bmwMainPage.getElectrcEnger()))); 
				   gt3Flag = true;
			   }
		   }catch(Exception e){
			   Thread.sleep(1000);
		   }
	   }
	   if(gt3Flag == true){
		   System.out.println("has scrolled the GT3 position");
	   }
	}

	@When("^点击新(\\d+)款BMW(\\d+)系GT$")
	public void clickBmw3Gt(int arg1, int arg2) throws Throwable {
	    driver.findElement(By.xpath(bmwMainPage.getBmw3GtUrl())).click();
	}

	@When("^点击了解详情$")
	public void 点击了解详情() throws Throwable {
		 driver.findElement(By.xpath(bmwMainPage.getBmw3GtDetail())).click();
	}

	@When("^滑动滚动条到金融重购绿色通道位置$")
	public void scrollTheBarToGreenChannelPosition() throws Throwable {
	    Boolean greenFlag = false;
	    while(greenFlag == false){
		    try{
			    waitForElementToLoad(driver,10,By.xpath(bmw3gt.getGreenChannel()));
			    if(driver.findElement(By.xpath(bmw3gt.getGreenChannel())).isDisplayed() == true){
				    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath(bmw3gt.getGreenChannel()))); 
				    greenFlag = true;
			    }
		    }catch(Exception e){
			    Thread.sleep(1000);
		    }
	    }
	    if(greenFlag == true){
	    	System.out.println("has scrolled the GreenChannelPosition");
	    }
	}

	@Then("^查看悠贷金融方案中(\\d+)iM运动套装车价$")
	public void check320iCarPrice(int arg1) throws Throwable {
		Boolean isPresent = isElementPresent(driver,By.xpath(bmw3gt.getCar320iPrice()));
		if(isPresent){
			WebElement web = driver.findElement(By.xpath(bmw3gt.getCar320iPrice()));
			System.out.println(web.getText());
		}else{
			System.out.println("car 320i is not exist!");
		}
		closeDriverAndBrowser();
	}
	
	private boolean isElementPresent(WebDriver driver, By by){
		boolean present = false;
		try{
			driver.findElement(by);
			present = true;
		}catch(NoSuchElementException e){
			present = false;
		}
		return present;
	}
	
	
}
