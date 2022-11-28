package driverFactory;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	@SuppressWarnings("unused")
	@Override
	public void createDriver() {
		var driverPath = "\\src/main/resources\\edgedriver.exe";
		var driver = getDriver();
		
		System.setProperty("webdriver.edge.driver", driverPath);
		driver = new EdgeDriver();
		setDriver();
	}

}
