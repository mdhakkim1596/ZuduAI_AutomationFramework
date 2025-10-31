package testCases_ZuduAI;

import java.util.Scanner;

import org.testng.annotations.Test;

import pageObject_ZuduAI.AccountCreationPage;
import pageObject_ZuduAI.AccountInformationPage;
import pageObject_ZuduAI.AccountPasswordPage;
import pageObject_ZuduAI.HomePage;
import pageObject_ZuduAI.VerificationCodePage;
import testBase_ZuduAI.BaseClass;

public class TC_001_AccountCreationTest extends BaseClass {
	
	Scanner sc = new Scanner(System.in);
	@Test
	public void test_AccountCreation() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.click_SignUp();
		
		AccountCreationPage ac = new AccountCreationPage(driver);
		ac.enterEmail(sc);
		ac.clickContinue();
		
		AccountInformationPage ai = new AccountInformationPage(driver);
		ai.enterName(randomString());
		ai.enterOrganization(randomAlphaNumeric());
		ai.clickContinue();
		
		AccountPasswordPage ap = new AccountPasswordPage(driver);
		String password = randomAlphaNumeric();
		ap.enterPassword(password);
		ap.re_EnterPassword(password);
		ap.clickContinue();
		
		VerificationCodePage vc = new VerificationCodePage(driver);
		vc.verifiedText();
		vc.verifyCode(sc);
		vc.clickVerifyEmail();
		
		
	}

	
	
}
