import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArtistsPage extends PageObject{
	public ArtistsPage(WebDriver driver) {
		super(driver);
	}

	public JustinPearsonPage clickJustinPearsonLink() {
		var justinPearsonLink = this.driver.findElement(By.cssSelector("[href=#artist063]"));
		justinPearsonLink.click();
		
		return new JustinPearsonPage(this.driver);
	}
}
