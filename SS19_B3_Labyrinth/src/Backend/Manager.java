package Backend;

import java.util.ArrayList;

import Backend.Cards.ObjectCard;
import Backend.Map.Gameboard;
import Interface.Communication;

public class Manager implements Communication {

	private Color color;
	private Treasure treasure;
	private Gameboard gameboard;
	private RingBufferPlayers players;
	private ArrayList<ObjectCard> objectCards;

	public String[][] getMap() {
		return null;
	}

	public boolean moveFigure(Color color, int[] pos) {
		return false;
	}

	public String[] getPlayers() {
		return null;
	}

	public String getActivePlayer() {
		return null;
	}

	public String getActivePlayerTreasureCard() {
		return null;
	}

	public String getFoundTreasures(Color color) {
		return null;
	}

	public String addPlayer(String name, Color color) {
		return null;
	}

	public String startGame() {
		return null;
	}

	public boolean moveGears(String position) {
		return false;
	}

	public boolean moveFigure(int[] position) {
		return false;
	}
	
	public String hasWon() {
		return null;
	}

	public boolean endGame() {
		return false;
	}

	public boolean saveGame(String path) {
		return false;
	}

	public boolean loadGame(String path) {
		return false;
	}

}
