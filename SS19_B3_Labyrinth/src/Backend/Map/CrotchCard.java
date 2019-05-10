package Backend.Map;

import Backend.Treasure;

/**
 * Klasse CrotchCard erbt von Klasse @MazeCard
 */
public class CrotchCard extends MazeCard {

	/**
	 * Konstuktor für die Klasse CrotchCard
	 * 
	 * @param treasure
	 */
	public CrotchCard(Treasure treasure) {

		super(new int[4], null, treasure);

		switch (treasure) {
		case book:
			this.wall = new int[] { 1, 0, 0, 0 };
			break;
		case moneybag:
			this.wall = new int[] { 1, 0, 0, 0 };
			break;
		case map:
			this.wall = new int[] { 0, 0, 0, 1 };
			break;
		case crown:
			this.wall = new int[] { 0, 0, 0, 1 };
			break;
		case key:
			this.wall = new int[] { 1, 0, 0, 0 };
			break;
		case skull:
			this.wall = new int[] { 0, 1, 0, 0 };
			break;
		case ring:
			this.wall = new int[] { 0, 0, 0, 1 };
			break;
		case chest:
			this.wall = new int[] { 0, 0, 1, 0 };
			break;
		case emerald:
			this.wall = new int[] { 0, 1, 0, 0 };
			break;
		case sword:
			this.wall = new int[] { 0, 1, 0, 0 };
			break;
		case menorah:
			this.wall = new int[] { 0, 0, 1, 0 };
			break;
		case helmet:
			this.wall = new int[] { 0, 0, 1, 0 };
			break;
		default:
			int random = (int) (Math.random() * 4 + 1);
			if (random == 1) {
				this.wall = new int[] { 1, 0, 0, 0 };
			} else if (random == 2) {
				this.wall = new int[] { 0, 1, 0, 0 };
			} else if (random == 3) {
				this.wall = new int[] { 0, 0, 1, 0 };
			} else {
				this.wall = new int[] { 0, 0, 0, 1 };
			}

		}
	}

	/**
	 * Überschreiben der rotateLeft Methode von MazeCard.
	 */
	@Override
	public void rotateRight() {
		boolean test = false;
		for (int i = 0; i < this.wall.length; i++) {
			if (test == false) {
				if (this.wall[i] == 1) {
					this.wall[i] = 0;
					if (i < 3) {
						this.wall[i + 1] = 1;
						test = true;
					} else {
						this.wall[0] = 1;
						test = true;
					}

				}
			}
		}
	}

	/**
	 * Üerschreiben der rotateRight Methode von MazeCard. 
	 */
	@Override
	public void rotateLeft() {
		boolean test = false;
		for (int i = 0; i < this.wall.length; i++) {
			if (test == false) {
				if (this.wall[i] == 1) {
					this.wall[i] = 0;
					if (i > 0) {
						this.wall[i - 1] = 1;
						test = true;
					} else {
						this.wall[3] = 1;
						test = true;
					}
				}
			}
		}
	}

}
