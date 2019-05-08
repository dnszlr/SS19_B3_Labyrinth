package Backend;

import java.util.ArrayList;
import Backend.Cards.ObjectCard;
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
	private RingBufferPlayers players = new RingBufferPlayers();
	private ArrayList<ObjectCard> objectCards;
	private boolean isMoveFigure;
	private boolean isPlaceMazeCard;

	/**
	 * Getter von der Map des Gameboards.
	 */
	@Override
	public String[][] getMap() {

		// CSV FÜR SPEICHERN UND LADEN UND DESWEGEN ALLES ANS STRING ZURÜCKGEBEN? FOLIEN s260?
		return null;
	}

	/**
	 * Getter für die Spieler.
	 */
	@Override
	public String[] getPlayers() {
		String[] players;

		return null;
	}

	/**
	 * Getter für den Spieler der gerade am Zug ist.
	 */
	@Override
	public String getActivePlayer() {

		players.getActivePlayer();
		return null;
	}

	/**
	 * Getter für die Treasure Karte des Spielers der gerade am Zug ist.
	 */
	@Override
	public String getActivePlayerTreasureCard() {
		players.getActivePlayer().getTreasureCard();
		return null;
	}

	/**
	 * Getter für die bereits gefunden Treasures.
	 */
	@Override
	public String getFoundTreasures(String color) {

		Color player = Color.valueOf(color);

		return null;
	}

	/**
	 * Methode um Spieler dem Spiel hinzuzufügen.
	 */
	@Override
	public String addPlayer(String name, String color) { // Fragen, weil im RingBuffer addFigure mit figure übergeben
															// wird und nicht mit name und color, wie ein Objekt davon
															// erzeugen, wenn Manager die Figure nicht kennt?

		if (!name.equals(null)
				&& (color.equals("RED") || color.equals("BLUE") || color.equals("YELLOW") || color.equals("GREEN"))) {
			Color playerColor = Color.valueOf(color);
			this.players.addFigure(new Figure(name, playerColor));
		}

		return null;
	}

	/**
	 * Methode um das Spiel zu starten.
	 */
	@Override
	public String startGame() {
		return null;
	}

	/**
	 * Methode um die Wegkarten zu bewegen.
	 */
	@Override
	public String moveGears(String position) {

		gameboard.moveGears(PositionsCard.valueOf(position), gameboard.getFreeCard());
		return null;
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
			result = "hasWon " + players.getActivePlayer().getName();
		}
		return result;
	}

	/**
	 * Methode um eine Runde zu beenden.
	 */
	@Override
	public String endRound() {

		players.nextPlayer();
		return null;
	}

	/**
	 * Methode um das Spiel zu speichern.
	 */
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

		gameboard.getFreeCard();
		return null;
	}

	/**
	 * Methode um ein Feld zu drehen.
	 */
	@Override
	public String rotateGear(String direction) {
		// Exception schreiben falls Direction nicht left oder right.
		if (direction.toLowerCase().equals("left")) {
			gameboard.getFreeCard().rotateLeft();
		} else if (direction.toLowerCase().equals("right")) {
			gameboard.getFreeCard().rotateRight();
		}

		return null;
	}

}
