package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductManualsPage extends PageObject{
	public ProductManualsPage(WebDriver driver) {
		super(driver);
	}

	public V4bPage clickV4bLink() {
		var v4bLink = this.driver.findElement(By.cssSelector("a[alt='V-4B']"));
		v4bLink.click();

		return new V4bPage(this.driver);
	}
}
