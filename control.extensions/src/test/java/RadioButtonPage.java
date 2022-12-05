import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends PageObject {

	public RadioButtonPage(WebDriver driver) {
		super(driver);
	}
	
	public RadioButtonPage navigate() {
		this.driver.get("https://demoqa.com/radio-button");

		return this;
	}

}
