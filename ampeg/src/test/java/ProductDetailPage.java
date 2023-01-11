import java.util.ArrayList;

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
	
	public String getSvt810eTitle() {
		var element = this.driver.findElement(By.cssSelector("#svt810e > div > div > div > div > div > div > div > div > h2"));
		
		return element.getText();
	}
	
	public String[] getClassicAccessories() {
		var elements = this.driver.findElements(By.xpath("//h3[@class='h3-title blue-title']"));
		var elementsArrayList = new ArrayList<String>();
		
		for (var x : elements) {
			elementsArrayList.add(x.getText());
		}
		
		var elementsArray = new String[elementsArrayList.size()];
		for (int i = 0; i < elementsArray.length; i++) {
			elementsArray[i] = elementsArrayList.get(i);
		}
		
		return elementsArray;
	}
}