package Backend.Map;

import Backend.Color;
import Backend.Treasure;

/**
 * Klasse EvenCard erbt von Klasse @MazeCard
 */
public class EvenCard extends MazeCard {
	/**
	 * Konstruktor der Klasse EvenCard
	 * 
	 * @param color
	 * @param treasure
	 */
	public EvenCard(Color color, Treasure treasure) {
		super(null, color, treasure);

	}

	/**
	 * �berschreiben der Methode rotateLeft von MazeCard.
	 */
	@Override
	public void rotateLeft() {

	}

	/**
	 * �berschreiben der Methode rotateRight von MazeCard.
	 */
	@Override
	public void rotateRight() {

	}
}
