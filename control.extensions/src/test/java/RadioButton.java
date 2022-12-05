import org.openqa.selenium.WebElement;

import ControlExtensions.Angular.ControlExtension;

public class RadioButton extends ControlExtension{

	public RadioButton(WebElement mappedElement) {
		super(mappedElement);
	}
	
	public void select() {
		mappedElement.click();
	}

}
