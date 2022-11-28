package driverFactory;

public class DriverManagerFactory {
	public static DriverManager getManager(String browserType) {
		DriverManager driverManager = null;
		
		if (browserType.equalsIgnoreCase("chrome")) {
			driverManager = new ChromeDriverManager();
		} else if (browserType.equalsIgnoreCase("edge")) {
			driverManager = new EdgeDriverManager();
		}
		
		return driverManager;
	}
}
