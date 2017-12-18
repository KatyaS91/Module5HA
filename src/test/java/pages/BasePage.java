package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

/**
 * Created by Katsiaryna_Skarzhyns on 12/18/2017.
 */
public class BasePage {

	public static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void base_setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	}
}