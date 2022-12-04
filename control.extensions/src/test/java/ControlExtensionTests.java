import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Foundation.TestBase;

public class ControlExtensionTests extends TestBase {
	@Test
	public void canSetTextboxValue() {
		var value = "Dennis";

		var actualValue = new ComplicatedPage(driver)
				.navigate()
				.setUserName(value)
				.getUserName();

		assertEquals(actualValue, value, "the value should be set using a Control Extension.");
	}
	
	@Test
	public void canSetEmailAddress() {
		var value = "me2@aol.com";
		
		var actualValue = new ComplicatedPage(driver)
				.navigate()
				.setEmailAddress(value)
				.getEmailAddress();
		
		assertEquals(actualValue, value, "the value should be set using a Control Extension.");
	}
	
	@Test
	public void canGetEmailAddressTextboxLabel() {
		var value = "Email Address";
		
		var actualValue = new ComplicatedPage(driver)
				.navigate()
				.getEmailAddressLabel();
		
		assertEquals(actualValue, value, "the label should be as expected.");
	}
	
	@Test
	public void canFillOutForm() {
		var name = "Dennis";
		var email = "sdkfd@aol.com";
		var message = "hello world!";

		var page = new ComplicatedPage(driver);

		page.navigate()
			.enterFormDetails(name, email, message);
		
		var actualNameValue = page.getName();
		var actualEmailValue = page.getEmail();
		var actualMessageValue = page.getMessage();
		
		assertEquals(actualNameValue, name, "the name should be as expected.");
		assertEquals(actualEmailValue, email, "the email should be as expected.");
		assertEquals(actualMessageValue, message, "the message should be as expected.");
	}
}