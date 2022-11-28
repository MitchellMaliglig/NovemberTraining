package driverFactory;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

	@SuppressWarnings("unused")
	@Override
	public void createDriver() {
		var driverPath = "\\src/main/resources\\chromedriver.exe";
		var driver = getDriver();
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		setDriver();
	}

}
