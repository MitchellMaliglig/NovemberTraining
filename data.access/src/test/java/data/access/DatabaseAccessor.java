package data.access;

public interface DatabaseAccessor {
	String[] ExecuteSingleColumn(String sql);
	
	String ExecuteSingleCell(String sql);
	
	DataRow[] Execute(String sql);
}
