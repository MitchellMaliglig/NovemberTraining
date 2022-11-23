import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ManualTestCases extends AmpegTests{
	@Test
	public void navigateToFaqPage() {
		var expectedUrl = "https://ampeg.com/faq/";
		
		var url = new HomePage(this.driver)
				.clickProductsLink()
				.clickContactLink()
				.clickFaqLink()
				.driver.getCurrentUrl();
		
		assertEquals(expectedUrl, url, "The FAQ page should be displayed.");
	}
	
	@Test
	public void navigateToSvt810eThroughJustinPearson() {
		var expectedUrl = "https://ampeg.com/products/classic/svt810e/";
		
		var url = new HomePage(this.driver)
				.clickArtistsLink()
				.ClickJustinPearson();
	}
	
	@Test
	public void navigateToProductManualsPage() {
		
	}
}
