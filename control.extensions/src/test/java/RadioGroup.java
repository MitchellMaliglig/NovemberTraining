import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
		
		if (element == null) {
			System.out.println("null");
		}
		return new RadioButton(element);
	}
	
	public String getSelected() {
		//return radioSelected.getText();
		return mappedElement.findElement(By.cssSelector("p span")).getText(); 
	}

}
