package Backend.Figure;

import Backend.Color;
import Backend.Cards.ObjectCard;

public class Figure {

	/**
	 * Attribute der Klasse Figure
	 */
	private String name;
	private int[] pos;
	private Color color;
	private ObjectCard treasureCard;
	private CardsStack cardstack;

	/**
	 * Konstruktor der Klasse Figure.
	 * 
	 * @param name
	 * @param color
	 */

	public Figure(String name, Color color) {

		this.cardstack = new CardsStack();
	}

	/**
	 * Konstruktor der Klasse Figure.
	 * 
	 * @param name
	 * @param color
	 * @param pos
	 */

	public Figure(String name, Color color, int[] pos) {

		this.cardstack = new CardsStack();
	}

	/**
	 * Getter f�r das Attribut name.
	 * 
	 * @return
	 */

	public String getName() {
		return null;
	}

	/**
	 * Getter f�r das Attribut color.
	 * 
	 * @return
	 */

	public Color getColor() {
		return null;
	}

	/**
	 * Getter f�r das Attribut treasureCard.
	 * 
	 * @return
	 */

	public ObjectCard getTreasureCard() {
		return null;
	}

	/**
	 * Getter f�r das Attribut pos.
	 * 
	 * @return
	 */

	public int[] getPos() {
		return null;
	}

	/**
	 * Getter f�r die gefundenen Karten.
	 * 
	 * @return
	 */

	public String getFoundCard() {
		return null;
	}

	/**
	 * Setter f�r das Attribut pos.
	 * 
	 * @param pos
	 */

	public void setPos(int[] pos) {

	}

	/**
	 * Methode um eine Karte hinzuzuf�gen.
	 * 
	 * @param card
	 */
	public void addCard(ObjectCard card) {

	}

	/**
	 * Methode um eine Karte zu ziehen.
	 * 
	 * @return
	 */

	public ObjectCard drawCard() {
		return null;
	}

	/**
	 * Methode um abzufragen ob eine Karte gefunden wurde.
	 * 
	 * @param card
	 * @return
	 */

	public boolean isFound(ObjectCard card) {
		return false;
	}

	/**
	 * Methode um herauszufinden ob alle Karten gefunden wurden
	 * 
	 * @return
	 */

	public boolean isAllFound() {
		return false;
	}

	/**
	 * �berschreiben der Object Methode "toString". Umwandlung des Objektes in einen
	 * String.
	 */

	@Override
	public String toString() {
		return null;
	}

	/**
	 * Innere Klasse CardsStack
	 */
	private class CardsStack {

		/**
		 * Attribute der Klasse CardsStack
		 */
		private ObjectCard[] foundCards;
		private ObjectCard[] objectsCards;

		/**
		 * Konstruktor f�r die Klasse CardsStack
		 */

		public CardsStack() {

		}

		/**
		 * Methode um eine Karte dem CardStack hinzuzuf�gen
		 * 
		 * @param card
		 */

		public void addCard(ObjectCard card) {

		}

		/**
		 * Methode um eine Karte vom CardStack zu ziehen.
		 * 
		 * @return
		 */

		public ObjectCard drawCard() {
			return null;
		}

		/**
		 * Methode um zu �berpr�fen ob eine Karte gefunden wurde.
		 * 
		 * @param card
		 * @return
		 */

		public boolean cardFound(ObjectCard card) {
			return false;
		}

		/**
		 * Methode um zu �berpr�fen ob alle Karten gefunden wurde
		 * 
		 * @return
		 */

		public boolean isAllFound() {
			return false;
		}

		/**
		 * �berschreiben der Object Methode "toString". Umwandlung des Objektes in einen
		 * String.
		 */

		@Override
		public String toString() {
			return null;
		}

	}

}
