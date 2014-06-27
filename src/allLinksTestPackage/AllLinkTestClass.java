package allLinksTestPackage;

import java.io.File;
import java.io.IOException;
import java.util.List;



import java.util.concurrent.TimeUnit;









import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//for screenshot
import org.apache.commons.io.FileUtils;






public class AllLinkTestClass {
  
	public  static WebDriver driver;
	public static List<WebElement> elements;
	
	
	@BeforeTest
	public static void setUp(){
		File pathtobonary = new File(Util.FLOCATION);
		 FirefoxBinary ffbinary = new FirefoxBinary(pathtobonary);
		
		 FirefoxProfile firefoxprofile = new FirefoxProfile();
		driver = new FirefoxDriver(ffbinary, firefoxprofile);
	}
	
	@Test
	public static void actualTest() throws IOException{
		
		driver.get(Util.BASE_URL);
		elements = driver.findElements(By.tagName("a"));
		String[] linktests= new String[elements.size()];
		
		System.out.println("element.size()="+ elements.size());
		
		
		int i=0;
		//extract the each links text
		for (WebElement e : elements){
			linktests[i] = e.getText();
			i++;
		}
		
		/*
			i=0;
		for (i=0; i<elements.size(); i++){
			WebElement e = (WebElement) elements;
			linktests[i] = e.getText();
			elements.iterator().next();
		}
		for (WebElement e : elements){
			linktest[i]= elements.getText();
			
		}*/
		
		
		for (int j = 0; j<elements.size(); j++){
			driver.findElement(By.linkText(linktests[j])).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (driver.getTitle() =="Under Construction: Mercury Tours"){
				System.out.println(linktests[j]+"UnderConstrunction Or getTitle value ="+ driver.getTitle());
				Reporter.log(linktests[j]+"UnderConstrunction & URL = "+ driver.getCurrentUrl());
				
			} else{
				System.out.println(linktests[j]+"Working & getTitle value = "+ driver.getTitle());
				Reporter.log(linktests[j]+"Working!! & URL="+driver.getCurrentUrl());
			}
			//Screenshots
			
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("c:\\selenium-java-2.42.2\\Temp\\screenshot"+j+".png"));
			
			driver.navigate().back();
			
		}//end for
	
		}
		
		


	
	@AfterTest
	public void closure(){
		driver.close();
		Reporter.log("Driver closed");
	}

}
