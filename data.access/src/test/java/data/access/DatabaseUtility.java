package data.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DatabaseUtility implements DatabaseAccessor {
	private String sakila = "jdbc:mysql://localhost:3306/sakila?useSSL=false";
	private String username = Credentials.username;
	private String password = Credentials.password;

	@Override
	public String[] ExecuteSingleColumn(String sql) {
		String columnName;
		String columnValue;
		
		String[] columnValuesArray = null;
		ArrayList<String> columnValuesArrayList = new ArrayList<String>();

		try (Connection connection = DriverManager.getConnection(sakila, username, password);
				Statement statement = connection.createStatement();) {

			columnName = getColumnName(sql);

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				columnValue = rs.getString(columnName);
				columnValuesArrayList.add(columnValue);
			}
			columnValuesArray = transferValues(columnValuesArrayList);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return columnValuesArray;
	}

	@Override
	public String ExecuteSingleCell(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataRow[] Execute(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void testConnection() {
		try (Connection connection = DriverManager
				.getConnection(sakila, username, password);){
			} catch (SQLException e) {
	            System.out.println(e);
			}
	}

	private String getColumnName(String sql) {
		StringTokenizer st = new StringTokenizer(sql, " ", false);
		String columnName = st.nextToken();

		while (!lastSixChars(columnName).equals("SELECT")) {
			columnName = st.nextToken();
		}
		columnName = st.nextToken();

		return columnName;
	}

	private String lastSixChars(String str) {
		String substring = str.length() > 6 ? str.substring(str.length() - 6) : str;

		return substring;
	}
	
	private String[] transferValues(ArrayList<String> arrayList) {
		String[] array = new String[arrayList.size()];
		
		for(int i = 0; i < arrayList.size(); i++) {
			array[i] = arrayList.get(i);
		}
		
		return array;
	}
}
