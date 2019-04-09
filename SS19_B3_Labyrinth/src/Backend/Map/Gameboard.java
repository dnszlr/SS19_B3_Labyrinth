package Backend.Map;

import java.util.List;

import Backend.PositionsCard;
import Backend.Treasure;
import Backend.Figure.Figure;

public class Gameboard {
	/**
	 * Attribute der Klasse Gameboard.
	 */
	private MazeCard freeCard;
	private MazeCard[][] map;
	/**
	 * Konstruktor der Klasse Gameboard
	 */
	public Gameboard() {
		
		this.map = new MazeCard[7][7];
	}
	/**
	 * Methode um ein neues Labyrinth zu erstellen.
	 * @param treasures
	 * @return
	 */
	private MazeCard generateNewMaze(List<Treasure> treasures) {
		return null;

	}
	/**
	 * Methode um die Figuren auf dem Spielfeld zu platzieren.
	 * @param figures
	 */
	public void placeFigures(Figure[] figures) {

	}
	/**
	 * Methode um die Feldkarten zu verschieben.
	 * @param move
	 * @param card
	 * @return
	 */
	public MazeCard moveGears(PositionsCard move, MazeCard card) {
		return null;

	}

}
