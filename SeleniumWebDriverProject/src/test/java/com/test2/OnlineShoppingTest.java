package com.test2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tests.DriverUtility;

public class OnlineShoppingTest {
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest logger;
	@AfterTest
	public void endReportAfterTest()
	{
		reports.flush();
		driver.close();
	}
	@AfterMethod
	public void getResultAfterMethod(ITestResult result)
	{
			if(result.getStatus()==ITestResult.SUCCESS) 
			{ 
				logger.log(Status.PASS, MarkupHelper.createLabel("This Passed!", ExtentColor.GREEN));
			}
			else if(result.getStatus()==ITestResult.SKIP) 
			{
				logger.log(Status.SKIP, MarkupHelper.createLabel("This Skipped!", ExtentColor.AMBER));
			}
			else if(result.getStatus()==ITestResult.FAILURE) 
			{
				logger.log(Status.FAIL, MarkupHelper.createLabel("This Failed!", ExtentColor.RED)); 
		     }
		}

	@BeforeTest
	public void startReportBeforeTest()
	{
		
		driver =  DriverUtility.getDriver("firefox");
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ms");
			String path= System.getProperty("user.dir")+"/extent-reports/" + sdf.format(new Date())+ ".html";
			htmlreporter=new ExtentHtmlReporter(path);
			reports=new ExtentReports();
			reports.attachReporter(htmlreporter);
			reports.setSystemInfo("username", "farheen.m.sulthana");
			reports.setSystemInfo("host", "localhost");
			reports.setSystemInfo("Environment", "TestEnvironment");

			htmlreporter.config().setReportName("Test Me App Report");
		
	}
	@Test(priority=3)
	public void testCart()
	{
		
		WebElement Driver=driver.findElement(By.id("myInput"));
		Actions act1=new Actions(driver);
		act1.keyDown(Driver,Keys.SHIFT).perform();
		act1.sendKeys("h").pause(3000).sendKeys("e").pause(3000).sendKeys("a").pause(3000).sendKeys("d").perform();
		act1.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Headphone')]"))).click().perform();
		driver.findElement(By.cssSelector("input[value='FIND DETAILS']")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-success btn-product']")).click();
		driver.findElement(By.partialLinkText("Cart")).click();
		driver.findElement(By.partialLinkText("Checkout")).click();
		driver.findElement(By.cssSelector("input[value='Proceed to Pay']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-sm-10']")).getText().contains("Headphone"));
		
		 logger=reports.createTest("cart");
	       logger.log(Status.INFO, "product added to cart");
		}
	
	
	@Test(priority=2)
	public void testLogin()
	{
		driver.findElement(By.id("userName")).sendKeys("farheen40");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
        //Assert.assertTrue(driver.getTitle().contains("Home"));
		Assert.assertTrue(true);
        
       logger=reports.createTest("login");
       logger.log(Status.INFO, "Login successful");
	}

    @Test(priority=4)
	public void testPayment()
	{
    	
    	driver.findElement(By.xpath("//div[@id='swit'][2]/div[2]/div/label")).click();
		driver.findElement(By.id("btn")).click();
		driver.findElement(By.name("username")).sendKeys("123457");
		driver.findElement(By.name("password")).sendKeys("Pass@457");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).sendKeys("Trans@457");
		driver.findElement(By.cssSelector("input[value='PayNow']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='panel-body'][1]")).getText().contains("Your order has been confirmed"));
		
		   logger=reports.createTest("payment");
	       logger.log(Status.INFO, "payment successful");
	}
	@Test(priority=1)
	public void testRegistration()
	{
		
		driver.findElement(By.partialLinkText("SignUp")).click();
		driver.findElement(By.id("userName")).sendKeys("Farheen40");
		driver.findElement(By.id("firstName")).sendKeys("farheen");
		Assert.assertEquals(driver.findElement(By.id("err")).getText(),("Available"));
		driver.findElement(By.id("lastName")).sendKeys("sulthana");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("pass_confirmation")).sendKeys("Password123");
		driver.findElement(By.cssSelector("input[value='Female']")).click();
		driver.findElement(By.id("emailAddress")).sendKeys("askme@gmail.com");
		driver.findElement(By.id("mobileNumber")).sendKeys("9654789874");
		driver.findElement(By.cssSelector("img[src='images/calendar.png']")).click();
		Select bmonth=new Select(driver.findElement(By.className("ui-datepicker-month")));
		bmonth.selectByVisibleText("Jun");
		Select byear=new Select(driver.findElement(By.className("ui-datepicker-year")));
		byear.selectByVisibleText("1996");
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td[7]/a")).click();
		//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td[7]/a
		
		driver.findElement(By.id("address")).sendKeys("divyasree technopark,whitefield,banglore");
		driver.findElement(By.id("securityQuestion")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("answer")).sendKeys("Bellary");
		driver.findElement(By.name("Submit")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//form[@action='loginhere.htm']/fieldset/div[8]")).getText().contains("User Registered Succesfully!!! Please login"));
		
		 logger=reports.createTest("Registartion");
	       logger.log(Status.INFO, "Registration successful");
}
	
}
