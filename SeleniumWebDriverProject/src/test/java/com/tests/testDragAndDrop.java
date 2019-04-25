package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testDragAndDrop 
{
	@Test
	public void testDragAndDrop()
	{
		WebDriver driver=DriverUtility.getDriver("firefox");
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		driver.manage().window().maximize();
		
		WebElement from=driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
		WebElement to=driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
		Actions act1=new Actions(driver);
		act1.dragAndDrop(from, to).perform();
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"),"Drop a package here to check price"));
		String text=driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("$3999"));
		//System.out.println(text);
	}

}
