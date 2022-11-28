import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import driverFactory.DriverManager;
import driverFactory.DriverManagerFactory;

public class DriverFactoryTestBase {
	DriverManager manager;
	
	@Test
	public void chromeTest() {
		manager = DriverManagerFactory.getManager("chrome");
		manager.createDriver();
		var driver = manager.getDriver();
		
		var expectedUrl = "https://www.selenium.dev/";
		
		var url = driver.getCurrentUrl();
		
		assertEquals(expectedUrl, url, "The url should be " + expectedUrl);
	}
	
	@Test
	public void edgeTest() {
		manager = DriverManagerFactory.getManager("edge");
		manager.createDriver();
		var driver = manager.getDriver();
		
		var expectedUrl = "https://www.selenium.dev/";
		
		var url = driver.getCurrentUrl();
		
		assertEquals(expectedUrl, url, "The url should be " + expectedUrl);
	}
	
	@AfterMethod 
	public void cleanup(){
		manager.quitDriver();;
	}
}
