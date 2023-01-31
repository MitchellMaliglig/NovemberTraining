package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaqPage extends PageObject{
	public FaqPage(WebDriver driver) {
		super(driver);
	}

	public String getPageTitle() {
		var address = this.driver.findElement(By.cssSelector("h2[class='text-center']"));
		
		return address.getText();
	}
}
