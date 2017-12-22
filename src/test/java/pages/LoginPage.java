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

	private String loginCss = "#identifierId";
	private String nextBtnCss = "div [id*= 'Next']";
	private String passwordInputCss = "input[type = 'password'";

	public BaseMailPage login() {
		driver.findElement(By.cssSelector(loginCss)).sendKeys(LOGIN.getValue());
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector(nextBtnCss)));
		driver.findElement(By.cssSelector(nextBtnCss)).click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(passwordInputCss)));
		driver.findElement(By.cssSelector(passwordInputCss)).sendKeys(PASSWORD.getValue());
		driver.findElement(By.cssSelector(nextBtnCss)).click();
		return new BaseMailPage();
	}

	public boolean isNextBntDisplayed() {
		return driver.findElement(By.cssSelector(nextBtnCss)).isDisplayed();
	}

	public boolean isPasswordInputDisplayed() {
		return driver.findElement(By.cssSelector(passwordInputCss)).isDisplayed();
	}
}