package JUNIT;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import Backend.Manager;

public class Manager_Test {

	Manager manager;

	@Before
	public void initialize() throws Exception {
		manager = new Manager();
		manager.addPlayer("Player1", "RED");
		manager.addPlayer("Player2", "BLUE");
		manager.addPlayer("Player3", "GREEN");
		manager.startGame();

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
	public void testGetFoundTreasures() throws Exception {

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
	public void testStartGame() throws Exception {
		manager.startGame();
	}

	@Test
	public void testMoveGears() throws Exception {

		String[][] map = manager.getMap();
		manager.moveGears("A2");
		String[][] map2 = manager.getMap();
		assertEquals(manager.getFreeMazeCard(), map[1][6]);
		assertEquals(map[1][5], map2[1][6]);
		assertTrue(manager.moveGears("G2").equals("Couldn't move, try again with other position"));
		manager.moveGears("A4");
		assertTrue(manager.moveGears("G4").equals("Couldn't move, try again with other position"));
		manager.moveGears("A6");
		assertTrue(manager.moveGears("G6").equals("Couldn't move, try again with other position"));
		manager.moveGears("G2");
		assertTrue(manager.moveGears("A2").equals("Couldn't move, try again with other position"));
		manager.moveGears("G4");
		assertTrue(manager.moveGears("A4").equals("Couldn't move, try again with other position"));
		manager.moveGears("G6");
		assertTrue(manager.moveGears("A6").equals("Couldn't move, try again with other position"));
		manager.moveGears("B1");
		assertTrue(manager.moveGears("B7").equals("Couldn't move, try again with other position"));
		manager.moveGears("D1");
		assertTrue(manager.moveGears("D7").equals("Couldn't move, try again with other position"));
		manager.moveGears("F1");
		assertTrue(manager.moveGears("F7").equals("Couldn't move, try again with other position"));
		manager.moveGears("B7");
		assertTrue(manager.moveGears("B1").equals("Couldn't move, try again with other position"));
		manager.moveGears("D7");
		assertTrue(manager.moveGears("D1").equals("Couldn't move, try again with other position"));
		map = manager.getMap();
		manager.moveGears("F7");
		assertTrue(manager.moveGears("F1").equals("Couldn't move, try again with other position"));
		assertEquals(manager.getFreeMazeCard(), map[0][5]);
	}

	@Test
	public void testHasWon() throws Exception {

		assertTrue(manager.hasWon().equals("notWon"));

	}

	@Test
	public void testEndRound() throws Exception {

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
	public void testGetFreeMazeCard() throws Exception {

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
		this.manager.saveGame("test.ser", "serialization");
		assertTrue(this.manager.saveGame("test.ser", "serialization").equals("Game saved successfully!"));
		this.manager.saveGame("testCSV", "csv");
	}

	@Test
	public void testLoadGame() throws ClassNotFoundException, IOException {

		manager.loadGame("test.ser", "Serialization");

		assertEquals(manager.getActivePlayer(), this.manager.getActivePlayer());

	}

	@Test
	public void testMoveFigure() {

		int[] position = { 1, 0 };
		this.manager.moveFigure(position);

	}
}
