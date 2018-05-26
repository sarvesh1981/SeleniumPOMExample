package com.practice.java.selenium.qa.pages;

import com.practice.java.selenium.qa.base.TestBase;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonJavaScriptPage extends TestBase{

	@FindBy(id="navFooter")
	WebElement backToTop;
	
	@FindBy(id="navFooter")
	WebElement navToFooter;
	
	@FindBy(id="rhf")
	WebElement signIn;
	
	@FindBy(id="ap_customer_name")
	WebElement yourName;
	
	@FindBy(id="ap_email")
	WebElement appEmail;
	
	@FindBy(id="ap_password")
	WebElement passwd;
	
	@FindBy(id="ap_password_check")
	WebElement reEnterPwd;
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	WebDriverWait wait=new WebDriverWait(driver,20);
	
	AmazonJavaScriptPage(){
		PageFactory.initElements(driver, this);
	}
	
	//go To Back To Top link
	public void viewBackToTopLink() {
		wait.until(ExpectedConditions.visibilityOfAllElements(backToTop));
		js.executeScript("arguments[0].scrollIntoView();", backToTop);
		//signIn.findElement(By.id("rhf-container")).findElement(By.xpath("//*[contains(text(),'Start here.')]")).click();
	}
	
	public void clickYourAccountLink() {
		List<WebElement> divList=navToFooter.findElements(By.tagName("div"));
		for(WebElement temp:divList) {
			List<WebElement> liList=temp.findElements(By.tagName("li"));
			if(liList.size()>0) {
				for(WebElement tempLi:liList) {
					System.out.println(tempLi.getText());
					if(tempLi.getText().equalsIgnoreCase("Your Account"))
						tempLi.click();
				}
			}
		}
	}
	
	
	public void clickSignInLink() {
		wait.until(ExpectedConditions.visibilityOfAllElements(signIn));
		js.executeScript("arguments[0].scrollIntoView();", signIn);
		signIn.findElement(By.id("rhf-container")).findElement(By.xpath("//*[contains(text(),'Start here.')]")).click();
	}
	
	//Registration Page
	public void enterUsername(String userName) {
		yourName.sendKeys(userName);
	}
	
	public void enteremail(String email) {
		appEmail.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		passwd.sendKeys(pwd);
	}
	
	public void enterReEnterPwd(String rePwd) {
		reEnterPwd.sendKeys(rePwd);
	}
	
	public void clickConditionOfUseLink(String linkName) throws InterruptedException {		
		driver.findElement(By.xpath("//*[contains(text(),linkName)]")).click();
		wait();
	}
	
	
	
	
}
