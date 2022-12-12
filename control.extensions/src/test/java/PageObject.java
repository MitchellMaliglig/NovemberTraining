import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
	protected WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		
		InitPageFactory();
	}

	private void InitPageFactory() {
		PageFactory.initElements(this.driver, this);
	}
}