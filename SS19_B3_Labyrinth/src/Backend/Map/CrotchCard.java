package Backend.Map;

import Backend.Color;
import Backend.Treasure;
	/**
	 * Klasse CrotchCard erbt von Klasse @MazeCard
	 */
public class CrotchCard extends MazeCard {
	/**
	 * Konstuktor f�r die Klasse CrotchCard
	 * @param treasure
	 */
	public CrotchCard(Treasure treasure) {
		super(null, null, treasure);
	}
	/** 
	 * �berschreiben der rotateLeft Methode von MazeCard.
	 */
	@Override
	public void rotateLeft() {
	}
	/**
	 * �berschreiben der rotateRight Methode von MazeCard.
	 */
	@Override
	public void rotateRight() {	
	}
	
	

}
