package data.access;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JdbcTests {
	private DatabaseUtility accessor;
	
	@BeforeMethod
	public void Setup() {
		this.accessor = new DatabaseUtility();
	}
	
	@Test
	public void canAccessDatabase() {
		var result = this.accessor.Execute("dummySQL");
  }
}
