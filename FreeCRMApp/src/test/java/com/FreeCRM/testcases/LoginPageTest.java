package com.FreeCRM.testcases;



import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.TestBase.TestBase;

public class LoginPageTest extends TestBase {
		
	
	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod 
	
	public void setup() {
		
		Initial(prop.getProperty("URL"));
		
	}

	@Test (priority = 1)
	
	public  void titleTest() {
		
				
		String expectedResult = "#1 Free CRM customer relationship management software cloud";
		String actualResult = driver.getTitle();
		
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, expectedResult);
		
	}

	
	

	@Test (priority = 2)
	public  void Loginpage() {
		
				
		WebElement loginButton = driver.findElement(By.xpath("//a[@href='https://ui.cogmento.com']"));
				loginButton.click();
				
		}
	
	@Test (priority = 3)
	
	public  void LoginVaild() {
		
		Loginpage();
		WebElement usernametextbox = driver.findElement(By.name("email"));
		WebElement passwordtextbox = driver.findElement(By.name("password"));
		WebElement loginbuttonz = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		usernametextbox.sendKeys(prop.getProperty("username"));
		passwordtextbox.sendKeys(prop.getProperty("password"));
		loginbuttonz.click();
		WebElement userdisplay = driver.findElement(By.xpath("//span[text()='Shady Youssef']"));
		boolean status=	userdisplay.isDisplayed();
		Assert.assertTrue(status, "not displayed");	
		System.out.println(status);
				
		}
		
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
