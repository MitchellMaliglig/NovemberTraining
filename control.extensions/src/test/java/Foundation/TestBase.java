package Foundation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
	protected DriverManager manager;
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		var browserType = "chrome";
		this.manager = DriverManagerFactory.getManager(browserType);
		this.manager.createDriver();
		this.driver = manager.getDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void cleanup() {
		if(this.driver != null) {
			this.manager.quitDriver();
		}
	}
}