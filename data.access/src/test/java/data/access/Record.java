package data.access;

public class Record implements DataRow {
	private String[] records;
	
	public Record(int columnCount) {
		records = new String[columnCount];
	}
	
	@Override
	public String[] GetColumns() {
		return records;
	}
	
	public void addRecord(String record, int columnIndex) {
		records[columnIndex] = record;
	}

}
