package skeleton;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.RegisterPage;
import testmeapp.utility.DriverUtility;

public class registerStepDefs {
	WebDriver driver;
	/*@Before
	public void init()
	{
		driver=DriverUtility.getDriver("ie");
		PageFactory.initElements(driver, RegisterPage.class);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}*/
	
	
	@Given("url of the demoWebShop")
	public void url_of_the_demoWebShop() {
	    driver.get("http://demowebshop.tricentis.com/register");
	}

	@When("user enters the data for registration")
	public void user_enters_the_data_for_registration() {
	    RegisterPage.gender.click();
	    RegisterPage.firstName.sendKeys("farheen");
	    RegisterPage.lastName.sendKeys("sulthana");
	    RegisterPage.email.sendKeys("farheens@email.com");
	    RegisterPage.password.sendKeys("Password123");
	    RegisterPage.confirmPassword.sendKeys("Password123");
	    RegisterPage.register.click();
	}

	@Then("user is registered successfully")
	public void user_is_registered_successfully() {
		 String text = driver.findElement(By.cssSelector("div[class='result']")).getText();
	  Assert.assertTrue(text.contains("Your registration completed"));
	}



}
