package Backend.Map;

import java.util.List;

import Backend.PositionsCard;
import Backend.Treasure;
import Backend.Figure.Figure;

public class Gameboard {

	private MazeCard freeCard;
	private MazeCard[][] map;

	public Gameboard() {
		
		this.map = new MazeCard[7][7];
	}

	private MazeCard generateNewMaze(List<Treasure> treasures) {
		return null;

	}

	public void placeFigures(Figure[] figures) {

	}

	public MazeCard moveGears(PositionsCard move, MazeCard card) {
		return null;

	}

}
