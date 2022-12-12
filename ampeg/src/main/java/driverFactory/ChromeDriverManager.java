package driverFactory;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var driverPath = "src/main/resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		setDriver();
	}

}
