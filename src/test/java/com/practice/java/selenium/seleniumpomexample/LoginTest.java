package com.practice.java.selenium.seleniumpomexample;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.practice.java.selenium.qa.base.TestBase;
import com.practice.java.selenium.qa.pages.Login;


public class LoginTest extends TestBase{

	
	public LoginTest() {
		super();
	}
	
	Login login;
	
	@Test(alwaysRun=true)
	public void setUp() {
		//TestBase testBase=new TestBase();
		init();
		 login=new Login();
	}
	
	@Test(dependsOnMethods="setUp")
	@Parameters("searchValue")
	public void enterSearchTest(@Optional("selenium webdriver") String searchValue) {
		login.waitForSerchBox();
		login.enterSearchText(searchValue);
	}
	
	@Test(dependsOnMethods="enterSearchTest")
	public void clickSearchBtnTest() throws InterruptedException {
		login.clickSearchBtn();
		Thread.sleep(5000);
	}
	
	@Test(dependsOnMethods="clickSearchBtnTest")
	public void quitWebDriver() throws InterruptedException {
		closeWebDriverWindow();
	}
	
}
