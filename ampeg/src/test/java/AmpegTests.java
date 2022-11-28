import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AmpegTests {

	protected WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		this.launchDriver();
	}

	@AfterMethod
	public void Cleanup() {
		this.quitDriver();
	}

	private void quitDriver() {
		if(this.driver == null) {
			return;
		}
		this.driver.quit();
	}

	private void launchDriver() {
		var driverPath = "C:\\Users\\mitch\\Downloads\\chromedriver.exe";
		var url = "https://www.ampeg.com/";
		System.setProperty("webdriver.chrome.driver", driverPath);

		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		this.driver.navigate().to(url);
	}
}