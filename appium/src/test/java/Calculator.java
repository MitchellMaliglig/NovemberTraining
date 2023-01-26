import java.util.HashMap;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.windows.WindowsDriver;

public class Calculator {
	private WindowsDriver<RemoteWebElement> driver;

	public Calculator(WindowsDriver<RemoteWebElement> driver) {
		this.driver = driver;
	}

	private String getMapping(String buttonLabel) {
		HashMap<String, String> idsByLabel = new HashMap<String,String>();
		idsByLabel.put("1", "num1Button");
		idsByLabel.put("3", "num3Button");
		idsByLabel.put("+", "plusButton");
		idsByLabel.put("=", "equalButton");
		idsByLabel.put("-", "minusButton");

		return idsByLabel.get(buttonLabel);
	}

	public String add(String first, String second) {
		var result = doOperation(first, second, "+");
		return result;
	}

	public String subtract(String first, String second) {
		var result = doOperation(first, second, "-");
		return result;
	}

	private String doOperation(String first, String second, String buttonLabel) {
		driver.findElementByAccessibilityId(getMapping(first)).click();
		driver.findElementByAccessibilityId(getMapping(buttonLabel)).click();
		driver.findElementByAccessibilityId(getMapping(second)).click();
		driver.findElementByAccessibilityId(getMapping("=")).click();

		var element = driver.findElementByAccessibilityId("CalculatorResults");
		return element.getText().replace("Display is ", "");
	}

}
