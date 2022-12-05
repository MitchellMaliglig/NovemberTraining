import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Foundation.TestBase;

public class RadioButtonTests extends TestBase{
	private RadioGroup radioGroup;
	
  @Test
  public void selectRadioButonYes() {
	  String expectedLabel = "Yes";
	  
	  RadioButton button = radioGroup.getButton("yes");
	  button.select();
	  String label = radioGroup.getSelected();
	  
	  assertEquals(expectedLabel, label, "The labels should match");
  }
 
 @Test
 public void selectRadioButtonImpressive() {
	 String expectedLabel = "Impressive";
	  
	 RadioButton button = radioGroup.getButton("impressive");
	 button.select();
	 String label = radioGroup.getSelected();
	  
	 assertEquals(expectedLabel, label, "The labels should match");
 }
 
 @Test
 public void selectRadioButtonNo() {
	 String expectedLabel = "No";
	  
	 RadioButton button = radioGroup.getButton("no");
	 button.select();
	 String label = radioGroup.getSelected();
	  
	 if (label != null) { 
		 assertEquals(expectedLabel, label, "The labels should match");
	 } else {
		 assertEquals(label, null, "Null should be returned if the button can't be clicked.");
	 }
 }
 
 @BeforeMethod
 public void beforeMethod() {
	 var radioPage = new RadioButtonPage(driver)
			  .navigate();
	 radioGroup = new RadioGroup(driver.findElement(By.cssSelector("[class='col-12 mt-4 col-md-6']")));
 }
}


