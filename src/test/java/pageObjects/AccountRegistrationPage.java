package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
// CONSTRUCTOR
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	// Elements
	
		@FindBy(xpath = "//input[@id='ctl00_cphContent_txtFName']")
		WebElement txtFirstname;

		@FindBy(name = "ctl00$cphContent$txtLName")
		WebElement txtLasttname;

		@FindBy(name = "ctl00$cphContent$txtClientEmail")
		WebElement txtEmail;

		@FindBy(name = "ctl00$cphContent$txtPhoneMain")
		WebElement txtTelephone;

		@FindBy(xpath = "//input[@id='ctl00_cphContent_txtPassword']")
		WebElement txtPassword;

		@FindBy(xpath = "//input[@id='ctl00_cphContent_txtPasswordConfirm']")
		WebElement txtConfirmPassword;

		
		@FindBy(xpath ="//input[@id='ctl00_cphContent_btnRegister']")
		WebElement btnContinue;

	//	@FindBy(xpath = "//span[normalize-space()='Sign in']")
	//	WebElement msgConfirmation;

		public void setFirstName(String fname) {
			txtFirstname.sendKeys(fname);

		}

		public void setLastName(String lname) {
			txtLasttname.sendKeys(lname);

		}

		public void setEmail(String email) {
			txtEmail.sendKeys(email);

		}

		public void setTelephone(String tel) {
			txtTelephone.sendKeys(tel);

		}

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);

		}

		public void setConfirmPassword(String pwd) {
			txtConfirmPassword.sendKeys(pwd);

		}

	public void clickContinue() {
			//sol1 
			btnContinue.click();
			
			//sol2 
			//btnContinue.submit();
			
			//sol3
			//Actions act=new Actions(driver);
			//act.moveToElement(btnContinue).click().perform();
						
			//sol4
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", btnContinue);
			
			//Sol 5
			//btnContinue.sendKeys(Keys.RETURN);
			
			//Sol6  
			//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
			
	}

	/*	public String getConfirmationMsg() {
		try {
				return (msgConfirmation.getText());
		} catch (Exception e) {
				return (e.getMessage());

		}
		}*/

}
