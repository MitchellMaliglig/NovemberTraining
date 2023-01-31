package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class V4bPage extends PageObject{

	public V4bPage(WebDriver driver) {
		super(driver);
	}
	
	public V4bManual clickQuickStartGuideEnglish () {
		var quickStartGuideEnglishLink = this.driver.findElement(By.cssSelector("a[href*='Quick Start Guide - English']"));
		quickStartGuideEnglishLink.click();
		
		return new V4bManual(this.driver);
	}

}
