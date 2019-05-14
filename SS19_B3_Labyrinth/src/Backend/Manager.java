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
	private RingBufferPlayers players = new RingBufferPlayers();
	private ArrayList<ObjectCard> objectCards;
	private boolean isMoveFigur = false;
	private boolean isPlaceMazeCard;
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor der Klasse Manager
	 */

	public Manager() {

	}

	/**
	 * Getter der Map des Gameboards.
	 */
	@Override
	public String[][] getMap() {

		String[][] map = new String[7][7];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {

				String card = gameboard.getMapCard(i, j).toString();
				map[i][j] = card;
			}
		}

		return map;
	}

	/**
	 * Getter für die Spieler die am Spiel teilnehmen.
	 */
	@Override
	public String[] getPlayers() {
		List<String> getPlayers = new ArrayList<String>();
		Figure safer = players.getActivePlayer();

		do {
			getPlayers.add(players.getActivePlayer().toString());
			players.nextPlayer();
		} while (!players.getActivePlayer().equals(safer));

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

		String addPlayer = "Name can't be null or color name must be red, yellow, green or blue";
		if (name != null && (color.toLowerCase().equals("red") || color.toLowerCase().equals("blue")
				|| color.toLowerCase().equals("yellow") || color.toLowerCase().equals("green"))) {
			Color playerColor = Color.valueOf(color);
			Figure newPlayer = new Figure(name, playerColor);
			if (this.players.addFigure(newPlayer)) {
				addPlayer = newPlayer.toString();
			} else {
				addPlayer = "No duplicated colors allowed!";
			}
		}
		return addPlayer;
	}

	/**
	 * Methode um das Spiel zu starten.
	 */
	@Override
	public String startGame() {

		this.objectCards = new ArrayList<ObjectCard>();
		this.gameboard = new Gameboard();
		for (Treasure i : Treasure.values()) {
			objectCards.add(new ObjectCard(i));
		}
		Collections.shuffle(objectCards);
		Figure[] participants = new Figure[getPlayers().length];
		for (int i = 0; i < participants.length; i++) {
			participants[i] = players.nextPlayer();
		}
		while (objectCards.size() > 0) {

			players.getActivePlayer().addCard(objectCards.get(0));
			objectCards.remove(0);
			if (players.getActivePlayer().getTreasureCard() == null) {
				players.getActivePlayer().drawCard();

			}

			players.nextPlayer();

		}

		gameboard.placeFigures(participants);

		String startGame = getMap() + ";" + objectCards.toString();
		return startGame;
	}

	/**
	 * Methode um die Wegkarten zu bewegen.
	 */
	@Override
	public String moveGears(String position) {

		gameboard.moveGears(PositionsCard.valueOf(position), gameboard.getFreeCard());
		this.isMoveFigur = true;
		return gameboard.getFreeCard().toString();
	}

	/**
	 * Methode um die Spielfiguren zu bewegen.
	 */
	@Override
	public boolean moveFigure(int[] position) {
		boolean result = false;
		if (position[0] <= 6 && position[0] >= 0 && position[1] <= 6 && position[1] >= 0) {
			if (gameboard.moveFigure(position, players.getActivePlayer().getPos(), players.getActivePlayer())) {
				gameboard.getMapCard(players.getActivePlayer().getPos()[0], players.getActivePlayer().getPos()[1])
						.removeFigure(players.getActivePlayer());
				gameboard.getMapCard(position[0], position[1]).addFigure(players.getActivePlayer());
				players.getActivePlayer().setPos(position);
				players.getActivePlayer().getTreasureCard()
						.found(gameboard.getMapCard(position[0], position[1]).getTreasure());
				result = true;

			}
		}

		return result;
	}

	/**
	 * Methode um den Sieger zu ermitteln.
	 */
	@Override
	public String hasWon() {
		String result = "notWon";
		if (players.getActivePlayer().isAllFound()
				&& gameboard.getMapCard(players.getActivePlayer().getPos()[0], players.getActivePlayer().getPos()[1])
						.isStartFromFigure()) {
			result = players.getActivePlayer().getName();
		}
		return result;
	}

	/**
	 * Methode um eine Runde zu beenden.
	 * 
	 * @return String - tells if round could be ended or not.
	 */
	@Override
	public String endRound() {
		String result = "You have to move the gears once per round!";
		if (this.isMoveFigur == true) {
			if (players.getActivePlayer().getTreasureCard().isFound()) {
				players.getActivePlayer().isFound(players.getActivePlayer().getTreasureCard());
				if (hasWon().equals(players.getActivePlayer().getName())) {
					return "GameOver: " + players.getActivePlayer().getName() + " won the game!";
				} else {
					players.getActivePlayer().drawCard();
				}

			}
			players.nextPlayer();
			result = players.getActivePlayer().toString();
			this.isMoveFigur = false;
		}

		return result;
	}

	/**
	 * Methode um das Spiel zu speichern.
	 * 
	 * @throws IOException
	 */
	// SPEICHERN UND LADEN FOLIEN s269
	@Override
	public String saveGame(String path, String type) throws IOException {
		String saver;
		DataAccessSER save = new DataAccessSER();
		try {
			save.writeToFile(path, type);
			saver = "Game saved successfully!";
		}catch(IOException e) {
			saver = "Game couldn't load!";
			System.err.println(saver);
		}
		

		return saver;
	}

	/**
	 * Methode um ein gespeichertes Spiel zu laden.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public String loadGame(String path, String type) throws ClassNotFoundException, IOException {
		String saver;
		DataAccessSER save = new DataAccessSER();
		try {
			save.readFile(path, type);
			saver = "Game successfully saved!";
		}catch (ClassNotFoundException e){
			saver = "Game couldn't save, because class was not found";
			System.err.println(saver);
		}catch(IOException e) {
			saver = "Game could't save";
			System.err.println(saver);
			
		}
		
		return saver;
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
		String rotateGear = "Wrong direction use 'left' or 'right'";
		if (direction != null) {
			if (direction.toLowerCase().equals("left")) {
				gameboard.getFreeCard().rotateLeft();
				rotateGear = gameboard.getFreeCard().toString();
			} else if (direction.toLowerCase().equals("right")) {
				gameboard.getFreeCard().rotateRight();
				rotateGear = gameboard.getFreeCard().toString();
			}
		}
		return rotateGear;
	}

}
