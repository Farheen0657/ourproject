package skeleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages1.TestMeRegister;
import testmeapp.utility.DriverUtility;

public class caseStudyStepDefs {
		WebDriver driver;
		TestMeRegister page1;
		
		@Before
		public void init()
		{
			driver=DriverUtility.getDriver("firefox");
			page1=PageFactory.initElements(driver, TestMeRegister.class);
			driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
		@When("alex logged-in as admin")
		public void alex_logged_in_as_admin() {
			
			TestMeRegister.login.sendKeys("admin");
			TestMeRegister.password.sendKeys("Password456");
			TestMeRegister.Login.click();
		   
		}

		@When("he clicked on add new product")
		public void he_clicked_on_add_new_product() {
		  TestMeRegister.addProduct.click();
		
		}

		@When("filled all the mandatory details and clicked on add product")
			public void filled_all_the_mandatory_details_and_clicked_on_add_product() {
			TestMeRegister.selectVal(TestMeRegister.selectCategory, "Electronics");
			TestMeRegister.selectSubVal(TestMeRegister.selectSubCategory, "Laptops");
			TestMeRegister.productName.sendKeys("HP Laptop");
			TestMeRegister.price.sendKeys("40000");
		
			
			
		   
		}

		@Then("product is added succesfully")
		public void product_is_added_succesfully() {
		    
		}




}
