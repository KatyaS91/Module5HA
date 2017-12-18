package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseMailPage;
import pages.LoginPage;


/**
 * Created by Katsiaryna_Skarzhyns on 12/18/2017.
 */
public class LoginTest extends BaseTestPage {

	@Test(description = "Check login form", groups = "p0")
	public void login_test() throws InterruptedException {
		LoginPage login = new LoginPage();
		BaseMailPage baseMailPage = login.login();
		Assert.assertTrue(baseMailPage.isPageOpened(), "Account page was opened");
	}
}