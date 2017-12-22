package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseMailPage;
import pages.DraftPage;
import pages.LoginPage;
import pages.SentPage;

/**
 * Created by Katsiaryna_Skarzhyns on 12/18/2017.
 */
public class SendMailTest extends BaseTestPage {

	private static final String ADDRESS = "KatyaS91@mail.ru";
	private static final String SUBJECT = "The test subject";
	private static final String BODY = "Bla bla";

	@Test(description = "Check sending", groups = "p0")
	public void sent_mail() throws InterruptedException {

		LoginPage loginPage = new LoginPage();
		BaseMailPage baseMailPage = loginPage.login();
		baseMailPage.createMail(ADDRESS, SUBJECT, BODY);
		DraftPage draftPage = baseMailPage.openDrafts();
		Assert.assertTrue(draftPage.sendDraft(0), "The mail doesn't disappear from drafts");
		SentPage sentPage = draftPage.openSentMails();
		Assert.assertTrue(sentPage.isExpectedMailPresent(BODY, SUBJECT, ADDRESS), "Expected mail doesn't present in the folder");
	}
}