package driverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public abstract class DriverManager {
	private WebDriver driver;
	
	public abstract void createDriver();
	
	public WebDriver getDriver() {
		return driver;	
	}
	
	protected void setDriver() {
		driverSetup();
		var url = "https://www.selenium.dev/";
		
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		this.driver.navigate().to(url);
	}
	
	public void quitDriver() {
		this.driver.quit();
	}
	
	private void driverSetup() {
		if (System.getProperty("webdriver.chrome.driver") != null) {
			this.driver = new ChromeDriver();
		} else if (System.getProperty("webdriver.edge.driver") != null) {
			this.driver = new EdgeDriver();
		}
	}
}
