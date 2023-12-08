package main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductsPage extends BaseTest {

	@FindBy(xpath = "//*[@class = 'title']")
	private WebElement productPageTitle;
	
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuButton;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logout; 
	
	
	public ProductsPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	

	public String validatingTitle(String titleFromUser) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String titleFromBuild = productPageTitle.getText();
		
		Assert.assertEquals(titleFromBuild, titleFromUser);
		
		return titleFromBuild;
	}
	
	
	public void logoutValidation() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		menuButton.click();
		
		logout.click();
	}
	
	
	
	
	
}
