package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import static org.testng.Assert.assertEquals;

public class ProductDetailsTests extends AmpegTests {
	@Test
	public void navigateToClassicPage() {
		var expectedUrl = "https://ampeg.com/products/classic/";

		var actualUrl = new HomePage(driver.get())
				.clickProductsLink()
				.clickClassicBassHeadsAndEnclosuresLink()
				.getUrl();

		assertEquals(actualUrl, expectedUrl, "We should be on classic page");
	}

	@Test
	public void ensureThatClassicProductsAreDisplayed() {
		String[] expectedProducts = { 
				"SVT-CL / SVT-VR Cover",
				"SVT-810 Cover",
				"SVT-610HLF Cover",
				"SVT-410HLF Cover",
				"SVT-410HE Cover",
				"SVT-15E Cover"
		};

		var products = new HomePage(driver.get())
				.clickProductsLink()
				.clickClassicBassHeadsAndEnclosuresLink()
				.clickAccessoriesLink()
				.getClassicAccessories();

		assertEquals(products, expectedProducts, "Classic accessories should be displayed.");
	}
}