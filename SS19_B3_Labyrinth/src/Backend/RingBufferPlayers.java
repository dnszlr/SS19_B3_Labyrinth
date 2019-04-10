package Backend;

import java.util.ArrayList;
import java.util.List;

import Backend.Figure.Figure;

public class RingBufferPlayers {
	/**
	 * Attribute der Klasse RingBufferPlayers
	 */
	private int readPointer;
	private List<Figure> figures;
	private Figure ActivePlayer;

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
		return false;
	}

	/**
	 * Methode um den aktuellen Spieler zu ermitteln
	 * 
	 * @return
	 */

	public Figure getActivePlayer() {
		return null;
	}

	/**
	 * Methode um den nächsten Spieler zu ermitteln der an der Reihe ist.
	 * 
	 * @return
	 */

	public Figure nextPlayer() {
		return null;
	}

	/**
	 * Methode um die Reihenfolge der Spieler zu mischen.
	 */

	public void shufflePlayers() {

	}

}
