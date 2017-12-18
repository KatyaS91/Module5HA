package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Katsiaryna_Skarzhyns on 12/18/2017.
 */
public class SentPage extends BaseMailPage {

	private String expectedLetterXpath = "//span[contains(text(), '%s')]//ancestor::td//..//span[contains(text(), '%s')]//ancestor::td//..//div//span[contains(@email, '%s')]";

	public boolean isExpectedMailPresent(String body, String subject, String address) {
		try {
			return driver.findElements(By.xpath(String.format(expectedLetterXpath, body, subject, address))).size() > 0;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}