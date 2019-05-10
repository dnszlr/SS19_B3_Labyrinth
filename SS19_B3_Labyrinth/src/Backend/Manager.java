package Backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Backend.Cards.ObjectCard;
import Backend.Figure.Figure;
import Backend.Map.Gameboard;
import Backend.Map.MazeCard;
import Interface.Communication;

public class Manager implements Communication {

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
	 * Getter für die Spieler.
	 */
	@Override
	public String[] getPlayers() {
		List<String> getPlayers = new ArrayList<String>();

		for (int i = 0; i <= Color.YELLOW.getPos()[0]; i++) {
			for (int j = 0; j <= Color.GREEN.getPos()[1]; j++) {
				if (gameboard.getMapCard(i, j).getFigures().size() > 0) {
					for (int y = 0; y < gameboard.getMapCard(i, j).getFigures().size(); y++) {
						getPlayers.add(gameboard.getMapCard(i, j).getFigures().get(y).toString());
					}
				}
			}
		}
		String[] players = getPlayers.toArray(new String[0]);
		return players;

	}

	/**
	 * Getter für den Spieler der gerade am Zug ist.
	 */
	@Override
	public String getActivePlayer() {

		String activePlayer = players.getActivePlayer().toString();
		return activePlayer;
	}

	/**
	 * Getter für die Treasure Karte des Spielers der gerade am Zug ist.
	 */
	@Override
	public String getActivePlayerTreasureCard() {
		String activePlayerTreasureCard = players.getActivePlayer().getTreasureCard().toString();
		return activePlayerTreasureCard;
	}

	/**
	 * Getter für die bereits gefunden Treasures.
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
	 * Methode um Spieler dem Spiel hinzuzufügen.
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

		boolean result = false;

		result = gameboard.moveFigure(position, players.getActivePlayer().getPos(), players.getActivePlayer());
		if (result == true) {
			gameboard.getMapCard(position[0], position[1]).addFigure(players.getActivePlayer());
		}

		return result;
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
	 */
	// SPEICHERN UND LADEN UND DESWEGEN ALLES ANS STRING ZURÜCKGEBEN? FOLIEN s269?
	@Override
	public String saveGame(String path, String type) {
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
