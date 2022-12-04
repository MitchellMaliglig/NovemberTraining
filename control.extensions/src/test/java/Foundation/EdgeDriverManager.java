package Foundation;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var driverPath = "C:\\temp\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", driverPath);

		this.setDriver(new EdgeDriver());
	}
}