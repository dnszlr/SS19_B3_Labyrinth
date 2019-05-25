package Backend.Map;

import Backend.Color;
import Backend.Treasure;

/**
 * Klasse EvenCard erbt von Klasse @MazeCard
 */
public class EvenCard extends MazeCard {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor der Klasse EvenCard
	 * 
	 * @param Color    color
	 * @param Treasure treasure
	 */
	public EvenCard() {
		super(new int[4], null, null);
		int random = (int) (Math.random() * 2 + 1);
		if (random == 1) {
			this.wall = new int[] { 1, 0, 1, 0 };
		} else {
			this.wall = new int[] { 0, 1, 0, 1 };
		}
	}

	public EvenCard(int[] wall) {

		super(wall, null, null);

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
