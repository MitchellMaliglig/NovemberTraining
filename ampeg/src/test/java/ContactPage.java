import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends PageObject{

	public ContactPage(WebDriver driver) {
		super(driver);
	}

	public FaqPage clickFaqLink() {
		var faqLink = this.driver.findElement(By.cssSelector("a[href $= 'faq']"));
		faqLink.click();
		
		return new FaqPage(this.driver);
	}

	public ProductManualsPage clickProductManualsLink() {
		var productManualsLink = this.driver.findElement(By.cssSelector("a[href $= 'manuals/']"));
		productManualsLink.click();
		
		return new ProductManualsPage(this.driver);
	}
}
