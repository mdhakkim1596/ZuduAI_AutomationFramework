package pageObject_ZuduAI.logIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObject_ZuduAI.common.BasePage;

public class LogInNavigateEmailPage extends BasePage {
	
	WebDriver driver;
	
	public LogInNavigateEmailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Email address')]")
	WebElement loginEmailLocator;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement clickContinueLocator;
	
	public void loginEmail(String userId) {
		loginEmailLocator.sendKeys(userId);
	}
	
	public void clickContinue() {
		clickContinueLocator.click();
	}
	
}
