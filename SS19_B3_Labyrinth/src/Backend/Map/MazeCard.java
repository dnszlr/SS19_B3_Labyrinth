package Backend.Map;

import java.util.ArrayList;
import java.util.Arrays;

import Backend.Color;
import Backend.Direction;
import Backend.Treasure;
import Backend.Figure.Figure;

public abstract class MazeCard {

	/**
	 * Attribute der Klasse MazeCard
	 */
	protected int[] wall;
	private MazeCard[] neighboring;
	private Treasure treasure;
	private Color color;
	private ArrayList<Figure> figures;

	/**
	 * Konstruktor der Klasse MazeCard
	 * 
	 * @param wall
	 * @param color
	 * @param treasure
	 */
	public MazeCard(int[] wall, Color color, Treasure treasure) {

		this.wall = wall;
		this.color = color;
		this.treasure = treasure;
		this.neighboring = new MazeCard[4];
		this.figures = new ArrayList<Figure>();
	}

	/**
	 * Methode um ein Feld im Labyrint links zu rotieren.
	 */
	public abstract void rotateLeft();

	/**
	 * Methode um ein Feld im Labyrint rechts zu rotieren.
	 */
	public abstract void rotateRight();

	/**
	 * Methode um die Position der Wand zu erfragen
	 * 
	 * @return wall 
	 */
	public int[] getWall() {
		return this.wall;
	}

	/**
	 * Getter um einen Treasure zu bekommen
	 * 
	 * @return treasure 
	 */
	public Treasure getTreasure() {
		return this.treasure;
	}

	/**
	 * Getter um die Nachbarn der aktuellen Posititon in eine bestimme Richtung zu
	 * erhalten.
	 * 
	 * @param direction
	 * @return result 
	 */
	public MazeCard getNeighboring(Direction direction) {
		MazeCard result = null;
		switch (direction) {
		case north:
			result = this.neighboring[0];
			break;
		case east:
			result = this.neighboring[1];
			break;
		case south:
			result = this.neighboring[2];
			break;
		case west:
			result = this.neighboring[3];
			break;
		}
		return result;

	}

	/**
	 * Getter um die Farbe zu erfragen.
	 * 
	 * @return color 
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Getter um die Figuren zu erfragen.
	 * 
	 * @return figures 
	 */
	public ArrayList<Figure> getFigures() {
		return this.figures;
	}

	/**
	 * Setter um die Nachbarkarten zu setzen. Karte und Richtung bestimmbar.
	 * 
	 * @param card
	 * @param direction
	 */
	public void setNeighboring(MazeCard card, Direction direction) {

		switch (direction) {
		case north:
			this.neighboring[0] = card;
			break;
		case east:
			this.neighboring[1] = card;
			break;
		case south:
			this.neighboring[2] = card;
			break;
		case west:
			this.neighboring[3] = card;
			break;

		}

	}

	/**
	 * Methode um eine Figure einer Karte hinzuzuf�gen.
	 * 
	 * @param figure
	 */
	public void addFigure(Figure figure) {

		figures.add(figure);

	}

	/**
	 * Methode um alle Figuren von figures einer Karte hinzuzuf�gen.
	 * 
	 * @param figures
	 */
	public void addFigures(ArrayList<Figure> figures) {

		this.figures = figures;

	}

	/**
	 * Methode um eine Figure von einer Karte zu entfernen.
	 * 
	 * @param figure
	 * @return result 
	 */
	public boolean removeFigure(Figure figure) {
		boolean result = false;
		Figure found = null;
		for (Figure i : figures) {
			if (result == false) {
				if (i.equals(figure)) {
					found = i;
					result = true;
				}
			}
		}
		figures.remove(found);
		return result;
	}

	/**
	 * Methode um alle Figuren von der Karte zu entfernen.
	 */
	public void removeFigures() {

		figures.clear();

	}

	/**
	 * Methode um zu fragen ob die Karte eine Startpunkt ist.
	 * 
	 * @return result 
	 */
	public boolean isStart() {
		boolean result = false;
		if (this instanceof CurveCard) {
			if (this.color != null) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * Methode um zu fragen ob die Karte ein Startpunkt einer spezifischen Figur
	 * ist.
	 * 
	 * @return result 
	 */
	public boolean isStartFromFigure() {
		boolean result = false;
		if (this instanceof CurveCard) {
			for (Figure i : figures) {
				if (this.getColor().equals(i.getColor())) {
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * �berschreiben der Methode "toString" von Object.
	 */
	@Override
	public String toString() {

//		return "MazeCard: " + Arrays.toString(this.wall) + " " + this.color + " " + this.treasure;
		return "" + this.wall + " " + this.color + " " + this.treasure;

	}
}
