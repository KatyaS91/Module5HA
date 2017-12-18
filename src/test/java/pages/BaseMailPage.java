package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static data.TestData.LOGIN;

/**
 * Created by Katsiaryna_Skarzhyns on 12/18/2017.
 */
public class BaseMailPage extends BasePage {

	private String accountLogoXpath = "//*[contains(@title, '%s')]";
	private String exitBtnXpath = "//a[contains(text(), 'Выйти')]";
	private String writeBtnXpath = "//div[contains(@role, 'button') and contains(text(), 'НАПИСАТЬ')]";
	private String subjectXpath = "//*[@name = 'subjectbox']";
	private String bodyXpath = "//div[@role = 'textbox']";
	private String addressXpath = "//textarea[@name = 'to']";
	private String sendXpath = "//div[contains(text(), 'Отправить')]";
	private String draftBtnXpath = "//*[contains(@aria-label, 'Черновики')]";
	private String sentBtnXpath = "//*[contains(@title, 'Отправленные')]";

	public void createMail(String address, String subject, String body) throws InterruptedException {
		clickWriteBtn();
		driver.findElement(By.xpath(addressXpath)).sendKeys(address);
		driver.findElement(By.xpath(subjectXpath)).sendKeys(subject);
		driver.findElement(By.xpath(bodyXpath)).sendKeys(body);
		Thread.sleep(5000);
	}

	public boolean isPageOpened() {
		try {
			return driver.findElement(By.xpath(String.format(accountLogoXpath, LOGIN.getValue()))).isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public void clickWriteBtn() {
		driver.findElement(By.xpath(writeBtnXpath)).click();
	}

	public DraftPage openDrafts() {
		driver.findElement(By.xpath(draftBtnXpath)).click();
		return new DraftPage();
	}

	public SentPage openSentMails() throws InterruptedException {
		driver.findElement(By.xpath(sentBtnXpath)).click();
		Thread.sleep(3000);
		return new SentPage();
	}

	public void send() {
		driver.findElement(By.xpath(sendXpath)).click();
	}

	public LoginPage logOff() {
		driver.findElement(By.xpath(String.format(accountLogoXpath, LOGIN.getValue()))).click();
		driver.findElement(By.xpath(exitBtnXpath)).click();
		return new LoginPage();
	}
}