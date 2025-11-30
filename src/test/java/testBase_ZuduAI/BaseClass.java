package testBase_ZuduAI;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) {
		logger = LogManager.getLogger(this.getClass());
		rb = ResourceBundle.getBundle("config");
		
		if(br.equalsIgnoreCase("chrome")) {
		
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeoption);
		
		}else if(br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else{
			driver = new InternetExplorerDriver();
		}
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(rb.getString("webURL"));
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	
	public String randomNumeric() {
		String generatedNum = RandomStringUtils.randomAlphanumeric(4);
		return generatedNum;
	}
	
	public String randomAlphaNumeric() {
		String alpha = RandomStringUtils.randomAlphabetic(4);
		String numeric = RandomStringUtils.randomNumeric(4);
		return (alpha+"e"+"L"+"@"+numeric);
	}
	
	
	
	

}
