package main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest extends Base {

	@BeforeTest
	public void launchBrowser() {
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		driver.get("https://www.saucedemo.com/");
	}
	
	
	@BeforeClass
	public void pageObjects() {
		
	    loginPage = new LoginPage(driver); 
		
	    productPage = new ProductsPage(driver); 
	}
	
	
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
