package ControlExtensions.Angular;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextArea extends ControlExtension {

	public TextArea(WebElement mappedElement) {
		super(mappedElement);
	}

	public void setValue(String value) {
		getInputElement().sendKeys(value);
	}
	
	public String getValue() {
		return getInputElement().getAttribute("value");
	}

	private WebElement getInputElement() {
		return this.mappedElement.findElement(By.tagName("textarea"));
	}
}