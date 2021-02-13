package com.FreeCRM.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.FreeCRM.TestBase.TestBase;
import com.FreeCRM.util.TestUtils;

public class ContactTestPage extends TestBase {

	public ContactTestPage() throws IOException {
		super();
	}

@BeforeMethod 
	
	public void setup() {
		
		Initial(prop.getProperty("URL"));
		
		WebElement loginButton = driver.findElement(By.xpath("//a[@href='https://ui.cogmento.com']"));
				loginButton.click();
				WebElement Gotit = driver.findElement(By.xpath("//button[text()='Got It']"));
				Gotit.click();
				WebElement usernametextbox = driver.findElement(By.name("email"));
				WebElement passwordtextbox = driver.findElement(By.name("password"));
				WebElement loginbuttonz = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
				usernametextbox.sendKeys(prop.getProperty("username"));
				passwordtextbox.sendKeys(prop.getProperty("password"));
				loginbuttonz.click();
	}

//@Test(priority=1)
public  void ContactsTab() {
	
	
	WebElement Contacts = driver.findElement(By.xpath("//span[text()='Contacts']"));
	Contacts.click();
	WebElement Name = driver.findElement(By.xpath("//th[text()='Name']"));
	
	boolean status=	Name.isDisplayed();
	Assert.assertTrue(status, "not displayed");	
		}


@Test(priority=2, dataProvider ="testData")
public  void NewContact (String FirstName ,String LastName , String Company) {
	ContactsTab();

	WebElement NewContact = driver.findElement(By.xpath("//button[text()='New']"));
	NewContact.click();
	WebElement Firstname = driver.findElement(By.name("first_name"));
	Firstname.sendKeys(FirstName);
	WebElement Lastname = driver.findElement(By.name("last_name"));
	Lastname.sendKeys(LastName);

	WebElement company = driver.findElement(By.xpath(("//input[@autocomplete='off'][1]")));
	company.sendKeys(Company);
	
	WebElement PrivacyButton = driver.findElement(By.xpath("//button[@aria-pressed='false']"));
	PrivacyButton.click();
	WebElement SaveButton = driver.findElement(By.xpath("//button[text()='Save']"));
	SaveButton.click();
	driver.navigate().refresh();

	
}

//@Test(priority=3)
public  void Ensurecnotactssaved () {
	ContactsTab();

WebElement contact = driver.findElement(By.xpath("//a[text()='Shady Youssef']"));

boolean status = contact.isDisplayed();
SoftAssert  softassert = new SoftAssert();
softassert.assertEquals(true, status);
softassert.assertAll();
}


//@Test(priority=4)
public void DeleteContact () {
	ContactsTab();
	WebElement DeleteButton = driver.findElement(By.xpath("//i[@class='trash icon'][1]"));
	DeleteButton.click();
	WebElement DeleteConfirm = driver.findElement(By.xpath("//button[text()='Delete']"));
	DeleteConfirm.click();
	
}


//@Test(priority=5)
//public void DeleteAllContact () {
//	
//}

@AfterMethod
public void tearDown() {
	driver.quit();
	
}
@DataProvider
public Object[][] testData() throws Throwable {
	Object data [][] =TestUtils.getDataFromExcel("Contacts");
	return data ;
}


}
