package pages1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class TestMeRegister {
	@FindBy(how = How.ID,using = "userName")
	public static WebElement login;
	@FindBy(how=How.ID,using = "password")
	public static WebElement password;
	@FindBy(how = How.CSS,using = "input[value='Login']")
	public static WebElement Login;
	@FindBy(how = How.XPATH,using = "//div/div/div/div[1]/button")
	public static WebElement addProduct;
	
	/** Pass the visible text*/
	@FindBy(how = How.ID,using = "categorydropid")
	public static WebElement selectCategory;

	
	@FindBy(how = How.ID,using = "subcategorydropid")
	public static WebElement selectSubCategory;

	
	/**To select items in a given drop down*/
	public static void selectVal(WebElement w,String v) 
	{ Select item =new Select(w); 
	item.selectByVisibleText(v); }
	
	public static void selectSubVal(WebElement w,String v) 
	{ Select item =new Select(w); 
	item.selectByVisibleText(v); }
	 
	@FindBy(how = How.ID,using = "prodid")
	public static WebElement productName;
	
	@FindBy(how = How.ID,using = "priceid")
	public static WebElement price;
	
	@FindBy(how = How.ID,using = "quantityid")
	WebElement quantity;
	
	WebElement 
}
