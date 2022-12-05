import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ControlExtensions.Angular.ControlExtension;

public class MultiSelect extends ControlExtension {
	private Select select;
	
	public MultiSelect(WebElement mappedElement) {
		super(mappedElement);
		select = new Select(mappedElement);
	}

	public void selectValues(String[] values) {
		for (int i = 0; i < values.length; i++) {
			select.selectByVisibleText(values[i]);
		}
	}
	
	public String[] getValues() {
		var valueList = mappedElement.findElements(By.tagName("option"));
		String[] valueArray;
		ArrayList<String> valueArrayList = new ArrayList<String>();
		WebElement option;
		
		for (int i = 0; i < valueList.size(); i++) {
			option = valueList.get(i);
			if (option.isSelected()) {
				valueArrayList.add(option.getText());
				}
		}
		
		valueArray = new String[valueArrayList.size()];
		for (int i = 0; i < valueArrayList.size(); i++) {
			valueArray[i] = valueArrayList.get(i);
		}
		
		return valueArray;
	}
}
