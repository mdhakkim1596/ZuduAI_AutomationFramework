package pageObject_ZuduAI.signUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObject_ZuduAI.common.BasePage;

public class SignUpPage extends BasePage {

	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement lnk_SignUp;

	public void click_SignUp() {
		lnk_SignUp.click();
	}

}
