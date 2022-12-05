import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Foundation.TestBase;

public class ControlExtensionProjectTests extends TestBase{
  @Test
  public void selectRadioButonYes() {
	  var page = new RadioButtonPage(driver)
			  .navigate();
	  RadioGroup radioGroup = new RadioGroup(driver.findElement(By.cssSelector("[class='col-12 mt-4 col-md-6']")));
	  
	  String expectedLabel = "Yes";
	  
	  RadioButton button = radioGroup.getButton("yes");
	  button.select();
	  String label = radioGroup.getSelected();
	  
	  assertEquals(expectedLabel, label, "The labels should match");
  }
}
