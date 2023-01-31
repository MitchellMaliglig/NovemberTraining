package pages;

import org.openqa.selenium.WebDriver;

public abstract class PageObject {
	protected WebDriver driver;
	
	protected PageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
}