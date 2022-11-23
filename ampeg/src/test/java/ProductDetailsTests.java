import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ProductDetailsTests extends AmpegTests {
	@Test
	public void ensureArtistIsDisplayedOnProductDetailsPage() {
		var expectedArtistName = "Bootsy Collins";

		var artistName = new HomePage(this.driver)
				.clickProductsLink()
				.clickClassicBassHeadsAndEnclosuresLink()
				.clickProductDetailLink()
				.getArtistName();

		assertEquals(artistName, expectedArtistName, "product details page should contain artist name.");
	}

	@Test
	public void ensureThatFirstSpecIsLfDrivers() {
		var expectedText = "LF Drivers:";

		var spec = new HomePage(this.driver)
				.clickProductsLink()
				.clickClassicBassHeadsAndEnclosuresLink()
				.clickProductDetailLink()
				.getFirstSpec();

		assertEquals(spec, expectedText, "the first spec should match the expected text.");
	}
}