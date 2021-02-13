package com.FreeCRM.testcases;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.TestBase.TestBase;

public class HomePage extends TestBase{
		
	
	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod 
	
	public void setup() {
		
		Initial("http://freecrm.com");
		driver.manage().window().maximize();
		WebElement loginButton = driver.findElement(By.xpath("//a[@href='https://ui.cogmento.com']"));
		loginButton.click();
		WebElement username = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginbuttonz = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginbuttonz.click();
				
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	
	@Test(priority = 4)
	
	public  void LoginCheck() {
		
				
		WebElement userdisplay = driver.findElement(By.xpath("//span[text()='Shady Youssef']"));
		boolean status=	userdisplay.isDisplayed();
		Assert.assertTrue(status, "not displayed");	
				}
 
	@Test(priority = 5)

	public  void ContactsTab() {
	
			
		WebElement Contacts = driver.findElement(By.xpath("//span[text()='Contacts']"));
		Contacts.click();
		WebElement Name = driver.findElement(By.xpath("//th[text()='Name']"));
		
		boolean status=	Name.isDisplayed();
		Assert.assertTrue(status, "not displayed");	
			}

	@Test(priority = 6)
		
	public  void DealsTab() {
			
					
			WebElement Deals = driver.findElement(By.xpath("//span[text()='Deals']"));
			Deals.click();
			WebElement Title = driver.findElement(By.xpath("//th[text()='Title']"));
				
			boolean status=	Title.isDisplayed();
			Assert.assertTrue(status, "not displayed");	
					}

	@Test(priority = 7)
		
	public  void TasksTab() {
			
					
			WebElement Tasks = driver.findElement(By.xpath("//span[text()='Tasks']"));
			Tasks.click();
			WebElement Title = driver.findElement(By.xpath("//th[text()='Title']"));
			
			boolean status=	Title.isDisplayed();
			Assert.assertTrue(status, "not displayed");		
					}

}
