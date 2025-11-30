package pageObject_ZuduAI.logIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObject_ZuduAI.common.BasePage;

public class LogInNavigatePasswordPage extends BasePage {
	
	WebDriver driver;
	
	public LogInNavigatePasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Password')]")
	WebElement loginPasswordLocator;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement clickContinueButtonLocator;
	
	public void loginPassword(String userPass) {
		loginPasswordLocator.sendKeys(userPass);
	}
	
	public void clickContinue() {
		clickContinueButtonLocator.click();
	}
}
