package testBase_ZuduAI;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	@BeforeClass
//	@Parameters("browser")
	public void setUp() {
		logger = LogManager.getLogger(this.getClass());
		rb = ResourceBundle.getBundle("config");
		
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeoption);
		
		/*
		if(br.equalsIgnoreCase("chrome")) {
		
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeoption);
		
		}else if(br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else{
			driver = new InternetExplorerDriver();
		}*/
			
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
	
	public String captureScreen(String tname) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+"\\screenShot_ZuduAI\\"+tname+"_"+timeStamp+".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		
		 return destination;
	}
	
	
	
	

}
