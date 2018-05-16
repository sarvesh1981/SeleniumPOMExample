package com.practice.java.selenium.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.practice.java.selenium.qa.utils.TestUtils;

public class TestBase {

	static Properties prop;	
	protected static WebDriver driver;
	//String dir = System.getProperty("user.dir");
	
	public static void waitFor() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TestBase(){
		/*try( FileInputStream io=new FileInputStream(System.getProperty(dir+"\\src\\main\\java\\com\\practice\\java\\selenium\\files\\credential.properties"))
			)*/try{
			
			String dir = System.getProperty("user.dir");
			System.out.println("dir - "+dir);
			FileInputStream io = new FileInputStream(dir+"\\src\\main\\java\\com\\practice\\java\\selenium\\files\\credential.properties");
		prop = new Properties();
		prop.load(io);		
	}catch(IOException ex) {
		ex.printStackTrace();
	}
	}
	
	public void init(){	
		switch(prop.getProperty("browser")) {
		case "chrome" :
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sarvsinh\\Documents\\seleniumbrowserdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox" :
			System.setProperty("webdriver.firefox.marionette", "C:\\Users\\sarvsinh\\Documents\\seleniumbrowserdrivers\\geckodriver.exe");
			driver = new ChromeDriver();
			break;
		case "default" :
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITILYWAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get(prop.getProperty("url"));
	}
	
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	public void closeWebDriverWindow() {
		driver.quit();
	}
	
}
