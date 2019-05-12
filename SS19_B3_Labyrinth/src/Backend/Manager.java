package Backend;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Backend.Cards.ObjectCard;
import Backend.Figure.Figure;
import Backend.Map.Gameboard;
import Interface.Communication;

public class Manager implements Communication, Serializable {

	/**
	 * Klasse Manager implementiert das Interface Communication.
	 */

	/**
	 * Attribute der Klasse Manager.
	 */
	private Color color;
	private Treasure treasure;
	private Gameboard gameboard;
	private RingBufferPlayers players;
	private ArrayList<ObjectCard> objectCards;
	private boolean isMoveFigure;
	private boolean isPlaceMazeCard;

	/**
	 * Getter von der Map des Gameboards.
	 */
	@Override
	public String[][] getMap() {

		String[][] map = new String[Color.YELLOW.getPos()[0]][Color.GREEN.getPos()[1]];
		for (int i = 0; i <= map.length; i++) {
			for (int j = 0; j <= map[i].length; j++) {
				map[i][j] = gameboard.getMapCard(i, j).toString();
			}
		}

		return map;
	}

	/**
	 * Getter f�r die Spieler.
	 */
	@Override
	public String[] getPlayers() {
		List<String> getPlayers = new ArrayList<String>();
		Figure safer = players.getActivePlayer();
		players.nextPlayer();
		getPlayers.add(players.getActivePlayer().toString());
		while (!players.getActivePlayer().equals(safer)) {
			players.nextPlayer();
			getPlayers.add(players.getActivePlayer().toString());
		}

//		for (int i = 0; i <= Color.YELLOW.getPos()[0]; i++) {
//			for (int j = 0; j <= Color.GREEN.getPos()[1]; j++) {
//				if (gameboard.getMapCard(i, j).getFigures().size() > 0) {
//					for (int y = 0; y < gameboard.getMapCard(i, j).getFigures().size(); y++) {
//						getPlayers.add(gameboard.getMapCard(i, j).getFigures().get(y).toString());
//					}
//				}
//			}
//		}
		String[] players = getPlayers.toArray(new String[0]);
		return players;

	}

	/**
	 * Getter f�r den Spieler der gerade am Zug ist.
	 */
	@Override
	public String getActivePlayer() {

		String activePlayer = players.getActivePlayer().toString();
		return activePlayer;
	}

	/**
	 * Getter f�r die Treasure Karte des Spielers der gerade am Zug ist.
	 */
	@Override
	public String getActivePlayerTreasureCard() {
		String activePlayerTreasureCard = players.getActivePlayer().getTreasureCard().toString();
		return activePlayerTreasureCard;
	}

	/**
	 * Getter f�r die bereits gefunden Treasures.
	 */
	@Override
	public String getFoundTreasures(String color) {
		Figure safer = players.getActivePlayer();
		Color playerColor = Color.valueOf(color);
		while (!players.getActivePlayer().getColor().equals(playerColor)) {
			players.nextPlayer();
		}
		String foundCards = players.getActivePlayer().getFoundCards();
		while (!players.getActivePlayer().equals(safer)) {
			players.nextPlayer();
		}

		return foundCards;

	}

	/**
	 * Methode um Spieler dem Spiel hinzuzuf�gen.
	 */
	@Override
	public String addPlayer(String name, String color) {

		String addPlayer = "Wrong color or name";
		if (!name.equals(null) && (color.toLowerCase().equals("red") || color.toLowerCase().equals("blue")
				|| color.toLowerCase().equals("yellow") || color.toLowerCase().equals("green"))) {
			Color playerColor = Color.valueOf(color);
			this.players.addFigure(new Figure(name, playerColor));
			addPlayer = new Figure(name, playerColor).toString();
		}

		return addPlayer;
	}

	/**
	 * Methode um das Spiel zu starten.
	 */
	@Override
	public String startGame() {

		this.gameboard = new Gameboard();
		this.players = new RingBufferPlayers();
		for (Treasure i : Treasure.values()) {
			objectCards.add(new ObjectCard(i));
		}
		Collections.shuffle(objectCards);
		String startGame = getMap() + ";" + getPlayers() + ";" + objectCards.toString();
		return startGame;
	}

	/**
	 * Methode um die Wegkarten zu bewegen.
	 */
	@Override
	public String moveGears(String position) {

		gameboard.moveGears(PositionsCard.valueOf(position), gameboard.getFreeCard());
		return gameboard.getFreeCard().toString();
	}

	/**
	 * Methode um die Spielfiguren zu bewegen.
	 */
	@Override
	public boolean moveFigure(int[] position) {

		this.isPlaceMazeCard = false;

		this.isPlaceMazeCard = gameboard.moveFigure(position, players.getActivePlayer().getPos(), players.getActivePlayer());
		if (this.isPlaceMazeCard == true) {
			gameboard.getMapCard(position[0], position[1]).addFigure(players.getActivePlayer());
		}

		return this.isPlaceMazeCard;
	}

	/**
	 * Methode um den Sieger zu ermitteln.
	 */
	@Override
	public String hasWon() {
		String result = "notWon";
		if (players.getActivePlayer().isAllFound() == true) {
			result = players.getActivePlayer().toString();
		}
		return result;
	}

	/**
	 * Methode um eine Runde zu beenden.
	 */
	@Override
	public String endRound() {

		players.nextPlayer();
		return players.getActivePlayer().toString();
	}

	/**
	 * Methode um das Spiel zu speichern.
	 * 
	 * @throws IOException
	 */
	// SPEICHERN UND LADEN FOLIEN s269
	@Override
	public String saveGame(String path, String type) throws IOException {
		PrintWriter pw = null;
		try {
			DataAccessSER dataAccessSer = new DataAccessSER();
			dataAccessSer.writeToStream(new PrintWriter(type));
			pw = new PrintWriter(new FileWriter(path));
			dataAccessSer.writeToStream(pw);
		}
		finally {
			if(pw != null) pw.close();
		}
		return null;
	}

	/**
	 * Methode um ein gespeichertes Spiel zu laden.
	 */
	@Override
	public String loadGame(String path, String type) {
		return null;
	}

	/**
	 * Methode um eine freie Labyrintkarte zu erfragen.
	 */
	@Override
	public String getFreeMazeCard() {

		String freeCard = gameboard.getFreeCard().toString();
		return freeCard;
	}

	/**
	 * Methode um ein Feld zu drehen.
	 */
	@Override
	public String rotateGear(String direction) {
		String rotateGear = null;
		// Exception schreiben falls Direction nicht left oder right.
		if (direction.toLowerCase().equals("left")) {
			gameboard.getFreeCard().rotateLeft();
			rotateGear = gameboard.getFreeCard().toString();
		} else if (direction.toLowerCase().equals("right")) {
			gameboard.getFreeCard().rotateRight();
			rotateGear = gameboard.getFreeCard().toString();
		} else {
			rotateGear = "Wrong direction use left or right";
		}

		return rotateGear;
	}

}
