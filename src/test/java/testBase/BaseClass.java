package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseClass 
{
public static WebDriver driver;
	
public Logger logger; //  for logging	
public ResourceBundle rb;	// import from java.util package
	


	@BeforeClass(groups = {"Master", "Sanity", "Regression"})
	@Parameters("browser")
	public void setup(String br)
	{
	// load config.properties file
		
		rb = ResourceBundle.getBundle("config");
	
	// capture the current class name
	// Responsible for launching the browser. so we pass parameters to the setup() from XML file	
	
		logger = LogManager.getLogger(this.getClass());
	
	if(br.equals("Edge"))
	{
	driver=new EdgeDriver();
	}
	else if(br.equals("Chrome"))
	{
		driver = new ChromeDriver();
	}
	else
	{
		driver = new FirefoxDriver();
	}
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get(rb.getString("appURL"));
	
	driver.manage().window().maximize();
}

		
	@AfterClass(groups = {"Master", "Sanity", "Regression"})
	public void tearDown()
	{
	driver.quit();
	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

// RandomStringUtils comes from dependencies in pom.xml
// The below method will Randomly generate string and numeric of specific characters.
	
	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
	return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}

	public String captureScreen(String tname) throws IOException {

		// creating TIMESTAMP
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;		
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	
}
