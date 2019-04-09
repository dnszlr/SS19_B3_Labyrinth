package Backend;

import java.util.ArrayList;

import Backend.Cards.ObjectCard;
import Backend.Map.Gameboard;
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
	private boolean isPlaceMaceCard;

	/**
	 * Getter von der Map des Gameboards.
	 */
	public String[][] getMap() {
		return null;
	}

	/**
	 * Bewegt die Figur an einen bestimmten Index des Arrays.
	 */
	public boolean moveFigure(Color color, int[] pos) {
		return false;
	}

	/**
	 * Getter für die Spieler.
	 */
	public String[] getPlayers() {
		return null;
	}

	/**
	 * Getter für den Spieler der gerade am Zug ist.
	 */
	public String getActivePlayer() {
		return null;
	}

	/**
	 * Getter für die Treasure Karte des Spielers der gerade am Zug ist.
	 */
	public String getActivePlayerTreasureCard() {
		return null;
	}

	/**
	 * Getter für die bereits gefunden Treasures.
	 */
	public String getFoundTreasures(Color color) {
		return null;
	}

	/**
	 * Methode um Spieler dem Spiel hinzuzufügen.
	 */
	public String addPlayer(String name, Color color) {
		return null;
	}

	/**
	 * Methode um das Spiel zu starten.
	 */
	public String startGame() {
		return null;
	}

	/**
	 * Methode um die Wegkarten zu bewegen.
	 */
	public boolean moveGears(String position) {
		return false;
	}

	/**
	 * Methode um die Spielfiguren zu bewegen.
	 */
	public boolean moveFigure(int[] position) {
		return false;
	}

	/**
	 * Methode um den Sieger zu ermitteln.
	 */
	public String hasWon() {
		return null;
	}

	/**
	 * Methode um das Spiel zu beenden.
	 */
	public boolean endGame() {
		return false;
	}

	/**
	 * Methode um das Spiel zu speichern.
	 */
	public boolean saveGame(String path) {
		return false;
	}

	/**
	 * Methode um ein gespeichertes Spiel zu laden.
	 */
	public boolean loadGame(String path) {
		return false;
	}

}
