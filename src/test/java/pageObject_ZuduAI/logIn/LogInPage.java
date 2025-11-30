package pageObject_ZuduAI.logIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObject_ZuduAI.common.BasePage;

public class LogInPage extends BasePage{
	
	WebDriver driver;
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement clickLoginButtonLocator;
	
	public void clickLoginButton() {
		clickLoginButtonLocator.click();
	}
	
}
