
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmpegSteps extends AmpegTests{
	PageObject page;
	
	@Given("^I am on the home page$")
    public void userOnHomePage() throws Throwable {
        launchDriver();
    }
	
	@Given("I click on products link")
	public void i_click_on_products_link() {
		page = new HomePage(this.driver);
		((HomePage)page).clickProductsLink();
	}

	@Given("I click on contact link")
	public void i_click_on_contact_link() {
		page = new ProductDirectoryPage(this.driver);
		((ProductDirectoryPage)page).clickContactLink();
	}
	@When("^I click on FAQ link$")
    public void userClicksFAQLink() throws Throwable {
		page = new ContactPage(this.driver);
        ((ContactPage)page).clickFaqLink();
    }
	
	@Then("^I should see the FAQ title$")
    public void userCanSeeFAQTitle() throws Throwable {
		page = new FaqPage(this.driver);
        var pageTitle = ((FaqPage)page).getPageTitle();
        String expectedPageTitle = "Frequently Asked Questions (FAQs)";
        
		assertEquals(expectedPageTitle , pageTitle, "\"Frequently Asked Questions (FAQs)\" should be displayed as the title.");
		Cleanup();
    }
	
	@Given("I click on product manuals link")
	public void i_click_on_product_manuals_link() {
		page = new ContactPage(this.driver);
		((ContactPage) page).clickProductManualsLink();
	}

	@Given("I click on V4B link")
	public void i_click_on_v4b_link() {
		page = new ProductManualsPage(this.driver);
		((ProductManualsPage) page).clickV4bLink();
	}

	@When("I click on quick start guide english")
	public void i_click_on_quick_start_guide_english() {
		page = new V4bPage(this.driver);
		((V4bPage) page).clickQuickStartGuideEnglish();
	}

	@Then("I should see contact info listed")
	public void i_should_see_contact_info_listed() throws IOException {
		var expectedContactInfo = "Yamaha Guitar Group, Inc.\r\n"
				+ "26580 Agoura Road\r\n"
				+ "Calabasas, CA 91302-1921\r\n"
				+ "(818) 575-3600\r\n"
				+ "https://ampeg.com/";
		
		var pdfUrl = page.getUrl();
		
		var pdfContent = AutomatedTestCases.readPdfContent(pdfUrl);
		
		Assert.assertTrue(pdfContent.contains(expectedContactInfo), "Contact info should be found in the V-4B English Quick Start Guide");
		Cleanup();
	}

	@Given("I click on the artists link")
	public void i_click_on_the_artists_link() {
		page = new HomePage(this.driver);
	    ((HomePage) page).clickArtistsLink();
	}

	@Given("I click on Justin Pearson")
	public void i_click_on_justin_pearson() {
		page = new ArtistsPage(this.driver);
	    ((ArtistsPage) page).clickJustinPearsonLink();
	}

	@When("I click on SVT810E link")
	public void i_click_on_svt810e_link() {
		page = new JustinPearsonPage(this.driver);
	    ((JustinPearsonPage) page).clickSvt810eLink();
	}

	@Then("I should be able to see SVT810E product")
	public void i_should_be_able_to_see_svt810e_product() {
		var expectedProduct = "SVT-810E";
		
	    page = new ProductDetailPage(this.driver);
	    var product = ((ProductDetailPage) page).getSvt810eTitle();
	    
	    assertEquals(product, expectedProduct, "Product should be SVT-810E");
	}
	
	@When("I click classic bass heads and enclosures")
	public void i_click_classic_bass_heads_and_enclosures() {
	    page = new ProductDirectoryPage(this.driver);
	    ((ProductDirectoryPage) page).clickClassicBassHeadsAndEnclosuresLink();
	}

	@Then("I should see the classic page")
	public void i_should_see_the_classic_page() {
		var expectedUrl = "https://ampeg.com/products/classic/";

		var actualUrl = (page).getUrl();

		assertEquals(actualUrl, expectedUrl, "We should be on classic page");
		Cleanup();
	}
}
