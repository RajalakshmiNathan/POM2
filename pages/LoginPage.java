package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseHooks;

public class LoginPage extends BaseHooks {
	
	public LoginPage(ChromeDriver driver,Properties prop) {
		this.driver = driver;
		this.prop = prop;
	}
	
	public LoginPage enterUserName(String uName) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("username")).sendKeys(uName);
		return this;

	}
	
	public LoginPage enterPassword(String pWord) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("password")).sendKeys(pWord);
		return this;

	}
	
	public HomePage clickLoginButton() {
		// TODO Auto-generated method stub
		driver.findElement(By.className("decorativeSubmit")).click();
		return new HomePage(driver,prop);

	}

}
