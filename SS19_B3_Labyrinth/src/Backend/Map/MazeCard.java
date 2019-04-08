package Backend.Map;

import java.util.ArrayList;

import Backend.Color;
import Backend.Direction;
import Backend.Treasure;
import Backend.Figure.Figure;

public abstract class MazeCard {

	protected int[] wall;
	private MazeCard[] neighboring;
	private Treasure treasure;
	private Color color;
	private ArrayList<Figure> figures;

	public MazeCard(int[] wall, Color color, Treasure treasure) {
	}

	public abstract void rotateLeft();

	public abstract void rotateRight();

	public int[] getWall() {
		return null;
	}

	public Treasure getTreasure() {
		return null;
	}

	public MazeCard getNeighboring(Direction direction) {
		return null;
	}

	public Color getColor() {
		return null;
	}

	public ArrayList<Figure> getFigures() {
		return null;
	}
	
	public void setNeighboring(MazeCard card, Direction direction) {
		
	}
	
	public void addFigure(Figure figure) {
		
	}
	
	public void addFigures(ArrayList<Figure> figures) {
		
	}
	
	public boolean removeFigure(Figure figure) {
		return false;
	}
	
	public void removeFigures() {
		
	}
	
	public boolean isStart() {
		return false;
	}
	
	public boolean isStartFromFigure() {
		return false;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
