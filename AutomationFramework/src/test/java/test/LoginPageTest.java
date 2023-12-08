package test;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.Test;

import main.BaseTest;
import main.LoginPage;
import main.ProductsPage;

public class LoginPageTest extends BaseTest {

	
	@Test (priority = 0)
	
	public void validationOfUrl() {
		
		loginPage.urlValidation("https://www.saucedemo.com/");
		
		Reporter.log("URL is matching and test case passed.", true);

		System.out.println(loginPage.urlValidation("https://www.saucedemo.com/"));		
	}
	
	
	@Test (priority = 1)
	
	public void validationOfTitle() {
		
		loginPage.titleValidation("Swag Labs"); 
		
		Reporter.log("Title is matching and test case passed.", true);
		
		System.out.println(loginPage.titleValidation("Swag Labs"));
	}
	
	
	@Test (priority = 2)
	
	public void validationOfLoginFunctionality() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		loginPage.loginValidation("standard_user", "secret_sauce");
		
		productPage.validatingTitle("Products");
		
		Reporter.log("Login is successful and test case is passed.", true);
		
		System.out.println(productPage.validatingTitle("Products"));
		
		productPage.logoutValidation();
	}
	
	
	@Test (priority = 3)
	
	public void validationFunctionalityWithInvalidData() {
		
		System.out.println(loginPage.errorMessageValidation("hello", "goodbye"));
		
		Reporter.log("Error message is displayed and test case is passed.", true);
	}
	
	
	
	
	
}
