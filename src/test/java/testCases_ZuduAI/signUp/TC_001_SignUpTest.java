package testCases_ZuduAI.signUp;

import java.util.Scanner;

import org.testng.annotations.Test;

import pageObject_ZuduAI.signUp.AccountCreationPage;
import pageObject_ZuduAI.signUp.AccountInformationPage;
import pageObject_ZuduAI.signUp.AccountPasswordPage;
import pageObject_ZuduAI.signUp.SignUpPage;
import pageObject_ZuduAI.signUp.VerificationCodePage;
import testBase_ZuduAI.BaseClass;

public class TC_001_SignUpTest extends BaseClass {
	
	Scanner sc = new Scanner(System.in);
	@Test
	public void test_AccountCreation() throws InterruptedException {
		
		try {
			
		logger.info("*** Starting TC_001_AccountCreationTest ***");
		SignUpPage hp = new SignUpPage(driver);
		hp.click_SignUp();
		
		logger.info("Clicked on SignUp");
		AccountCreationPage ac = new AccountCreationPage(driver);
		ac.enterEmail(sc);
		ac.clickContinue();
		
		logger.info("Account Creation Page");
		AccountInformationPage ai = new AccountInformationPage(driver);
		ai.enterName(randomString());
		ai.enterOrganization(randomAlphaNumeric());
		ai.clickContinue();
		
		logger.info("Account Password Page");
		AccountPasswordPage ap = new AccountPasswordPage(driver);
		String password = randomAlphaNumeric();
		System.out.println("SignUp Password: "+password);
		ap.enterPassword(password);
		ap.re_EnterPassword(password);
		ap.clickContinue();
		
		logger.info("Verified Code Page");
		VerificationCodePage vc = new VerificationCodePage(driver);
		vc.verifiedText();
		vc.verifyCode(sc);
		vc.clickVerifyEmail();
		
		logger.info("Account Successful Page");
		
		} catch (Exception e) {
			logger.error("Test Failed");
		}
		
		
	}

	
	
}
