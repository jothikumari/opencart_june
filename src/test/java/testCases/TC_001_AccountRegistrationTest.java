package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC_001_AccountRegistrationTest extends BaseClass
{
	@Test(priority=1, groups = {"Regression", "Master"})
	public void test_account_Registration() throws InterruptedException
	{
		
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("Clicked on My account link");
		
		hp.clickRegister();
		
		logger.info("Clicked on register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);

		logger.info("Providing customer data");
	// convert into uppercase
	
	//	String firstname = randomeString().toUpperCase();
	//	regpage.setFirstName(firstname);
		
		regpage.setFirstName(randomeString().toUpperCase());
		
	//	String lastname = randomeString().toUpperCase();
	//	regpage.setLastName(lastname);
		
		regpage.setLastName(randomeString().toUpperCase());
	
	// randomly generated the email
		
		regpage.setEmail(randomeString()+"@gmail.com");
		
		regpage.setTelephone(randomeNumber());
	
	// randomAlphannmeric()  method called from BaseClass
	// it will generate different alphanumeric character for password and confirmation password
	// in order to give same password for both password and confirmation password
	// Assign it to password variable and use it in both setpassword and setconfirmpaswword method
			
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		
		regpage.setConfirmPassword(password);
		}
		catch(Exception e)
			{
			Assert.fail();
			}
	}
		@Test(priority = 2, groups = {"Regression", "Master"})
		public void test_frame() 
		{
			try
			{
			WebElement frm1 = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
			driver.switchTo().frame(frm1);
			
			logger.info("Switched to IFRAME....");
			
			driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
			driver.switchTo().defaultContent();
			
			logger.info("Switched BACK TO WINDOWS....");
			
			}
			catch(Exception e)
				{
					logger.error("test failed");
					Assert.fail();
				}
				
		}
		
		@Test(priority = 3)
		public void test_frame1() 
		{
			try
			{
			logger.info("Clicked on continue");
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			regpage.clickContinue();
		
			logger.info("***  Finished TC_001_AccountRegistrationTest ***");
		}
		catch(Exception e)
			{
				logger.error("test failed");
				Assert.fail();
			}
		
		}
	//	String confmsg=regpage.getConfirmationMsg();
		
	//	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		

}
	

