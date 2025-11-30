package testCases_ZuduAI.logIn;

import org.testng.annotations.Test;

import pageObject_ZuduAI.logIn.LogInNavigateEmailPage;
import pageObject_ZuduAI.logIn.LogInNavigatePasswordPage;
import pageObject_ZuduAI.logIn.LogInPage;
import testBase_ZuduAI.BaseClass;

public class TC_001_LoginTest extends BaseClass {

	@Test
	public void test_Login() {

		try {
			logger.info("*** Start TC_001_LoginTest ***");
			LogInPage lp = new LogInPage(driver);
			lp.clickLoginButton();

			logger.info("Enter E-mail Id and Click Continue");
			LogInNavigateEmailPage lep = new LogInNavigateEmailPage(driver);
			lep.loginEmail(rb.getString("userID"));
			lep.clickContinue();

			logger.info("Enter Password and Click Continue");
			LogInNavigatePasswordPage lpp = new LogInNavigatePasswordPage(driver);
			lpp.loginPassword(rb.getString("userPASS"));
			lpp.clickContinue();
			logger.info("*** LogIn Successful ***");

		} catch (Exception e) {
			logger.error("*** Test Failed ***");
		}
	}
}
