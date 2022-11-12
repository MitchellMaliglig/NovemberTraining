package data.access;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JdbcTests {
	private DatabaseUtility accessor;
	private String query;
	
	@BeforeMethod
	public void Setup() {
		this.accessor = new DatabaseUtility();
	}
	
	@Test
	public void canAccessDatabase() {
		accessor.testConnection();
	}
	
	@Test
	public void TenCitiesDesc() {
		query = "(SELECT city FROM City LIMIT 10) ORDER BY city DESC";
		
		var result = accessor.ExecuteSingleColumn(query);
		
		print(result);
	}
	
	@Test
	public void HighestPaymentAmount() {
		
	}
	
	@Test
	public void UseViewGetFilmInfo() {
		
	}
	
	@Test
	public void UseStoredProcedureGetInventoryIds() {
		
	}
	
	private void print(String[] values) {
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
}
