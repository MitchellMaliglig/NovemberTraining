
import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmpegSteps extends AmpegTests{
	PageObject page;
	
	@Given("^I am on the home page$")
    public void userOnHomePage() throws Throwable {
        launchDriver();
        page = new HomePage(this.driver);
    }
	
	@And("^I click on products link$")
    public void userClicksProductsLink() throws Throwable {
        ((HomePage)page).clickProductsLink();
    }
	
	@And("^I click on contact link$")
    public void userClicksContactLink() throws Throwable {
        ((ProductDirectoryPage)page).clickContactLink();
    }
	
	@When("^I click on FAQ link$")
    public void userClicksFAQLink() throws Throwable {
        ((ContactPage)page).clickFaqLink();
    }
	
	@Then("^I should see the FAQ title$")
    public void userCanSeeFAQTitle() throws Throwable {
        var pageTitle = ((FaqPage)page).getPageTitle();
        String expectedPageTitle = "Frequently Asked Questions (FAQs)";
        
		assertEquals(expectedPageTitle , pageTitle, "\"Frequently Asked Questions (FAQs)\" should be displayed as the title.");
    }

}
