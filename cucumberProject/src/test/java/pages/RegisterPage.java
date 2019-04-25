package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
	
	@FindBy(how=How.ID,using="gender-female")
	public static WebElement gender;
	@FindBy(how = How.ID,using = "FirstName")
	public static WebElement firstName;
	@FindBy(how = How.ID,using = "LastName")
	public static WebElement lastName;
	@FindBy(how = How.ID,using = "Email")
	public static WebElement email;
	@FindBy(how=How.ID,using = "Password")
	public static WebElement password;
	@FindBy(how = How.ID,using = "ConfirmPassword")
	public static WebElement confirmPassword;
	@FindBy(how = How.NAME,using = "register-button")
	public static WebElement register;
	
	
	
}
