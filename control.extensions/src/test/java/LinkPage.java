import org.openqa.selenium.WebDriver;

public class LinkPage extends PageObject {

	public LinkPage(WebDriver driver) {
		super(driver);
	}
	
	public LinkPage navigate() {
		this.driver.get("https://demoqa.com/links");

		return this;
	}

}
