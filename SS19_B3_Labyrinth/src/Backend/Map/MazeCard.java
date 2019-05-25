package Backend.Map;

import java.io.Serializable;
import java.util.ArrayList;
import Backend.Color;
import Backend.Direction;
import Backend.Treasure;
import Backend.Figure.Figure;

public abstract class MazeCard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 * @param          int[] wall
	 * @param Color    color
	 * @param Treasure treasure
	 * @param MazeCard
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
	 * @return int[]
	 */
	public int[] getWall() {

		return this.wall;
	}

	/**
	 * Getter um einen Treasure zu bekommen
	 * 
	 * @return Treasure
	 */
	public Treasure getTreasure() {
		return this.treasure;
	}

	/**
	 * Getter um die Nachbarn der aktuellen Posititon in eine bestimme Richtung zu
	 * erhalten.
	 * 
	 * @param Direction direction
	 * @return MazeCard
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
	 * @return Color color
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Getter um die Figuren zu erfragen.
	 * 
	 * @return ArrayList<Figure> figure
	 */
	public ArrayList<Figure> getFigures() {
		return this.figures;
	}

	/**
	 * Setter um die Nachbarkarten zu setzen. Karte und Richtung bestimmbar.
	 * 
	 * @param MazeCard  card
	 * @param Direction direction
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
	 * Methode um eine Figure einer Karte hinzuzufï¿½gen.
	 * 
	 * @param Figure figure
	 */
	public void addFigure(Figure figure) {

		figures.add(figure);

	}

	/**
	 * Methode um alle Figuren von figures einer Karte hinzuzufï¿½gen.
	 * 
	 * @param ArrayList<Figure> figures
	 */
	public void addFigures(ArrayList<Figure> figures) {

		this.figures = figures;

	}

	/**
	 * Methode um eine Figure von einer Karte zu entfernen.
	 * 
	 * @param Figure figure
	 * @return boolean result
	 */
	public boolean removeFigure(Figure figure) {
		boolean result = false;

		if (figures.contains(figure)) {
			figures.remove(figure);
			result = true;
		}

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
	 * @return boolean result
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
	 * @return boolean result
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
	 * Überschreiben der Methode "toString" von Object.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		

		String MazeCard = getClass().getSimpleName() + ";" + getWall()[0] + ";" + getWall()[1] + ";" + getWall()[2]
				+ ";" + getWall()[3] + ";" + "" + getColor() + ";" + "" + getTreasure() + ";";
		return MazeCard;

	}
}
