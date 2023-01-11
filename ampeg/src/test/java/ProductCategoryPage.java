import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCategoryPage extends PageObject {

	public ProductCategoryPage(WebDriver driver) {
		super(driver);
	}

	public ProductDetailPage clickProductDetailLink() {
		var productDetailLink = this.driver.findElement(By.cssSelector("href=[svt-410hlf/]"));
		productDetailLink.click();		
		
		return new ProductDetailPage(this.driver);
	}
	
	public ProductDetailPage clickAccessoriesLink() {
		var accessoriesLink = this.driver.findElement(By.xpath("//a[@href=\"/products/classic/accessories.html\"]"));
		accessoriesLink.click();
		
		return new ProductDetailPage(this.driver);
	}
}