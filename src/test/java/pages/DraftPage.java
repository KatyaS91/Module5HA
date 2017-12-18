package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


/**
 * Created by Katsiaryna_Skarzhyns on 12/18/2017.
 */
public class DraftPage extends BaseMailPage {

	private String subjectLabelXpath = "//span[contains(text(), '%s')]";
	private String draftsXpath = "//div[@role = 'main']//table//tr";
	private String successMsgXpath = "//div[contains(text(), 'Письмо отправлено')]";

	public boolean isExpectedDraftSubjectPresent(String expectedSubject) {
		try {
			return driver.findElement(By.xpath(String.format(subjectLabelXpath, expectedSubject))).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public boolean isExpectedDraftBodyDisplayed(String expectedBody) {
		try {
			return  driver.findElement(By.xpath(String.format(subjectLabelXpath, expectedBody))).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public boolean sendDraft (int draftOrder) throws InterruptedException {
		driver.findElements(By.xpath(draftsXpath)).get(0).click();
		BaseMailPage baseMailPage = new BaseMailPage();
		baseMailPage.send();
		Thread.sleep(3000);
		return driver.findElement(By.xpath(successMsgXpath)).isDisplayed();
	}
}