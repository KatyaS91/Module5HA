package pages;

import org.openqa.selenium.By;


import static data.TestData.LOGIN;
import static data.TestData.PASSWORD;

/**
 * Created by Katsiaryna_Skarzhyns on 12/18/2017.
 */
public class LoginPage extends BaseMailPage {

	private String loginXpath = "//input[contains(@id, 'identifierId')]";
	private String nextBtnXpath = "//*[contains(@id, 'Next')]";
	private String passwordInputXpath = "//input[contains(@type, 'password')]";

	public BaseMailPage login() throws InterruptedException {
		driver.findElement(By.xpath(loginXpath)).sendKeys(LOGIN.getValue());
		driver.findElement(By.xpath(nextBtnXpath)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(passwordInputXpath)).sendKeys(PASSWORD.getValue());
		driver.findElement(By.xpath(nextBtnXpath)).click();
		return new BaseMailPage();
	}

	public boolean isNextBntDisplayed() {
		return driver.findElement(By.xpath(nextBtnXpath)).isDisplayed();
	}

	public boolean isPasswordInputDisplayed() {
		return driver.findElement(By.xpath(passwordInputXpath)).isDisplayed();
	}
}