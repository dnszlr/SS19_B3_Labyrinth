package JUNIT;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import Backend.Figure.Figure;
import Backend.Color;
import Backend.DataAccessJSON;
import Backend.Manager;
import Backend.RingBufferPlayers;

public class DataAccessJSON_Test {

	private Manager manager;
	private DataAccessJSON json;
	private RingBufferPlayers players;

	@Before
	public void initialize() throws Exception {
		json = new DataAccessJSON();
		manager = new Manager();
		players = new RingBufferPlayers();
		players.addFigure(new Figure("A", Color.RED));
		players.addFigure(new Figure("B", Color.BLUE));
		manager.startGame();

	}

	@Test
	public void testWriteToFile() throws IOException {

		json.writeToFile(this.players.getActivePlayer(), "testJSOHON.json");
		System.out.println(this.players.getActivePlayer());

	}
	
	@Test
	public void testReadFile() throws IOException, ClassNotFoundException {
		RingBufferPlayers test = new RingBufferPlayers();
		json.readFile("testJSOHON.json");
		System.out.println(test.getActivePlayer());
		test.nextPlayer();
		System.out.println(test.getActivePlayer());

	}

}
