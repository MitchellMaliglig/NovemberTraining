package ControlExtensions.Angular;

import org.openqa.selenium.WebElement;

public abstract class ControlExtension {

	protected WebElement mappedElement;

	public ControlExtension(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
}