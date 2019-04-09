package Backend.Map;

import java.util.ArrayList;

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
	 * @param wall
	 * @param color
	 * @param treasure
	 */
	public MazeCard(int[] wall, Color color, Treasure treasure) {
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
	 * @return
	 */
	public int[] getWall() {
		return null;
	}
	/**
	 * Getter um einen Treasure zu bekommen
	 * @return
	 */
	public Treasure getTreasure() {
		return null;
	}
	/**
	 * Getter um die Nachbarn der aktuellen Posititon in eine bestimme Richtung zu erhalten.
	 * @param direction
	 * @return
	 */
	public MazeCard getNeighboring(Direction direction) {
		return null;
	}
	/**
	 * Getter um die Farbe zu erfragen.
	 * @return
	 */
	public Color getColor() {
		return null;
	}
	/**
	 * Getter um die Figuren zu erfragen.
	 * @return
	 */
	public ArrayList<Figure> getFigures() {
		return null;
	}
	/**
	 * Setter um die Nachbarkarten zu setzen. Karte und Richtung bestimmbar.
	 * @param card
	 * @param direction
	 */
	public void setNeighboring(MazeCard card, Direction direction) {
		
	}
	/**
	 * Methode um eine Figure zum Spiel hinzuzufügen.
	 * @param figure
	 */
	public void addFigure(Figure figure) {
		
	}
	/**
	 * Methode um alle Figuren zum Spiel hinzuzufügen.
	 * @param figures
	 */
	public void addFigures(ArrayList<Figure> figures) {
		
	}
	/**
	 * Methode um eine Figure von Spiel zu entfernen.
	 * @param figure
	 * @return
	 */
	public boolean removeFigure(Figure figure) {
		return false;
	}
	/**
	 * Methode um alle Figuren von Spiel zu entfernen.
	 */
	public void removeFigures() {
		
	}
	/**
	 * ??
	 * @return
	 */
	public boolean isStart() {
		return false;
	}
	/**
	 * ??
	 * @return
	 */
	public boolean isStartFromFigure() {
		return false;
	}
	/**
	 * Überschreiben der Methode "toString" von Object.
	 */
	@Override
	public String toString() {
		return null;
	}
}
