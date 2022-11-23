import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArtistsPage extends PageObject{
	public ArtistsPage(WebDriver driver) {
		super(driver);
	}

	public JustinPearsonPage ClickJustinPearson() {
		var justinPearsonLink = this.driver.findElement(By.cssSelector("a[href$='Justin Pearson']"));
		justinPearsonLink.click();
		
		return new JustinPearsonPage(this.driver);
	}
}
