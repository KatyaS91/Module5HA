package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static data.TestData.LOGIN;
import static data.TestData.PASSWORD;

/**
 * Created by Katsiaryna_Skarzhyns on 12/18/2017.
 */
public class LoginPage extends BaseMailPage {

	private String loginXpath = "//input[contains(@id, 'identifierId')]";
	private String nextBtnXpath = "//*[contains(@id, 'Next')]";
	private String passwordInputXpath = "//input[contains(@type, 'password')]";

	public BaseMailPage login() {
		driver.findElement(By.xpath(loginXpath)).sendKeys(LOGIN.getValue());
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath(nextBtnXpath)));
		driver.findElement(By.xpath(nextBtnXpath)).click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordInputXpath)));
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