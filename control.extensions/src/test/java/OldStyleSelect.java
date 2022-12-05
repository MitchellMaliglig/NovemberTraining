import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ControlExtensions.Angular.ControlExtension;

public class OldStyleSelect extends ControlExtension {
	private Select select;
	
	public OldStyleSelect(WebElement mappedElement) {
		super(mappedElement);
		select = new Select(mappedElement);
	}
	
	public void setValue(String value) {
		select.selectByVisibleText(value);
	}
	
	public String getValue() {
		String value = null;
		boolean found = false;
		
		var options = mappedElement.findElements(By.tagName("option"));
		WebElement option = null;
		
		for (int i = 0; i < options.size() && !found; i++) {
			option = options.get(i);
			if (option.isSelected()) {
				value = option.getText();
				found = true;
				}
		}
	   
	   return value;
	}
	
	public String[] getOptions(){
		var optionList = mappedElement.findElements(By.tagName("option"));
		String[] optionsArray = new String[optionList.size()];
		
		for (int i = 0; i < optionList.size(); i++) {
			optionsArray[i] = optionList.get(i).getText();
		}
		
		return optionsArray;
	}

}
