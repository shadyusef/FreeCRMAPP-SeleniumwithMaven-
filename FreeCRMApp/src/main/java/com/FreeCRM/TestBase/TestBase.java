package com.FreeCRM.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.FreeCRM.util.WebListener;

public class TestBase {
	
	public static WebDriver  driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebListener Weblistener;
	
	
	
	public TestBase() throws IOException {
		 prop = new Properties() ;
		FileInputStream fis = new FileInputStream("C:\\Users\\Shady\\eclipse-workspace\\Framework\\src\\com\\FreeCRM\\config\\config.properties");
		prop.load(fis);
		
	}
	public void Initial (String URL ) {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Shady\\Downloads\\Compressed\\chromedriver_win32_2\\chromedriver.exe");			
		 driver = new ChromeDriver();	
//		 e_driver = new EventFiringWebDriver(driver);
//		 Weblistener = new WebListener();
//		 e_driver.register(Weblistener);
//		 driver=e_driver;
		 driver.get(URL);
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

}
