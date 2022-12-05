import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ControlExtensions.Angular.ControlExtension;

public class Hyperlink extends ControlExtension {

	public Hyperlink(WebElement mappedElement) {
		super(mappedElement);
	}
	
	public void click() {
		mappedElement.click();
	}
	
	public String getResponse() {
		return mappedElement.findElement(By.xpath("//p[@id='linkResponse']")).getText();
	}

}
