package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "//img[@title='User']")
	WebElement lnkMyaccount;
	

	@FindBy(xpath = "//a[normalize-space()='Accounts']") // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//a[normalize-space()='Sign Out']")
	WebElement lnkLogout;
	
	
	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}

	public boolean isMyAccountPageExists()   // MyAccount Page option display on drop down menu
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout()
	{
		lnkLogout.click();
	}
	
}
