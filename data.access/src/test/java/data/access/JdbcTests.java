package data.access;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JdbcTests {
	private DatabaseUtility accessor;
	private String connectionString = "jdbc:mysql://localhost:3306/sakila?useSSL=false";
	private String username = Credentials.username;
	private String password = Credentials.password;
	private String query;
	
	@BeforeMethod
	public void Setup() {
		this.accessor = new DatabaseUtility(connectionString, username, password);
	}
	
	@Test
	public void canAccessDatabase() {
		accessor.testConnection();
	}
	
	@Test
	public void TenCitiesDesc() {
		query = "(SELECT * FROM City LIMIT 10) ORDER BY city DESC";
		
		var result = accessor.Execute(query, false);
		
		print(result);
	}
	
	@Test
	public void HighestPaymentAmount() {
		query = "SELECT MAX(amount) FROM Payment;";
		
		var result = accessor.ExecuteSingleCell(query, false);
		
		print(result);
	}
	
	@Test
	public void UseViewGetFilmInfo() {
		query = "SELECT actor_info.film_info FROM actor_info WHERE first_name = 'Bob' AND last_name = 'Fawcett'";
		
		var result = accessor.ExecuteSingleCell(query, false);
		
		print(result);
	}
	
	@Test
	public void UseStoredProcedureGetInventoryIds() {
		query = "SELECT film_id FROM Film WHERE title = 'Alien Center'";
		
		var filmId = accessor.ExecuteSingleCell(query, false);
		
		query = "CALL film_in_stock(" + filmId + ", 2 , ?)";
		
		var result = accessor.ExecuteSingleColumn(query, true);
		
		print(result);
	}
	
	private void print(String[] values) {
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
	
	private void print(String value) {
		System.out.println(value);
	}
	
	private void print(DataRow[] records) {
		int columnCount = records[0].GetColumns().length;
		String[] values = null;
		
		for (int i = 0; i < records.length; i++) {
			values = records[i].GetColumns();
			
			for (int j = 0; j < columnCount; j++) {
				System.out.print(values[j] + " ");
			}
			System.out.println();
		}
	}
}
