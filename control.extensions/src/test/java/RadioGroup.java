import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ControlExtensions.Angular.ControlExtension;


public class RadioGroup extends ControlExtension{
	public RadioGroup(WebElement mappedElement) {
		super(mappedElement);
	}
	
	public RadioButton getButton(String label) {
		WebElement element = null;
		
		if (label == "yes") {
			element = mappedElement.findElement(By.cssSelector("[for='yesRadio']"));
		} else if (label == "impressive") {
			element = mappedElement.findElement(By.cssSelector("[for='impressiveRadio']"));
		} else if (label == "no") {
			element = mappedElement.findElement(By.cssSelector("[for='noRadio']"));
		}
		
		return new RadioButton(element);
	}
	
	public String getSelected() {
		try {
			return mappedElement.findElement(By.cssSelector("p span")).getText();
		} catch (Exception e){
			return null;
		}
	}

}
