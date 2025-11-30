package pageObject_ZuduAI.signUp;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObject_ZuduAI.common.BasePage;

public class AccountPasswordPage extends BasePage {

	public AccountPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = ".//input[contains(@placeholder,'Password')]")
	WebElement enterPassword;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Re-enter')]")
	WebElement re_EnterPassword;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement click_Continue;
	
	public void enterPassword(String pwd) {
		enterPassword.sendKeys(pwd);
	}
	
	public void re_EnterPassword(String rePwd) {
		re_EnterPassword.sendKeys(rePwd);
	}
	
	public void clickContinue() throws InterruptedException {
		Thread.sleep(20);
		click_Continue.click();
	}
	
}
