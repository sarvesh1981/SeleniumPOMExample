package com.practice.java.selenium.test;

import com.practice.java.selenium.qa.base.TestBase;
import com.practice.java.selenium.qa.pages.AmazonHomePage;

import org.testng.annotations.*;

public class AmazonHomeTest extends TestBase {

	
	AmazonHomePage ahp;
	public AmazonHomeTest() {
		super();
	}
	
	@Test(alwaysRun=true)
	@Parameters("url")
	public void initilize(@Optional("http://www.google.com") String url) {
		init();
		driver.get(url);
		ahp= new AmazonHomePage();
	}
	
	@Test(dependsOnMethods="initilize")
	@Parameters("department")
	public void selectDepartmenr(String department) {
		
		ahp.waitforAllDepartmentElementTest();
		ahp.selectDepertment(department);
	}
	
	@Test(dependsOnMethods="selectDepartmenr")
	@Parameters("searchText")
	public void enterSearchTextTest(String searchText) {
		ahp.enterSearchData(searchText);
	}
	
	@Test(dependsOnMethods="enterSearchTextTest")
	public void clickSearchBtnTest() throws InterruptedException {
		ahp.clickSearch();
		Thread.sleep(5000);
	}
	
	@Test(dependsOnMethods="clickSearchBtnTest")
	public void clickCartTest() {
		ahp.clickCart();
	}
	
	@Test(dependsOnMethods="clickCartTest")
	public void hoverlinks() {
		//ahp.hoverAllLinks();
	}
	
	@Test(dependsOnMethods="hoverlinks")
	public void clickAmazonLogoTest() {
		ahp.clickAmazonLogo();
	}
	
	@Test(dependsOnMethods="clickAmazonLogoTest")
	@Parameters("zipcode")
	public void clickDeliverToTest(String zipcode) {
		ahp.clickDeliveredIcon(zipcode);
		
	}
	
	@Test(dependsOnMethods="clickDeliverToTest")
	public void quitWebDriver() throws InterruptedException {
		closeWebDriverWindow();
		
	}
	
	
}
