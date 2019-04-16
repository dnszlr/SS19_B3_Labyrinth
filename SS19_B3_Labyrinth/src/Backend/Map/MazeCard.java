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
	protected int[] wall = new int[4];
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
	 * @return
	 */
	public int[] getWall() {
		return this.wall;
	}

	/**
	 * Getter um einen Treasure zu bekommen
	 * 
	 * @return
	 */
	public Treasure getTreasure() {
		return this.treasure;
	}

	/**
	 * Getter um die Nachbarn der aktuellen Posititon in eine bestimme Richtung zu
	 * erhalten.
	 * 
	 * @param direction
	 * @return
	 */
	public MazeCard getNeighboring(Direction direction) {
		MazeCard result = null;
		switch (direction) {
		case west:
			result = this.neighboring[0];
			break;
		case north:
			result = this.neighboring[1];
			break;
		case east:
			result = this.neighboring[2];
			break;
		case south:
			result = this.neighboring[3];
			break;
		}
		return result;

	}

	/**
	 * Getter um die Farbe zu erfragen.
	 * 
	 * @return
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Getter um die Figuren zu erfragen.
	 * 
	 * @return
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
		case west:
			this.neighboring[0] = card;
			break;
		case north:
			this.neighboring[1] = card;
			break;
		case east:
			this.neighboring[2] = card;
			break;
		case south:
			this.neighboring[3] = card;
			break;

		}

	}

	/**
	 * Methode um eine Figure zum Spiel hinzuzufügen.
	 * 
	 * @param figure
	 */
	public void addFigure(Figure figure) {

		if (figures.size() <= 4) {
			figures.add(figure);
		} else {
			try {
				throw new ArrayIndexOutOfBoundsException("The maximum amount of players is 4!");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * Methode um alle Figuren zum Spiel hinzuzufügen.
	 * 
	 * @param figures
	 */
	public void addFigures(ArrayList<Figure> figures) {

		this.figures = figures;

	}

	/**
	 * Methode um eine Figure von Spiel zu entfernen.
	 * 
	 * @param figure
	 * @return
	 */
	public boolean removeFigure(Figure figure) {
		boolean result = false;
		int counter = 0;
		for (Figure i : figures) {
			if (i.equals(figure)) {
				figures.remove(counter);
			}
			counter++;
		}
		return result;
	}

	/**
	 * Methode um alle Figuren von Spiel zu entfernen.
	 */
	public void removeFigures() {

		figures.clear();

	}

	/**
	 * ??
	 * 
	 * @return
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
	 * ??
	 * 
	 * @return
	 */
	public boolean isStartFromFigure() {
		boolean result = false;
		if(this instanceof CurveCard) {
			for(Figure i : figures) {
				if(this.getColor().equals(i.getColor())) {
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * Überschreiben der Methode "toString" von Object.
	 */
	@Override
	public String toString() {

		return "MazeCard: " + Arrays.toString(this.wall) + " " + this.color + " " + this.treasure;
	}
}
