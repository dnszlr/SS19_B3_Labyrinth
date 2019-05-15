package Backend;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class DataAccessSER_Test {
	
	Manager manager;
	DataAccessSER DAS;
	
	@Before
	public void initialize() throws Exception {
		manager = new Manager();
		DAS = new DataAccessSER();
		manager.addPlayer("Hans", "GREEN");
		manager.addPlayer("Han", "YELLOW");
		manager.addPlayer("Ha", "RED");
		manager.addPlayer("H", "BLUE");
		manager.startGame();
		
	}
	
	@Test
	public void testWriteToFile() throws IOException {
		
		DAS.writeToFile(manager, "unitSaveTest.ser", "Serialization");
		
	}
	
	@Test
	public void testReadFromFile() throws ClassNotFoundException, IOException {
		DAS.writeToFile(manager, "unitLoadTest.ser", "Serialization");
		Manager a = (Manager) DAS.readFile("unitLoadTest.ser", "Serialization");
		assertEquals(a.getFreeMazeCard(), manager.getFreeMazeCard());
		
		
	}

}
