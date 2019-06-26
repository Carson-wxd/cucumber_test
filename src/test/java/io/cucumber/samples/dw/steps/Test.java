package io.cucumber.samples.dw.steps;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.samples.pagemodel.BaiduModel;

public class Test {

private static WebDriver driver = null;
	
	private static BaiduModel bai = new BaiduModel();

    public void initBrowserAndOpenIt() throws Exception {
    	System.setProperty("webdriver.gecko.driver", "C:\\automation_mozila_jar\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(bai.getUrl());
        Thread.sleep(3000);
    }

    public void closeDriverAndBrowser() throws IOException, InterruptedException {
        driver.quit();
    }
	
    @Given("^打开百度，验证title$")
    public void openBaiduPageAndCheckTitle() throws Throwable {
    	initBrowserAndOpenIt();
        assertEquals(driver.getTitle(), bai.getTitle());
    }

    @When("^输入 \"(.*?)\"$")
    public void inputYourSearchWords(String text) throws Throwable {
        driver.findElement(By.xpath(bai.getInput())).sendKeys(text);
        Thread.sleep(3000);
    }

    @Then("^点击搜索按钮$")
    public void clickSearchButton() throws Throwable {
        driver.findElement(By.xpath(bai.getSearch())).click();
    }

    @Then("^清除搜索框$")
    public void clearInputSearchWords() throws Throwable {
    	Thread.sleep(3000);
        driver.findElement(By.xpath(bai.getInput())).clear();
        Thread.sleep(3000);
        closeDriverAndBrowser();
    }
}
