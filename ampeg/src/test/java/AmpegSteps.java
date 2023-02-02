
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ArtistsPage;
import pages.ContactPage;
import pages.FaqPage;
import pages.HomePage;
import pages.JustinPearsonPage;
import pages.PageObject;
import pages.ProductCategoryPage;
import pages.ProductDetailPage;
import pages.ProductDirectoryPage;
import pages.ProductManualsPage;
import pages.V4bPage;
import tests.AutomatedTestCases;

public class AmpegSteps{
	private PageObject page;
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void beforeScenario() {
		this.baseUrl = "https://www.ampeg.com/";
		this.launchDriver();
	}
	
	@After
	public void afterScenario() {
		this.driver.quit();
	}
	
	private void launchDriver() {
		var driverPath = "C:\\Users\\mitch\\Downloads\\chromedriver_win32 (1)\\chromedriver109.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Given("^I am on the home page$")
	public void userOnHomePage() throws Throwable {
		driver.navigate().to(this.baseUrl);
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

	@Then("I should be on the classic cabs page")
	public void i_should_be_on_the_classic_cabs_page() {
		var expectedUrl = "https://ampeg.com/products/classic/cabs.html";

		var url = page.getUrl();

		assertEquals(url, expectedUrl, "Classic cabs page should be displayed.");
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
	}

	@When("I click the accessories link")
	public void i_click_the_accessories_link() {
		page = new ProductCategoryPage(this.driver);
		((ProductCategoryPage) page).clickAccessoriesLink();
	}

	@Then("I should see classic accessories")
	public void i_should_see_classic_accessories() {
		String[] expectedAccessories = { 
				"SVT-CL / SVT-VR Cover",
				"SVT-810 Cover",
				"SVT-610HLF Cover",
				"SVT-410HLF Cover",
				"SVT-410HE Cover",
				"SVT-15E Cover"
		};

		page = new ProductDetailPage(this.driver);
		var accessories = ((ProductDetailPage) page).getClassicAccessories();

		assertEquals(accessories, expectedAccessories, "Classic accessories should be displayed.");
	}
}
