package JUNIT;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import Backend.DataAccessJSON;
import Backend.Manager;
import Backend.RingBufferPlayers;

public class DataAccessJSON_Test {

	private Manager manager;
	private DataAccessJSON json;

	@Before
	public void initialize() throws Exception {
		json = new DataAccessJSON();
		manager = new Manager();
		manager.addPlayer("A", "RED");
		manager.addPlayer("B", "YELLOW");
		manager.addPlayer("C", "GREEN");
		manager.addPlayer("D", "BLUE");
		manager.startGame();

	}

	@Test
	public void testWriteToFile() throws IOException {

		json.writeToFile(manager.getPlayers(), "testJSON.json");
	}
	
	@Test
	public void testReadFile() throws IOException, ClassNotFoundException {
		RingBufferPlayers test = new RingBufferPlayers();
		test = (RingBufferPlayers) json.readFile("testJSON.json");
		System.out.println(test.getActivePlayer());

	}

}
