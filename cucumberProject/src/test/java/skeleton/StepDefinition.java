package skeleton;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition {
	Person sean=new Person();
	
	@Given("Sean is {int} meters away from Lucia")
	public void sean_is_meters_away_from_Lucia(Integer int1) {
		sean.setDistance(int1);
	    
	}
	@When("Sean shouts {string}")
	public void sean_shouts(String string) {
	    sean.setMessage(string);
	}

	@Then("Lucia {string} to the message")
	public void lucia_listens_to_the_message(String flag) {
	  
	   if(flag.contentEquals("listens"))
	   {
		   String message = sean.getMessage();
	      Assert.assertEquals("Free Coffee", message);
	   }
	   else if( flag.contentEquals("cannot listens"))
	   {
		   String message=sean.getMessage();
		   Assert.assertEquals("CANNOT HEAR", message);
	   }
	}



}
