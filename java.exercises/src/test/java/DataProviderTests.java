
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests {
	@Test
	public void canGetStateName() {
		var expectedState = "Texas";

		var actualState = States.Texas.Name;

		Assert.assertEquals(actualState,expectedState,"state name should be returned.");
	}

	@Test
	public void canGetStateAbbreviation() {
		var expectedAbbreviation = "TX";

		var actualAbbreviation = States.Texas.Abbreviation;

		Assert.assertEquals(actualAbbreviation,expectedAbbreviation,"abbreviation should "
				+ "be returned.");
	}
	
	@Test
	public void canGetStateNameFromObjectMother() {
		var expectedState = "Louisiana";
		
		var actualState = getState(LocationObjectMothers.NewOrleans());
		
		Assert.assertEquals(actualState.Name, expectedState, "state should be returned.");
	}
	
	@Test
	public void canGetStateNameCalifornia() {
		var expectedState = "California";
		
		var actualState = States.California.Name;
		
		Assert.assertEquals(actualState, expectedState, "California should be returned.");
	}
	
	@Test
	public void canGetCaliforniaAbbreviation() {
		var expectedAbbreviation = "CA";
		
		var actualAbbreviation = States.California.Abbreviation;
		
		Assert.assertEquals(actualAbbreviation, expectedAbbreviation, "CA should be returned.");
	}
	
	@Test
	public void canGetStateNameCaliforniaFromLocationObjectMother() {
		var expectedState = "California";
		
		var actualState = getState(LocationObjectMothers.LosAngeles());
		
		Assert.assertEquals(actualState.Name, expectedState, "California should be returned.");
	}
	
	private State getState(LocationObjectMother mother) {	
		return mother.State;
	}
}