package Foundation;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	private WebDriver driver;
	
	public abstract void createDriver();
	
	public WebDriver getDriver() {
		return this.driver;
	}

	public void quitDriver() {
		this.driver.quit();
	}
	
	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}	
}