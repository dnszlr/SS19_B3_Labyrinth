package Backend.Map;

import Backend.Color;
import Backend.Treasure;
	/**
	 * Klasse CrotchCard erbt von Klasse @MazeCard
	 */
public class CrotchCard extends MazeCard {
	/**
	 * Konstuktor für die Klasse CrotchCard
	 * @param treasure
	 */
	public CrotchCard(Treasure treasure) {
		super(null, null, treasure);
	}
	/** 
	 * Überschreiben der rotateLeft Methode von MazeCard.
	 */
	@Override
	public void rotateLeft() {
	}
	/**
	 * Überschreiben der rotateRight Methode von MazeCard.
	 */
	@Override
	public void rotateRight() {	
	}
	
	

}
