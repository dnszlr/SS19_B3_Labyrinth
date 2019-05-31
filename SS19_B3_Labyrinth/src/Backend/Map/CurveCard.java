package Backend.Map;

import java.util.Arrays;
import Backend.Color;
import Backend.Treasure;

/**
 * Klasse CurveCard erbt von Klasse @MazeCard
 */
public class CurveCard extends MazeCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor der Klasse CurveCard
	 * @param Color color
	 * @param Treasure treasure
	 */
	public CurveCard(Color color, Treasure treasure) {

		super(new int[4], color, treasure);
		if (color == null) {
			int random = (int) (Math.random() * 4 + 1);
			if (random == 1) {
				this.wall = new int[] { 1, 0, 0, 1 };
			} else if (random == 2) {
				this.wall = new int[] { 1, 1, 0, 0 };
			} else if (random == 3) {
				this.wall = new int[] { 0, 1, 1, 0 };
			} else {
				this.wall = new int[] { 0, 0, 1, 1 };
			}

		} else {

			switch (color) {
			case RED:
				this.wall = new int[] { 1, 0, 0, 1 };
				break;
			case YELLOW:
				this.wall = new int[] { 1, 1, 0, 0 };
				break;
			case BLUE:
				this.wall = new int[] { 0, 1, 1, 0 };
				break;
			case GREEN:
				this.wall = new int[] { 0, 0, 1, 1 };
				break;
			}
		}

	}

	/**
	 * Überschreiben der Methode rotateLeft von MazeCard.
	 */
	@Override
	public void rotateRight() {
		if (Arrays.equals(this.wall, new int[] { 1, 1, 0, 0 })) {
			this.wall = new int[] { 1, 0, 0, 1 };
		} else if (Arrays.equals(this.wall, new int[] { 1, 0, 0, 1 })) {
			this.wall = new int[] { 0, 0, 1, 1 };
		} else if (Arrays.equals(this.wall, new int[] { 0, 0, 1, 1 })) {
			this.wall = new int[] { 0, 1, 1, 0 };
		} else if (Arrays.equals(this.wall, new int[] { 0, 1, 1, 0 })) {
			this.wall = new int[] { 1, 1, 0, 0 };
		}
	}

	/**
	 * Überschreiben der Methode rotateRight von MazeCard.
	 */
	@Override
	public void rotateLeft() {
		if (Arrays.equals(this.wall, new int[] { 1, 1, 0, 0 })) {
			this.wall = new int[] { 0, 1, 1, 0 };
		} else if (Arrays.equals(this.wall, new int[] { 0, 1, 1, 0 })) {
			this.wall = new int[] { 0, 0, 1, 1 };
		} else if (Arrays.equals(this.wall, new int[] { 0, 0, 1, 1 })) {
			this.wall = new int[] { 1, 0, 0, 1 };
		} else if (Arrays.equals(this.wall, new int[] { 1, 0, 0, 1 })) {
			this.wall = new int[] { 1, 1, 0, 0 };
		}
	}

}
