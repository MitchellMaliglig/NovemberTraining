package driverFactory;

public class DriverManagerFactory {
	public static DriverManager getManager(String browserType) {
		if (browserType.equals("chrome")) {
			return null;
		} else if (browserType.equals("edge")) {
			return null;
		}
		return null;
	}
}
