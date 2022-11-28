package driverFactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	private WebDriver driver;
	
	public abstract void createDriver();
	
	public WebDriver getDriver() {
		return driver;	
	}
	
	protected void setDriver() {
		
	}
	
	public void quitDriver() {
		this.driver.quit();
	}
}
