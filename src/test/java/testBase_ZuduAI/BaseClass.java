package testBase_ZuduAI;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;

	@BeforeClass
	public void setUp() {
		logger = LogManager.getLogger(this.getClass());
		
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeoption);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://app.uat.zudu.ai/landing");
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
