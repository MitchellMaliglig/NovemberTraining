import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Foundation.TestBase;

public class HyperlinkTest extends TestBase {

	@Test
	public void getCreatedLinkTest() {
		LinkPage linkPage = new LinkPage(driver)
				.navigate();
		
		Hyperlink link = new Hyperlink(driver.findElement(By.cssSelector("#created")));
		link.click();
		
		String expectedText = "Link has responded with staus 201 and status text Created";
		
		String text = link.getResponse();
		
		assertEquals(text, expectedText, "The text should be equal.");
	}

}
