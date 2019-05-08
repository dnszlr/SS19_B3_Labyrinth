package Backend;

import java.util.ArrayList;
import java.util.Collections;
import Backend.Figure.Figure;

public class RingBufferPlayers {
	/**
	 * Attribute der Klasse RingBufferPlayers
	 */
	private int readPointer;
	private ArrayList<Figure> figures;
	private Figure activePlayer;

	/**
	 * Konstuktor der Klasse RingBufferPlayers
	 */

	public RingBufferPlayers() {
		this.readPointer = 0;
		this.figures = new ArrayList<Figure>();

	}

	/**
	 * Methode um einen Spieler dem Spiel hinzuzuf�gen gibt zurück ob die figur erfolgreich hinzugefügt worden ist 
	 * 
	 * @param figure
	 * @return result 
	 */

	public boolean addFigure(Figure figure) {
		
		boolean result = false;
		for (Figure i : figures) {
			if (figure.equals(i)) {
				result = false;
			} else {
				result = true;
			}
		}
		if (result = true) {
			figures.add(figure);
			if (figures.size() == 1) {
				this.activePlayer = figure;
			}

		}
		return result;
	}

	/**
	 * Methode um den aktuellen Spieler zu ermitteln
	 * 
	 * @return activePlayer
	 */

	public Figure getActivePlayer() {

		return this.activePlayer;
	}

	/**
	 * Methode um den n�chsten Spieler zu ermitteln der an der Reihe ist.
	 * 
	 * @return nextFigure
	 */

	public Figure nextPlayer() {
		
		if (this.readPointer < figures.size() - 1) {
			this.readPointer++;
		} else {
			this.readPointer = 0;
		}

		Figure nextFigure = figures.get(this.readPointer);
		this.activePlayer = nextFigure;
		return nextFigure;
	}

	/**
	 * Methode um die Reihenfolge der Spieler zu mischen.
	 */

	public void shufflePlayers() {

		Collections.shuffle(this.figures);

	}

}
