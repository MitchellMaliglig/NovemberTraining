package data.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		query = "SELECT MAX(amount) FROM Payment;";
		
		var result = accessor.ExecuteSingleCell(query);
		
		print(result);
	}
	
	@Test
	public void UseViewGetFilmInfo() {
		query = "SELECT actor_info.film_info FROM actor_info WHERE first_name = 'Bob' AND last_name = 'Fawcett'";
		
		var result = accessor.ExecuteSingleCell(query);
		
		print(result);
	}
	
	@Test
	public void UseStoredProcedureGetInventoryIds() {
		query = "SELECT film_id FROM Film WHERE title = 'Alien Center'";
		
		var filmId = accessor.ExecuteSingleCell(query);
		
		query = "CALL film_in_stock(" + filmId + ", 2 , ?)";
		
		var result = accessor.ExecuteSingleColumn(query);
		
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
}
