
import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmpegSteps extends AmpegTests{
	PageObject page;
	
	@Given("^I am on the home page$")
    public void userOnHomePage() throws Throwable {
        launchDriver();
    }
	
	@Given("I Click on products link")
	public void i_click_on_products_link() {
		page = new HomePage(this.driver);
		((HomePage)page).clickProductsLink();
	}

	@Given("I Click on contact link")
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

}
