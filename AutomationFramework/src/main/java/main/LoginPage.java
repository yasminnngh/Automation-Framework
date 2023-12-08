package main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseTest{

	@FindBy(id = "user-name")
	private WebElement usernameField; 
	
	
	// WebElement user = driver.findElement(By.id("user-name"));
	
	
	@FindBy( id = "password")
	private WebElement passwordField;
	
	
	@FindBy(id = "login-button")
	private WebElement submitButton; 

	
	@FindBy(xpath = "//*[@data-test = 'error']")
	private WebElement errorMessage; 
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String urlValidation(String urlFromUser) {
		
		String urlFromBuild = driver.getCurrentUrl(); 
		
		Assert.assertEquals(urlFromBuild, urlFromUser);
		
		return urlFromBuild;
	}
	
	
	public String titleValidation(String titleFromUser) {
		
		String titleFromBuild = driver.getTitle(); 
	 
		Assert.assertEquals(titleFromBuild, titleFromUser);

		return titleFromBuild; 
	}
	
	
	public void loginValidation(String username, String password) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		usernameField.sendKeys(username);
		
		passwordField.sendKeys(password);
		
		submitButton.click();
	}
	
	
	public String errorMessageValidation(String username, String password) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		usernameField.sendKeys(username);
		
		passwordField.sendKeys(password);
		
		submitButton.click();
		
		boolean check1 = errorMessage.isDisplayed(); 
	
		Assert.assertTrue(check1);
		
		return errorMessage.getText();
	}
	
	
	
}
