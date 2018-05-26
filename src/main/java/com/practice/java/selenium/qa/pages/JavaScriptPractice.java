package com.practice.java.selenium.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.practice.java.selenium.qa.base.TestBase;

public class JavaScriptPractice extends TestBase{
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//method to create border around selected element
	public void drawBorderUsingJavascript(WebDriver driver,WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public String getPageTitleUsingJavascript(WebDriver driver) {
		return js.executeScript("return document.title;").toString();
		}
	
	public void pageRefreshUsingJavaScript(WebDriver driver) {
		js.executeScript("history.go(0)");
	}
	
	public void clickElementUsingJavascript(WebDriver driver,WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	
	public void enterTextUsingJavascript(WebDriver driver,String text) {
		js.executeScript("arguments[0].document.getElementById('PASS ID HERE').value='sarvesh'");
	}

	public void scrollToBottomUsingJavaScript(WebDriver driver) {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrolltillElementUsingJavaScript(WebDriver driver,WebElement element) {
		js.executeScript("argument[0].scrollIntoView(true);",element);
	}
	
}
