package data.access;

import java.sql.Connection;
import java.sql.DriverManager;
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
		Record[] recordsArray = null;
		
		String[] columns = null;
		String columnValue;
		
		try (Connection connection = DriverManager.getConnection(sakila, username, password);
				Statement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {

			if (isStoredProcedure(sql)) {
				var procedure = connection.prepareCall(sql);
				ResultSet rs = procedure.executeQuery();
				recordsArray = new Record[getRowCount(rs)];
				
				columns = getColumns(rs);
				int columnCount = columns.length;
				int recordCount = 0;

				procedure.registerOutParameter(1, java.sql.Types.INTEGER);
				
				while (rs.next()) {
					recordsArray[recordCount] = new Record(columnCount);
					for (int i = 0; i < columns.length; i++) {
						columnValue = rs.getString(columns[i]);
						recordsArray[recordCount].addRecord(columnValue, i);
					}
					recordCount++;
			        }
			} else {
				ResultSet rs = statement.executeQuery(sql);
				recordsArray = new Record[getRowCount(rs)];
				
				columns = getColumns(rs);
				int columnCount = columns.length;
				int recordCount = 0;

				while (rs.next()) {
					recordsArray[recordCount] = new Record(columnCount);
					for (int i = 0; i < columns.length; i++) {
						columnValue = rs.getString(columns[i]);
						recordsArray[recordCount].addRecord(columnValue, i);
					}
					recordCount++;
				}	
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return recordsArray;
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
	
	private int getRowCount(ResultSet rs) {
		int rowCount = 0;
		
		try {
			rs.last();
			rowCount = rs.getRow();
			rs.absolute(0);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return rowCount;
	}
}
