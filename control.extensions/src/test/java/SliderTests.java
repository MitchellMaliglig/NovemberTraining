import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Foundation.TestBase;

public class SliderTests extends TestBase{
	public Slider slider;
	
  @Test
  public void sliderValue80() {
	  String expectedValue = "80";
	  
	  slider.setValue("80");
	  String actualValue = slider.getValue();
	  
	  assertEquals(expectedValue, actualValue, "The value should be set to 80.");
  }
  
  @Test
  public void sliderValue17() {
	  String expectedValue = "17";
	  
	  slider.setValue("17");
	  String actualValue = slider.getValue();
	  
	  assertEquals(expectedValue, actualValue, "The value should be set to 17.");
  }
  
  @Test
  public void sliderValue0() {
	  String expectedValue = "0";
	  
	  slider.setValue("0");
	  String actualValue = slider.getValue();
	  
	  assertEquals(expectedValue, actualValue, "The value should be set to 0.");
  }
  
  @Test
  public void sliderValue100() {
	  String expectedValue = "100";
	  
	  slider.setValue("100");
	  String actualValue = slider.getValue();
	  
	  assertEquals(expectedValue, actualValue, "The value should be set to 100.");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver.navigate().to("https://demoqa.com/slider");
	  slider = new Slider(driver.findElement(By.cssSelector("#sliderContainer")));
  }
}
