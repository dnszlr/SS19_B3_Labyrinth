package JUNIT;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import Backend.DataAccessCSV;
import Backend.Manager;

public class DataAccessCSV_Test {

	Manager manager;
	DataAccessCSV CSV;

	@Before
	public void initialize() throws Exception {
		manager = new Manager();
		CSV = new DataAccessCSV();
		manager.addPlayer("Hans", "GREEN");
		manager.addPlayer("Han", "YELLOW");
		manager.addPlayer("Ha", "RED");
		manager.addPlayer("H", "BLUE");
		manager.startGame();

	}

	@Test
	public void testWriteToFile() throws IOException {

		CSV.writeToFile(manager, "unitCSVTest.txt");

	}

	@Test
	public void testReadFromFile() throws ClassNotFoundException, IOException {
		CSV.writeToFile(manager, "unitCSVTest.txt");
		Manager a = (Manager) CSV.readFile("unitCSVTest.txt");
		assertEquals(a.getFreeMazeCard(), manager.getFreeMazeCard());

	}
}
