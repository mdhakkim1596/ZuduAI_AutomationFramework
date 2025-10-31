package pageObject_ZuduAI;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPage extends BasePage {

	public AccountCreationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Email address')]")
	WebElement enter_Email;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement click_Continue;
	
	public void enterEmail(Scanner sc) {
		System.out.println("Enter the Verification Code: ");
		String email = sc.nextLine();
		enter_Email.sendKeys(email);
	}
	
	public void clickContinue() {
		click_Continue.click();
	}
	

}
