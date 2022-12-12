package Foundation;

public class DriverManagerFactory {

	public static DriverManager getManager(String browserType) {

		if(browserType == BrowserTypes.chrome) {
			return new ChromeDriverManager();
		}
		if(browserType == BrowserTypes.edge) {
			return new EdgeDriverManager();
		}

		throw new RuntimeException(browserType + " is not a supported browsertype.");	
	}
}