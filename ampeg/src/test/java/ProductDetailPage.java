import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends PageObject {

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}

	public String getArtistName() {
		var element = this.driver.findElement(By.cssSelector("#artist b"));
		
		return element.getText();
	}

	public String getFirstSpec() {
		var element = this.driver.findElement(By.cssSelector("#specs b"));
		
		return element.getText();
	}
}