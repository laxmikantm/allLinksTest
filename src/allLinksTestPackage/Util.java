package allLinksTestPackage;


import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;

public class Util {
	
	public static final String FLOCATION ="C:\\Program Files\\Mozilla Firefox\\FireFox.exe";
	
	public static final String BASE_URL="http://newtours.demoaut.com/";
	
	
	
	// Time to wait when searching for a GUI element 
		public static final int WAIT_TIME = 30; 
	
	
	// Expected output
		public static final String EXPECT_TITLE = "Escorted Sightseeing Holiday Tours | Mercury Direct";
	
}

