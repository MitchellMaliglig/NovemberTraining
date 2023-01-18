import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.windows.WindowsDriver;

public abstract class WindowsCalculatorAutomation {
	protected Calculator calculator;
	private WindowsDriver<WebElement> driver;

	@BeforeTest
	public void setUp() {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingPort(4723);
		builder.withIPAddress("127.0.0.1");
		this.driver = launch(builder);
		this.calculator = new Calculator(driver);
	}
	
	@AfterTest
	public void cleanUp() {
		kill();
	}
	
	public WindowsDriver<WebElement> launch(AppiumServiceBuilder builder) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		capabilities.setCapability("deviceName", "WindowsPC");
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		
		return new WindowsDriver<WebElement>(service, capabilities);
	}
	
	public void kill() {
		driver.quit();
	}
}
