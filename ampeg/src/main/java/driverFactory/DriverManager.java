package driverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	private WebDriver driver;
	
	public abstract void createDriver();
	
	public WebDriver getDriver() {
		return driver;	
	}
	
	protected void setDriver() {
		var url = "https://www.selenium.dev/";
		
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		this.driver.navigate().to(url);
	}
	
	public void quitDriver() {
		this.driver.quit();
	}
}
