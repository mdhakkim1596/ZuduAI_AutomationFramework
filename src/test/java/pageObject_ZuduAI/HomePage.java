package pageObject_ZuduAI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement lnk_SignUp;

	public void click_SignUp() {
		lnk_SignUp.click();
	}

}
