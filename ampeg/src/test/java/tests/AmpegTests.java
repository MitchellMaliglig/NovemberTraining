package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AmpegTests {

	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected String baseUrl;

	@BeforeMethod
	public void beforeMethod() {
		this.baseUrl = "https://www.ampeg.com/";
		this.launchDriver();
	}

	@AfterMethod
	public void Cleanup() {
		this.quitDriver();
	}

	private void quitDriver() {
		if(driver.get() == null) {
			return;
		}
		driver.get().quit();
	}

	private void launchDriver() {
		var driverPath = "C:\\Users\\mitch\\Downloads\\chromedriver_win32 (1)\\chromedriver109.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver.set(new ChromeDriver());
		
		driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().navigate().to(this.baseUrl);
	}
}