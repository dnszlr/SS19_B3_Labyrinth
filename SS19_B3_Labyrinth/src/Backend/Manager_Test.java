package Backend;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class Manager_Test {

	Manager manager;

	@Before
	public void initialize() throws IOException {
		manager = new Manager();
		manager.addPlayer("Player1", "RED");
		manager.addPlayer("Player2", "BLUE");
		manager.addPlayer("Player3", "GREEN");
		manager.startGame();
		manager.saveGame("test.ser", "Serialization");

	}

	@Test
	public void testGetMap() {

		String[][] map = manager.getMap();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				assertTrue(map[i][j] != null);
			}
		}

	}

	@Test
	public void testGetPlayers() {

		String[] players = manager.getPlayers();
		assertTrue(players.length == 3);
	}

	@Test
	public void testGetActivePlayer() {
		String player1 = manager.getActivePlayer();
		String activePlayer = manager.getPlayers()[0];
//		System.out.println(player1);
//		System.out.println(activePlayer);
		assertEquals(player1, activePlayer);

	}

	@Test
	public void testGetActivePlayerTreasureCard() {

		String activePlayerTreasureCard = manager.getActivePlayerTreasureCard();
		assertTrue(activePlayerTreasureCard != null);
//		System.out.println(activePlayerTreasureCard);
	}

	@Test
	public void testGetFoundTreasures() {

		String found = manager.getFoundTreasures("GREEN");
		assertTrue(found.equals("[]"));
	}

	@Test
	public void testAddPlayer() {
		String player4 = manager.addPlayer("Player4", "YELLOW");
		String check = manager.getPlayers()[3];
		assertEquals(player4, check);
//		System.out.println(manager.addPlayer("Player3", "GREEN"));

	}

	@Test
	public void testStartGame() {
		manager.startGame(); // wie testen?
	}

	@Test
	public void testMoveGears() {

		String[][] map = manager.getMap();
		manager.moveGears("A2");
		assertTrue(manager.moveGears("G2").equals("Couldn't move, try again with other position"));
		String[][] map2 = manager.getMap();
		assertEquals(manager.getFreeMazeCard(), map[1][6]);
		assertEquals(map[1][5], map2[1][6]);

	}

	@Test
	public void testHasWon() {

		assertTrue(manager.hasWon().equals("notWon"));

	}

	@Test
	public void testEndRound() {

		String player = manager.getPlayers()[1];
		String nextPlayer = manager.endRound();
//		System.out.println(nextPlayer);
//		System.out.println(player);
		assertNotEquals(nextPlayer, player);
		manager.moveGears("A2");
		String nextPlayerMoved = manager.endRound();
//		System.out.println(nextPlayerMoved);
		assertEquals(nextPlayerMoved, player);
	}

	@Test
	public void testGetFreeMazeCard() {

		String[][] map = manager.getMap();
		manager.moveGears("A6");
		assertEquals(manager.getFreeMazeCard(), map[5][6]);
	}

	@Test
	public void testRotateGears() {

		String freeCard = manager.getFreeMazeCard();
		String rotateRight = manager.rotateGear("right");
		assertNotEquals(freeCard, rotateRight);
		String rotateLeft = manager.rotateGear("left");
		assertEquals(freeCard, rotateLeft);
		String rotateWrong = manager.rotateGear("lft");
		assertTrue(rotateWrong.equals("Wrong direction use 'left' or 'right'"));
	}

	@Test
	public void testSaveGame() throws IOException {
		this.manager.saveGame("test.ser", "Serialization");
		assertEquals(this.manager.saveGame("test.ser", "Serialization"), "Game saved successfully!");
	}

	@Test
	public void testLoadGame() throws ClassNotFoundException, IOException {
		manager.addPlayer("Player3", "YELLOW");
		
		manager.loadGame("test.ser", "Serialization");
		System.out.println(manager.getActivePlayer());
		assertEquals(manager.getActivePlayer(), this.manager.getActivePlayer());
		
	}

	@Test
	public void testMoveFigure() {

		int[] position = { 1, 0 };
		this.manager.moveFigure(position);

	}
}
