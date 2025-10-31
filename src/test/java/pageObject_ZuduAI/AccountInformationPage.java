package pageObject_ZuduAI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountInformationPage extends BasePage {
	
	public AccountInformationPage(WebDriver driver) {
			super(driver);
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Full name')]")
	WebElement enter_Name;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Organization name')]")
	WebElement enter_Organization;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement click_Continue;
	
	public void enterName(String fname) {
		enter_Name.sendKeys(fname);
	}
	
	public void enterOrganization(String o_name) {
		enter_Organization.sendKeys(o_name);
	}
	
	public void clickContinue() {
		click_Continue.click();
	}
	
}
