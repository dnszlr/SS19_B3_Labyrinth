package JUNIT;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import Backend.DataAccessCSV;
import Backend.Map.Gameboard;

public class DataAccessCSV_Test {

	private Gameboard csvBoard;
	private DataAccessCSV CSV;

	@Before
	public void initialize() throws Exception {
		csvBoard = new Gameboard();
		CSV = new DataAccessCSV();
		CSV.writeToFile(csvBoard, "unitCSVTest.txt");

	}

	@Test
	public void testWriteToFile() throws IOException {

		CSV.writeToFile(csvBoard, "unitCSVTest.txt");

	}

	@Test
	public void testReadFromFile() throws ClassNotFoundException, IOException {
		
		Gameboard load =  (Gameboard) CSV.readFile("unitCSVTest.csv");
		System.out.println(load.toString());
		assertEquals(load.getMapCard(5, 4).toString(), csvBoard.getMapCard(5, 4).toString());

	}
}
