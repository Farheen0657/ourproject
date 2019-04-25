package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import okhttp3.Address;

public class GoogleHomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
		
		 driver=DriverUtility.getDriver("ie");
		 driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterMethod()
	{
		driver.close();
	}
	@Test
	public void testGoogleHomePageTest()
	{
		driver.get("http://www.google.co.in");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Google");
		
		WebElement div=driver.findElement(By.id("SIvCob"));
		  System.out.println(div.getText());
		List<WebElement> list=div.findElements(By.tagName("a"));
		 Assert.assertEquals(list.size(),9);
		
	}
	//	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//WebDriver driver=DriverUtility.getDriver("ie");
		//driver.manage().window().maximize();
		//driver.get("http://www.google.co.in");
		//String title=driver.getTitle();
		//Assert.assertEquals(title, "Google");
		//driver.close();
	
	@Test
	public void testDemoWebShop()
	{
		driver.get("http://demowebshop.tricentis.com/");
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("webshop"));
		driver.findElement(By.linkText("Log in")).click();
		 WebElement email=driver.findElement(By.id("Email"));
		 email.sendKeys("askmail@email.com");
		  WebElement password=driver.findElement(By.id("Password"));
		  password.sendKeys("abc123");
		  driver.findElement(By.cssSelector("input[value='Log in']")).click();

	}
	}


