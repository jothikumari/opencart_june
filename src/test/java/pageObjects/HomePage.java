package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
// CREATING PAge Object Class for HOME PAGE in OPEN CART APPLICATION
	
	// Constructor - Super Keyword invokes Parent class constructor

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}

	// Elements IN HOME PAGE
	

	@FindBy(xpath = "//img[@title='User']")
	WebElement lnkMyaccount;

	
	@FindBy(xpath = "//a[normalize-space()='Create Account']")
	WebElement lnkRegister;

	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	WebElement linkLogin; // signup in dollar days URL

	
	// Action Methods in HOME PAGE
	
	public void clickMyAccount() {
		lnkMyaccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		linkLogin.click();
	}
	
}
