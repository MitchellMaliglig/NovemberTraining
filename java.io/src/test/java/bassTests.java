import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.expectThrows;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class bassTests {
	private final int MAKE = 0;
	private final int MODEL = 1;
	private final int STRINGCOUNT = 2;

	private String bassesCsvSrc = "src/test/resources\\basses.csv";
	private CSVReader reader;
	private String[] nextLine;

	@Test
	public void readModelsAndMakes() throws CsvValidationException, IOException {
		HashMap<String, String> expectedModelsAndMakes = getExpectedModelsAndMakes();

		HashMap<String, String> modelsAndMakes = new HashMap<String,String>();
		while ((nextLine = reader.readNext()) != null) {
			modelsAndMakes.put(nextLine[MODEL], nextLine[MAKE]);
		}

		assertTrue(modelsAndMakes.equals(expectedModelsAndMakes), "The hash maps should be equal.");
	}

	@Test
	public void readBasses() throws CsvValidationException, IOException {
		ArrayList<Bass> expectedBasses = getExpectedBasses();

		ArrayList<Bass> basses = new ArrayList<Bass>();
		while ((nextLine = reader.readNext()) != null) {
			basses.add(new Bass(nextLine[MAKE], nextLine[MODEL], Integer.parseInt(nextLine[STRINGCOUNT])));
		}

		for (int i = 0; i < expectedBasses.size(); i++) {
			assertEquals(basses.get(i).getMake(), expectedBasses.get(i).getMake(), "Make error");
			assertEquals(basses.get(i).getModel(), expectedBasses.get(i).getModel(), "Model error");
			assertEquals(basses.get(i).getStringCount(), expectedBasses.get(i).getStringCount(), "Stringcount error");
		}
	}

	@BeforeMethod
	public void beforeMethod() throws CsvValidationException, IOException {
		reader = new CSVReader(new FileReader(bassesCsvSrc));
		nextLine = reader.readNext();
	}

	private HashMap<String, String> getExpectedModelsAndMakes(){
		HashMap<String, String> expectedModelsAndMakes = new HashMap<String,String>();

		expectedModelsAndMakes.put("Corvette", "Warwick");
		expectedModelsAndMakes.put("Thumb", "Warwick");
		expectedModelsAndMakes.put("Streamer", "Warwick");
		expectedModelsAndMakes.put("Precision", "Fender");
		expectedModelsAndMakes.put("Jazz", "Fender");
		expectedModelsAndMakes.put("BB500", "Yamaha");

		return expectedModelsAndMakes;
	}

	private ArrayList<Bass> getExpectedBasses() {
		ArrayList<Bass> expectedBasses = new ArrayList<Bass>();

		expectedBasses.add(new Bass("Warwick", "Corvette", 5));
		expectedBasses.add(new Bass("Warwick", "Thumb", 5));
		expectedBasses.add(new Bass("Warwick", "Streamer", 5));
		expectedBasses.add(new Bass("Fender", "Precision", 4));
		expectedBasses.add(new Bass("Fender", "Jazz", 4));
		expectedBasses.add(new Bass("Yamaha", "BB500", 5));

		return expectedBasses;
	}

}
