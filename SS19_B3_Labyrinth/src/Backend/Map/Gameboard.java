package Backend.Map;

import java.util.List;

import Backend.Color;
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
		this.map[0][0] = new CurveCard(Color.RED, null);
		while(!this.map[0][0].getWall().equals(new int[]{1,0,0,1})) {
			this.map[0][0].rotateLeft();
		}

	}

	/**
	 * Methode um ein neues Labyrinth zu erstellen.
	 * @param treasures
	 * @return
	 */
	private MazeCard generateNewMaze(List<Treasure> treasures) {
		
		for(int i = 0; i < this.map.length; i++) {
			for(int j = 0; j < this.map[i].length; j++) {
				if(this.map[i][j].equals(null)) {
					if(i % 2 == 0) {
						this.map[i][j] = new 
					}
					if(i == 0 && j == 0){
						this.map[i][j] = new CurveCard(Color.RED, null);
					}
					
				}
			}
		}
		
		
		return null;

	}

	/**
	 * Methode um die Figuren auf dem Spielfeld zu platzieren.
	 * 
	 * @param figures
	 */
	public void placeFigures(Figure[] figures) {

	}

	/**
	 * Methode um die Feldkarten zu verschieben.
	 * 
	 * @param move
	 * @param card
	 * @return
	 */
	public MazeCard moveGears(PositionsCard move, MazeCard card) {
		return null;

	}

	public MazeCard getFreeCard() {
		
		return this.freeCard;
	}
	
	public MazeCard getMapCard(int x, int y) {
		
		return this.map[x][y];
	}
	
	public boolean moveFigure(int[] currentPos, int[] oldPos, Figure figure) {
		
		return false;
	}

}
