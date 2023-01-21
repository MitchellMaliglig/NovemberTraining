package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDirectoryPage extends PageObject {

	public ProductDirectoryPage(WebDriver driver) {
		super(driver);
	}

	public ProductCategoryPage clickClassicBassHeadsAndEnclosuresLink() {
		var productLink = this.driver.findElement(By.cssSelector("img[alt='Classic Series: Bass heads & enclosures']"));
		productLink.click();	
		
		return new ProductCategoryPage(this.driver);
	}

	public ContactPage clickContactLink() {
		var contactLink = this.driver.findElement(By.cssSelector("a > img[name='contact']"));
		contactLink.click();
		
		return new ContactPage(this.driver);
	}
}