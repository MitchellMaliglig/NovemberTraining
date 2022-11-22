package data.access;

public interface DatabaseAccessor {
	String[] ExecuteSingleColumn(String sql, boolean isStoredProcedure);
	
	String ExecuteSingleCell(String sql, boolean isStoredProcedure);
	
	DataRow[] Execute(String sql, boolean isStoredProcedure);
}
