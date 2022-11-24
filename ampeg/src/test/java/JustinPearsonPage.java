import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JustinPearsonPage extends PageObject{

	public JustinPearsonPage(WebDriver driver) {
		super(driver);
	}

	public ProductDetailPage clickSvt810eLink() {
		var svt810eLink = this.driver.findElement(By.cssSelector("ul > li > a[href$='svt810e']"));
		svt810eLink.click();
		
		return new ProductDetailPage(this.driver);
	}

}
