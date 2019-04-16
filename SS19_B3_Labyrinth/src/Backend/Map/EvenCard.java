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
	public EvenCard() {
		super(new int[] { 1, 0, 1, 0 }, null, null);

	}

	/**
	 * Überschreiben der Methode rotateLeft von MazeCard.
	 */
	@Override
	public void rotateLeft() {

		for (int i = 0; i < wall.length; i++) {
			if (wall[i] == 0) {
				wall[i] = 1;
			} else {
				wall[i] = 0;
			}
		}

	}

	/**
	 * Überschreiben der Methode rotateRight von MazeCard.
	 */
	@Override
	public void rotateRight() {

		for (int i = 0; i < wall.length; i++) {
			if (wall[i] == 0) {
				wall[i] = 1;
			} else {
				wall[i] = 0;
			}
		}

	}
}
