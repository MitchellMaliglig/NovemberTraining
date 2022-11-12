package data.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DatabaseUtility implements DatabaseAccessor {
	private String sakila = "jdbc:mysql://localhost:3306/sakila?useSSL=false";
	private String username = Credentials.username;
	private String password = Credentials.password;

	@Override
	public String[] ExecuteSingleColumn(String sql) {
		String[] columnName = null;
		String columnValue;
		
		String[] columnValuesArray = null;
		ArrayList<String> columnValuesArrayList = new ArrayList<String>();

		try (Connection connection = DriverManager.getConnection(sakila, username, password);
				Statement statement = connection.createStatement();) {

			if (isStoredProcedure(sql)) {
				var procedure = connection.prepareCall(sql);
				ResultSet rs = procedure.executeQuery();
				columnName = getColumns(rs);
				procedure.registerOutParameter(1, java.sql.Types.INTEGER);
				
				while (rs.next()) {
					String value = rs.getString(columnName[0]);
			        columnValuesArrayList.add(value);
			        }
			} else {
				ResultSet rs = statement.executeQuery(sql);
				columnName = getColumns(rs);

				while (rs.next()) {
					columnValue = rs.getString(columnName[0]);
					columnValuesArrayList.add(columnValue);
				}
			}
			columnValuesArray = transferValues(columnValuesArrayList);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return columnValuesArray;
	}

	@Override
	public String ExecuteSingleCell(String sql) {
		String value[] = ExecuteSingleColumn(sql);
		return value[0];
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
	
	private String[] getColumns(ResultSet rs) {
		String[] columns = null;
		int columnCount;
		
		ResultSetMetaData rsMetaData;
		try {
			rsMetaData = rs.getMetaData();
			columnCount = rsMetaData.getColumnCount();
			columns = new String[columnCount];
			
			for(int i = 1; i <= columnCount; i++) {
				columns[i - 1] = rsMetaData.getColumnName(i);
				}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return columns;
	}
	
	private String[] transferValues(ArrayList<String> arrayList) {
		String[] array = new String[arrayList.size()];
		
		for(int i = 0; i < arrayList.size(); i++) {
			array[i] = arrayList.get(i);
		}
		
		return array;
	}
	
	private boolean isStoredProcedure(String sql) {
		StringTokenizer st = new StringTokenizer(sql, " ", false);
		String str = st.nextToken(); 
		boolean storedProcedure = false;

		if (str.equalsIgnoreCase("CALL")) {
			storedProcedure = true;
		}

		return storedProcedure;
	}
}
