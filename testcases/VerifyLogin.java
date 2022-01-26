package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.BaseHooks;
import pages.LoginPage;

public class VerifyLogin extends BaseHooks {
	
	
//	public VerifyLogin(ChromeDriver driver) {
//		// TODO Auto-generated constructor stub
//		this.driver=driver;
//	}
	
	
	@Test
	public void runVerifyLogin() {
		
		new LoginPage(driver,prop)
		.enterUserName(prop.getProperty("username"))
		.enterPassword(prop.getProperty("password"))
		.clickLoginButton()
		.verifyCRMSFAIsDisplayed();
		
	}
	
	

}
