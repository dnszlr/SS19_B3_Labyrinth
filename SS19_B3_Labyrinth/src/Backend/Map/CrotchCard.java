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

		super(new int[] { 0, 0, 0, 1 }, null, treasure);

	}

	/**
	 * Überschreiben der rotateLeft Methode von MazeCard.
	 */
	@Override
	public void rotateLeft() {
		boolean test = false;
			for (int i = 0; i < this.wall.length; i++) {
				if(test == false) {
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
	 * Überschreiben der rotateRight Methode von MazeCard.
	 */
	@Override
	public void rotateRight() {
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
