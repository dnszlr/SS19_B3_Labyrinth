package Backend.Map;

import java.util.Arrays;

import Backend.Color;
import Backend.Treasure;

/**
 * Klasse CurveCard erbt von Klasse @MazeCard
 */
public class CurveCard extends MazeCard {

	/**
	 * Konstruktor der Klasse CurveCard
	 */
	public CurveCard(Color color, Treasure treasure) {
		super(new int[] { 1, 1, 0, 0 }, color, treasure);
		 
	}

	/**
	 * Überschreiben der Methode rotateLeft von MazeCard.
	 */
	@Override
	public void rotateLeft() {
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
	public void rotateRight() {
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
