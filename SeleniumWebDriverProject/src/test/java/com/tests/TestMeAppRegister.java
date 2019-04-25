package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMeAppRegister {
	WebDriver Driver;
	@Test
	public void Register()
	{
		Driver =  DriverUtility.getDriver("ie");
		Driver.get("http://10.232.237.143:443/TestMeApp/");
		Driver.manage().window().maximize();
		Driver.findElement(By.partialLinkText("SignUp")).click();
		Driver.findElement(By.id("userName")).sendKeys("Farheen2");
		Driver.findElement(By.id("firstName")).sendKeys("farheen");
		Assert.assertEquals(Driver.findElement(By.id("err")).getText(),("Available"));
		Driver.findElement(By.id("lastName")).sendKeys("sulthana");
		Driver.findElement(By.id("password")).sendKeys("Password123");
		Driver.findElement(By.id("pass_confirmation")).sendKeys("Password123");
		Driver.findElement(By.cssSelector("input[value='Female']")).click();
		Driver.findElement(By.id("emailAddress")).sendKeys("askme@gmail.com");
		Driver.findElement(By.id("mobileNumber")).sendKeys("9654789874");
		Driver.findElement(By.cssSelector("img[src='images/calendar.png']")).click();
		Select bmonth=new Select(Driver.findElement(By.className("ui-datepicker-month")));
		bmonth.selectByVisibleText("Jun");
		Select byear=new Select(Driver.findElement(By.className("ui-datepicker-year")));
		byear.selectByVisibleText("1996");
		Driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td[7]/a")).click();
		//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td[7]/a
		
		Driver.findElement(By.id("address")).sendKeys("divyasree technopark,whitefield,banglore");
		Driver.findElement(By.id("securityQuestion")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Driver.findElement(By.id("answer")).sendKeys("Bellary");
		Driver.findElement(By.name("Submit")).click();
		Assert.assertTrue(Driver.findElement(By.xpath("//form[@action='loginhere.htm']/fieldset/div[8]")).getText().contains("User Registered Succesfully!!! Please login"));

	   
		
	}

}
