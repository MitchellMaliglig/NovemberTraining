package data.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class DatabaseUtility implements DatabaseAccessor {
	private String connectionString;
	private String username;
	private String password;

	public DatabaseUtility(String connectionString, String username, String password) {
		this.connectionString = connectionString;
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String[] ExecuteSingleColumn(String sql, boolean isStoredProcedure) {
		String[] columnName = null;	
		String[] valuesArray = null;
		
		ResultSet rs = null;

		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
				Statement statement = connection.createStatement();) {

			rs = prepareResultSet(rs, connection, statement, sql, isStoredProcedure);			
			columnName = getColumns(rs);
			valuesArray = getValuesArray(rs, columnName[0]);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return valuesArray;
	}

	@Override
	public String ExecuteSingleCell(String sql, boolean isStoredProcedure) {
		String value[] = ExecuteSingleColumn(sql, isStoredProcedure);
		return value[0];
	}

	@Override
	public DataRow[] Execute(String sql, boolean isStoredProcedure) {
		String[] columns = null;
		Record[] recordsArray = null;
		
		ResultSet rs = null;
		
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
				Statement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
			
			rs = prepareResultSet(rs, connection, statement, sql, isStoredProcedure);	
			columns = getColumns(rs);
			recordsArray = getRecordsArray(rs, columns, columns.length);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return recordsArray;
	}
	
	public void testConnection() {
		try (Connection connection = DriverManager
				.getConnection(connectionString, username, password);){
			} catch (SQLException e) {
	            System.out.println(e);
			}
	}
	
	private ResultSet prepareResultSet(ResultSet rs, Connection con, Statement stmt, String sql, boolean isStoredProcedure) {
		try {
			if (isStoredProcedure) {
				var procedure = con.prepareCall(sql);
				rs = procedure.executeQuery();
				procedure.registerOutParameter(1, java.sql.Types.INTEGER);
			} else {
				rs = stmt.executeQuery(sql);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return rs;
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
	
	private String[] getValuesArray(ResultSet rs, String columnName) {
		String columnValue;
		String[] columnValuesArray;
		ArrayList<String> columnValuesArrayList = new ArrayList<String>();
		
		try {
			while (rs.next()) {
				columnValue = rs.getString(columnName);
				columnValuesArrayList.add(columnValue);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		columnValuesArray = transferValues(columnValuesArrayList);
		
		return columnValuesArray;
	}
	
	private String[] transferValues(ArrayList<String> arrayList) {
		String[] array = new String[arrayList.size()];
		
		for(int i = 0; i < arrayList.size(); i++) {
			array[i] = arrayList.get(i);
		}
		
		return array;
	}
	
	private Record[] getRecordsArray(ResultSet rs, String[] columns, int columnCount) {
		Record[] recordsArray = null;
		ArrayList<Record> recordsArrayList = new ArrayList<Record>(); 
		String columnValue;
		
		try {
			while (rs.next()) {
				Record record = new Record(columnCount);
				
				for (int i = 0; i < columns.length; i++) {
					columnValue = rs.getString(columns[i]);
					record.addRecord(columnValue, i);
				}
				recordsArrayList.add(record);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		recordsArray = transferRecords(recordsArrayList);
		
		return recordsArray;
	}
	
	private Record[] transferRecords(ArrayList<Record> arrayList) {
		Record[] array = new Record[arrayList.size()];
		
		for(int i = 0; i < arrayList.size(); i++) {
			array[i] = arrayList.get(i);
		}
		
		return array;
	}
}
