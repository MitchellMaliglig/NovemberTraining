package driverFactory;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var driverPath = "src/main/resources\\msedgedriver.exe";		
		System.setProperty("webdriver.edge.driver", driverPath);
		setDriver();
	}

}
