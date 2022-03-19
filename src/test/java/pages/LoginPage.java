package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.Base;

public class LoginPage {

	//===============WebElement==============
	WebDriver driver=Base.driver;
	ExtentTest test= Base.test;
	
	@FindBy(linkText="Log in")
	WebElement LoginText;
	
	@FindBy(xpath="//input[@class='email']")
	WebElement Username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(className="rememberMe")
	WebElement RememberMe;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Submit;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	//=============Functions=============
	public void LoginFunction(String UsernameVal, String PasswordVal) {
		
		LoginText.click();	
		test.log(LogStatus.PASS, "Click on Login Link", "Login Link clicked successfully");
		Username.sendKeys(UsernameVal);
		test.log(LogStatus.PASS, "Enter Username", "Username entered successfully");
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Password", "Password Entered successfully");
		RememberMe.click();
		test.log(LogStatus.PASS, "Click on Remember Me", "Remember Me clicked successfully");
		Submit.click();
		test.log(LogStatus.PASS, "Click on Login button", "Login Button clicked successfully");
	}
	
	public void UICheck() {
		
		Assert.assertTrue(Username.isDisplayed());
	}
	
}
