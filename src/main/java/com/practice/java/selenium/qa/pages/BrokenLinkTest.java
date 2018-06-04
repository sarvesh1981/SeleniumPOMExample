package com.practice.java.selenium.qa.pages;

import com.practice.java.selenium.qa.base.TestBase;
public class BrokenLinkTest extends TestBase {/*
	
	
	BrokenLinkTest(){
		super();
	}
	
	@Test(alwaysRun=true)
	public void initilizeBase() {		
		init();
		
	}
	
	@Test(dependsOnMethods="initilizeBase")
	public void verifyBrokenLink() throws MalformedURLException, IOException {
		String url;
		driver.get("https://www.google.com/");
		List<WebElement> linkList=driver.findElements(By.tagName("a"));
		System.out.println("linkList="+linkList.size());
		
		Iterator<WebElement> it=linkList.iterator();
		while(it.hasNext()) {
			url = it.next().getAttribute("href");
			
			System.out.println("URL="+url);
			
			HttpURLConnection urlConnection=(HttpURLConnection) new URL(url).openConnection();
			urlConnection.setRequestMethod("HEAD");
            
			urlConnection.connect();
            
            int respCode = urlConnection.getResponseCode();
            
            if(respCode >= 400){
                System.out.println(url+" is a broken link");
            }
            else{
                System.out.println(url+" is a valid link");
            }
		}
	}
*/}
