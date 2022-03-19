package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest  extends Base{
			
		@Test
		public void LoginFailureTest(){
			
			LoginPage login= new LoginPage();
			login.LoginFunction("ABC@xyz.com", "Abc@12345");
			//for validating login msg
			WebElement ErrorMsg= driver.findElement(By.id("msg_box"));
			String ActualMsg=ErrorMsg.getText();
			String ExpMsg="The email or password you have entered is invalid.";
			Assert.assertEquals(ActualMsg, ExpMsg);		
		}
		
		@Test
		public void LoginSuccessTest(){
			
			LoginPage login=new LoginPage();
			login.LoginFunction("xyz@abc.com", "Abc@12345");	
		}
		
		@Test
		@Parameters({"Param1","Param2"})
		public void ParameterisedTest(String UserVal, String PassVal) {
			
			LoginPage login=new LoginPage();
			login.LoginFunction(UserVal, PassVal);
		}
		
		@Test
		public void ExternalDataTest() {
			
			String UserVal=sheet.getRow(1).getCell(0).getStringCellValue();
			String PassVal=sheet.getRow(1).getCell(1).getStringCellValue();
			LoginPage login=new LoginPage();
			login.LoginFunction(UserVal, PassVal);			
		}
		
}
