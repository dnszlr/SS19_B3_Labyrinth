package Backend;

import java.util.ArrayList;
import java.util.Collections;

import Backend.Figure.Figure;

public class RingBufferPlayers {
	/**
	 * Attribute der Klasse RingBufferPlayers
	 */
	private int readPointer = 0;
	private ArrayList<Figure> figures;
	private Figure activePlayer;

	/**
	 * Konstuktor der Klasse RingBufferPlayers
	 */

	public RingBufferPlayers() {

		this.figures = new ArrayList<Figure>();
		
		
	}

	/**
	 * Methode um einen Spieler dem Spiel hinzuzufügen
	 * 
	 * @param figure
	 * @return
	 */

	public boolean addFigure(Figure figure) {
		boolean test = false;
		for(Figure i : figures) {
			if(figure.equals(i)) {
				test = false;
			}else {
				test = true;
			}
		}
		if(test = true) {
			figures.add(figure);
		}
		return test;
	}

	/**
	 * Methode um den aktuellen Spieler zu ermitteln
	 * 
	 * @return
	 */

	public Figure getActivePlayer() {
		
		return this.activePlayer;
	}

	/**
	 * Methode um den nächsten Spieler zu ermitteln der an der Reihe ist.
	 * 
	 * @return
	 */

	public Figure nextPlayer() {
		int counter = this.readPointer;
		Figure nextFigure = null;
		for(Figure i : figures) {
			counter++;
			if(this.activePlayer.equals(i)) {
				nextFigure = figures.get(counter++);
			}
		}
		return nextFigure;
	}

	/**
	 * Methode um die Reihenfolge der Spieler zu mischen.
	 */

	public void shufflePlayers() {
		
		Collections.shuffle(this.figures);
		
	}

}
