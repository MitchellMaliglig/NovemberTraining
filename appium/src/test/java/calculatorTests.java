import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class calculatorTests extends WindowsCalculatorAutomation{

	@Test
	public void canDoBasicAddition() {
		var one = "1";
		var three = "3";
		var result = "4";
		
		var actualResult = this.calculator.add(one,three);
		
		assertEquals(actualResult, result, "They should be the same sum.");
	}
	
	@Test
	public void canDoBasicSubtraction() {
		var one = "1";
		var three = "3";
		var result = "2";
		
		var actualResult = this.calculator.subtract(three,one);
		
		assertEquals(actualResult, result, "They should be the same difference.");
	}
}
