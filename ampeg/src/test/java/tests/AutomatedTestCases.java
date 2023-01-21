package tests;

import listeners.ListenersTestNG;

import static org.testng.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

@Listeners(ListenersTestNG.class)
public class AutomatedTestCases extends AmpegTests{
	@Test
	public void verifyFaqPageTitle() {
		var expectedPageTitle = "Frequently Asked Questions (FAQs)";

		var pageTitle = new HomePage(this.driver)
				.clickProductsLink()
				.clickContactLink()
				.clickFaqLink()
				.getPageTitle();

		assertEquals(expectedPageTitle, pageTitle, "\"Frequently Asked Questions (FAQs)\" should be displayed as the title.");
	}

	@Test
	public void navigateToSvt810eThroughJustinPearson() {
		var expectedUrl = "https://ampeg.com/products/classic/cabs.html";

		var url = new HomePage(this.driver)
				.clickArtistsLink()
				.clickJustinPearsonLink()
				.clickSvt810eLink()
				.getUrl();

		assertEquals(expectedUrl, url, "The SVT-810E page should be displayed.");
	}

	@Test
	public void openV4bEnglishQuickStartGuideAndVerifyThatContactInfoIsFound() throws IOException {
		var expectedContactInfo = "Yamaha Guitar Group, Inc.\r\n"
				+ "26580 Agoura Road\r\n"
				+ "Calabasas, CA 91302-1921\r\n"
				+ "(818) 575-3600\r\n"
				+ "https://ampeg.com/";

		var pdfUrl = new HomePage(this.driver)
				.clickProductsLink()
				.clickContactLink()
				.clickProductManualsLink()
				.clickV4bLink()
				.clickQuickStartGuideEnglish()
				.getUrl();

		var pdfContent = readPdfContent(pdfUrl);

		Assert.assertTrue(pdfContent.contains(expectedContactInfo), "Contact info should be found in the V-4B English Quick Start Guide");
	}

	@Test
	public void homePageUrl() {
		var expectedUrlThatIsActuallyWrong = "incorrect home page url.com";

		var actualHomePageUrl = new HomePage(this.driver)
				.getUrl();

		Assert.assertEquals(actualHomePageUrl, expectedUrlThatIsActuallyWrong, "Test failed as expected");
	}

	@Test  
	public void SkipTest() {
		throw new SkipException("Skipping The Test Method ");
	}

	public static String readPdfContent(String url) throws IOException {	
		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);

		PDDocument doc = PDDocument.load(bf);
		String content = new PDFTextStripper().getText(doc);
		doc.close();

		return content;
	}
}
