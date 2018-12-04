package com.test.crossbrowsertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class CrossBrowserTest {
	WebDriver driver;

	@Test
	// Here this parameters we will take from testng.xml
	@Parameters("browser")
	@BeforeTest
	public void setBrowser(String browserName)
	{
	   if (browserName.equalsIgnoreCase("Firefox")) {
	      driver = new FirefoxDriver();
	      
	   }
	   else if (browserName.equalsIgnoreCase("Chrome")) {
	      System.setProperty("webdriver.chrome.driver","C:\\selelib\\chromedriver.exe");
	      driver = new ChromeDriver();

	   }
	   else {
	      throw new IllegalArgumentException("Invalid browser value!!");
	   }
	   driver.get("http:www.google.com");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	}
}
