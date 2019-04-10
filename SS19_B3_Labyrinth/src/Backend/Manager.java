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
	private ArrayList<ObjectCard> objectCards = new ArrayList<ObjectCard>();
	private boolean isMoveFigure;
	private boolean isPlaceMaceCard;

	/**
	 * Getter von der Map des Gameboards.
	 */
	@Override
	public String[][] getMap() {
		return null;
	}

	/**
	 * Getter für die Spieler.
	 */
	@Override
	public String[] getPlayers() {
		return null;
	}

	/**
	 * Getter für den Spieler der gerade am Zug ist.
	 */
	@Override
	public String getActivePlayer() {
		return null;
	}

	/**
	 * Getter für die Treasure Karte des Spielers der gerade am Zug ist.
	 */
	@Override
	public String getActivePlayerTreasureCard() {
		return null;
	}

	/**
	 * Getter für die bereits gefunden Treasures.
	 */
	@Override
	public String getFoundTreasures(Color color) {
		return null;
	}

	/**
	 * Methode um Spieler dem Spiel hinzuzufügen.
	 */
	@Override
	public String addPlayer(String name, Color color) {
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
	public boolean moveGears(String position) {
		return false;
	}

	/**
	 * Methode um die Spielfiguren zu bewegen.
	 */
	@Override
	public boolean moveFigure(int[] position) {
		return false;
	}

	/**
	 * Methode um den Sieger zu ermitteln.
	 */
	@Override
	public String hasWon() {
		return null;
	}

	/**
	 * Methode um das Spiel zu beenden.
	 */
	@Override
	public boolean endRound() {
		return false;
	}

	/**
	 * Methode um das Spiel zu speichern.
	 */
	@Override
	public boolean saveGame(String path) {
		return false;
	}

	/**
	 * Methode um ein gespeichertes Spiel zu laden.
	 */
	@Override
	public boolean loadGame(String path) {
		return false;
	}
	/**
	 * Methode um eine freie Labyrintkarte zu erfragen.
	 */
	@Override
	public String getFreeMazeCard() {
		return null;
	}
	/**
	 * Methode um ein Feld zu drehen.
	 */
	@Override
	public String rotateGear(String direction) {
		return null;
	}

}
