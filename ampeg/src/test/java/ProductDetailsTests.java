import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ProductDetailsTests extends AmpegTests {
	@Test
	public void navigateToClassicPage() {
		var expectedUrl = "https://ampeg.com/products/classic/";

		var actualUrl = new HomePage(this.driver)
				.clickProductsLink()
				.clickClassicBassHeadsAndEnclosuresLink()
				.getUrl();

		assertEquals(actualUrl, expectedUrl, "We should be on classic page");
	}

	@Test
	public void ensureThatFirstSpecIsLfDrivers() {
		var expectedText = "LF Drivers:";

		var spec = new HomePage(this.driver)
				.clickProductsLink()
				.clickClassicBassHeadsAndEnclosuresLink()
				.clickAccessoriesLink();

		assertEquals(spec, expectedText, "the first spec should match the expected text.");
	}
}