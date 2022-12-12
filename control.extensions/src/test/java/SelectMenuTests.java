import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Foundation.TestBase;

public class SelectMenuTests extends TestBase {
	private OldStyleSelect oldStyle;
	private MultiSelect multiSelect;
	
	@Test
	public void oldStyleSetGreen() {
		String expectedValue = "Green";
		
		oldStyle.setValue("Green");
		String actualValue = oldStyle.getValue();
		
		assertEquals(actualValue, expectedValue, "The value should be Green.");
	}
	
	@Test
	public void oldStyleGetOptions() {
		String[] expectedOptions = {
				"Red", "Blue", "Green", "Yellow",
				"Purple", "Black", "White", "Voilet",
				"Indigo", "Magenta", "Aqua"
		};
		
		var actualOptions = oldStyle.getOptions();
		
		assertEquals(actualOptions, expectedOptions, "Incorrect list of options.");
	}
	
	@Test
	public void MultiSelectSaabAndOpel() {
		String[] values = {"Saab", "Opel"};
		
		multiSelect.selectValues(values);
		var actualValues = multiSelect.getValues();
		
		assertEquals(actualValues, values, "Values should be Saab and Opel.");
	}

	@BeforeMethod
	 public void beforeMethod() {
		  driver.navigate().to("https://demoqa.com/select-menu");
		  oldStyle = new OldStyleSelect(driver.findElement(By.cssSelector("#oldSelectMenu")));
		  multiSelect = new MultiSelect(driver.findElement(By.cssSelector("#cars")));
	  }
}
