import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import ControlExtensions.Angular.ControlExtension;

public class Slider extends ControlExtension {

	public Slider(WebElement mappedElement) {
		super(mappedElement);
	}
	
	public void setValue(String value) {
		int currentValueInt = Integer.parseInt(mappedElement.findElement(By.cssSelector("#sliderValue")).getAttribute("value"));
		int valueInt = Integer.parseInt(value);
		int difference = Math.abs(currentValueInt - valueInt);
		
		if (valueInt < currentValueInt) {
			for (int i = 1; i <= difference; i++) {
	            mappedElement.findElement(By.cssSelector("[type=range]")).sendKeys(Keys.ARROW_LEFT);
	        }
		} else if (valueInt > currentValueInt) {
			for (int i = 1; i <= difference; i++) {
				mappedElement.findElement(By.cssSelector("[type=range]")).sendKeys(Keys.ARROW_RIGHT);
	        }
		}
	}
	
	public String getValue() {
		return mappedElement.findElement(By.cssSelector("#sliderValue")).getAttribute("value");
	}

}
