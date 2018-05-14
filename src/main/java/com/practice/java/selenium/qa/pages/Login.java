package com.practice.java.selenium.qa.pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.java.selenium.qa.base.TestBase;

public class Login extends TestBase{
	
	WebDriverWait wait;
	JavascriptExecutor js =(JavascriptExecutor) driver;
	
	
	@FindBy(id="lst-ib")
	WebElement searchBox;
	
	@FindBy(name="btnK")
	WebElement searchBtn;
	
	public Login(){
		PageFactory.initElements(driver, this);
	}
	
	public void waitForSerchBox() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(searchBox));
	}
	public void enterSearchText(String value) {
		searchBox.sendKeys(value);
	}
	
	public void clickSearchBtn() {
		js.executeScript("arguments[0].click();", searchBtn);
	}
	
	
	
	
	
	

}
