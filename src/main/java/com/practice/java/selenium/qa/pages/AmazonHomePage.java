package com.practice.java.selenium.qa.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.practice.java.selenium.qa.base.TestBase;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AmazonHomePage extends TestBase{

	WebDriverWait wait=new WebDriverWait(driver,20);
	Action action ;
	Actions actions = new Actions(driver);
	
	//@FindBy(xpath="//*[@id='navbar']//div[@id='nav-belt']//div[@class='nav-fill']//div[@id='nav-search']//form//following::div[0]//div//select")
	
	@FindBy(xpath="//*[@id='navbar']//div[@id='nav-belt']//div[@class='nav-fill']//div[@id='nav-search']")
	WebElement selectFromAllDepartment;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchByDepartmentText;
		
	@FindBy(xpath="//input[@value='Go']")
	WebElement searchIcon;
	
	@FindBy(id="nav-cart")
	WebElement shoppingCart;
	
	@FindBy(id="sc-active-cart")
	WebElement cartText;
	
	@FindBy(xpath="//*[@id='navbar']//*[@id='nav-main']")
	WebElement hoverAllLinks;
	
	@FindBy(id="nav-logo")
	WebElement AmazonLogo;
	
	@FindBy(id="nav-packard-glow-loc-icon")
	WebElement deliveredIcon;
	
	//pop up window for Delivered To
	@FindBy(id="GLUXChangePostalCodeLink")
	WebElement pinChange;
	
	@FindBy(id="GLUXZipUpdateInput")
	WebElement pintext;
	
	@FindBy(id="GLUXSpecifyLocationDiv")
	WebElement applyBtn;
	
	
	public AmazonHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void waitforAllDepartmentElementTest() {
		wait.until(ExpectedConditions.visibilityOf(selectFromAllDepartment));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbar")));
		System.out.println("TAG NAME="+selectFromAllDepartment.getTagName());
	}
	
	public void selectDepertment(String department) {
		WebElement departmentList = selectFromAllDepartment.findElement(By.tagName("form"));
		System.out.println("departmentList="+departmentList.getTagName());
		WebElement departmentList1 = departmentList.findElement(By.className("nav-left"));
		System.out.println("departmentList1="+departmentList1.getTagName());
				
		WebElement selectLocator= departmentList1.findElement(By.tagName("select"));
		System.out.println("selectLocator="+selectLocator.getTagName());
		Select deprt=new Select(selectLocator);
		deprt.selectByVisibleText(department);
	}
	
	public void enterSearchData(String searchText) {
		searchByDepartmentText.sendKeys(searchText);
		searchByDepartmentText.clear();
		actions.keyUp(searchByDepartmentText, Keys.SHIFT)
				.sendKeys(searchByDepartmentText,searchText)
				.keyDown(searchByDepartmentText, Keys.SHIFT)
				.doubleClick(searchByDepartmentText)
				.contextClick(searchByDepartmentText)
				.build().perform();
		
	}
	
	public void clickSearch() {
		searchIcon.click();
	}
	
	public void clickCart() {
		shoppingCart.click();
		wait.until(ExpectedConditions.visibilityOf(cartText));
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(searchByDepartmentText));
	}
	
	public void hoverAllLinks()  {
		List<WebElement> hoverLink=hoverAllLinks.findElements(By.tagName("div"));
		System.out.println("div count="+hoverLink.size());
		List<WebElement> linksList=hoverLink.get(7).findElements(By.tagName("a"));
		System.out.println("links size="+linksList.size());
		int i=0;
		for(WebElement temp:hoverLink) {			
			System.out.println(i +"= "+temp.findElements(By.tagName("a")).size());
			if(temp.findElements(By.tagName("a")).size()>0) {
				List<WebElement> links=temp.findElements(By.tagName("a"));
				for(WebElement tempLink:links) {
					System.out.println(tempLink.getText());
					if(tempLink.getText().equalsIgnoreCase("Today's Deals")) {
						actions.moveToElement(tempLink)
						.click(tempLink)						
						.build().perform();
						
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
				
			i++;
		}
		
	}
	
	public void clickAmazonLogo() {
		AmazonLogo.findElements(By.tagName("a")).get(0).click();
	}
	
	public void clickDeliveredIcon(String zipcode) {
		System.out.println("zipcode ="+zipcode);
		String parentWindow=driver.getWindowHandle();
		deliveredIcon.click();
		waitFor();
		for(String temp:driver.getWindowHandles()) {
			driver.switchTo().window(temp);
		}
		wait.until(ExpectedConditions.elementToBeClickable(pinChange));
		pinChange.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("GLUXZipUpdateInput")));
		pintext.sendKeys(zipcode);
		
		List<WebElement> nestedDiv=applyBtn.findElements(By.tagName("div"));
		
		for(WebElement temp:nestedDiv) {
			if(temp.findElements(By.tagName("span")).size()>0) {
				temp.findElement(By.id("GLUXZipUpdate")).click();
				break;
			}
		}
		driver.switchTo().window(parentWindow);
		waitFor();
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	public void fluentWaittest() {
		Wait wait=new FluentWait(driver)
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
	}
	
	/*WebElement clickseleniumlink = wait.until(new Function<webdriver, WebElement>(){
		
		

		@Override
		public WebElement apply(WebDriver t) {
			// TODO Auto-generated method stub
			return null;
		}
	});*/
}
