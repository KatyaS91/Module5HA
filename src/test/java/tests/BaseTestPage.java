package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

import static data.TestData.URL;

/**
 * Created by Katsiaryna_Skarzhyns on 12/18/2017.
 */
public class BaseTestPage extends BasePage {

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		driver.get(URL.getValue());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void cleanUp() {
		driver.quit();
	}
}