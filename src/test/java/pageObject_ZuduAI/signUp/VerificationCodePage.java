package pageObject_ZuduAI.signUp;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject_ZuduAI.common.BasePage;

public class VerificationCodePage extends BasePage {
	
	public VerificationCodePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[contains(text(),'Verification')]")
	WebElement verifiedText;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Code')]")
	WebElement verifyCode;
	
	@FindBy(xpath = "//button[contains(text(),'Verify')]")
	WebElement clickVerifyButton;
	
	public void verifiedText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(verifiedText));
		if(verifiedText.isDisplayed()) {
		String verifyText = verifiedText.getText();
		System.out.println("Display Notification: "+verifyText);
		}else {
			System.out.println("Display Notification: Verification code not sent...");
		}
	}
	
	public void verifyCode(Scanner sc) {
		System.out.println("Enter the Verification Code: ");
		int codeEmail = sc.nextInt();
		String numAsString = String.valueOf(codeEmail);
		verifyCode.sendKeys(numAsString);
	}
	
	public void clickVerifyEmail() {
		clickVerifyButton.click();
	}
	
	
}
