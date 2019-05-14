package Backend.Figure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import Backend.Color;
import Backend.Cards.ObjectCard;

public class Figure implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 * @param String
	 * @param Color
	 */

	public Figure(String name, Color color) {

		this.cardstack = new CardsStack();
		this.name = name;
		this.color = color;
		this.pos = color.getPos();
	}

	/**
	 * Getter f�r das Attribut name.
	 * 
	 * @return String
	 */

	public String getName() {

		return this.name;
	}

	/**
	 * Getter f�r das Attribut color.
	 * 
	 * @return Color
	 */

	public Color getColor() {

		return this.color;
	}

	/**
	 * Getter f�r das Attribut treasureCard.
	 * 
	 * @return ObjectCard
	 */

	public ObjectCard getTreasureCard() {

		return this.treasureCard;
	}

	/**
	 * Getter f�r das Attribut pos.
	 * 
	 * @return int
	 */

	public int[] getPos() {

		return this.pos;
	}

	/**
	 * Getter f�r die gefundenen Karten.
	 * 
	 * @return String
	 */

	public String getFoundCards() {

		return this.cardstack.foundCards.toString();
	}

	/**
	 * Setter f�r das Attribut pos.
	 * 
	 * @param int
	 */

	public void setPos(int[] pos) {

		this.pos = pos; //

	}

	/**
	 * Methode um eine Karte hinzuzuf�gen.
	 * 
	 * @param ObjectCard
	 */
	public void addCard(ObjectCard card) {

		cardstack.addCard(card);

	}

	/**
	 * Methode um eine Karte zu ziehen.
	 * 
	 * @return ObjectCard
	 */

	public ObjectCard drawCard() {

		this.treasureCard = cardstack.drawCard();

		return this.treasureCard;
	}

	/**
	 * Methode um abzufragen ob eine Karte gefunden wurde.
	 * 
	 * @param ObjectCard
	 * @return boolean
	 */

	public boolean isFound(ObjectCard card) {
		boolean result = false;
		if (this.treasureCard.equals(card)) {
			if (this.cardstack.cardFound(card)) {
				this.treasureCard = null;
				result = true;
			}
		}
		return result;

	}

	/**
	 * Methode um herauszufinden ob alle Karten gefunden wurden
	 * 
	 * @return boolean
	 */

	public boolean isAllFound() {
		boolean result = false;
		if(cardstack.isAllFound() && this.treasureCard == null) {
			result = true;
		}

		return result;

	}

	/**
	 * �berschreiben der Object Methode "toString". Umwandlung des Objektes in einen
	 * String.
	 */

	@Override
	public String toString() {
		return this.name + ";" + "" + this.color + ";" + "" + this.treasureCard + ";" + "" + this.cardstack + ";" + ""
				+ Arrays.toString(this.pos);
	}

	/**
	 * Innere Klasse CardsStack
	 */
	private class CardsStack implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * Attribute der Klasse CardsStack
		 */
		private ArrayList<ObjectCard> foundCards;
		private ArrayList<ObjectCard> objectsCards;

		/**
		 * Konstruktor f�r die Klasse CardsStack
		 */

		private CardsStack() {

			foundCards = new ArrayList<ObjectCard>();
			objectsCards = new ArrayList<ObjectCard>();

		}

		/**
		 * Methode um eine Karte dem CardStack hinzuzuf�gen
		 * 
		 * @param ObjectCard
		 */

		private void addCard(ObjectCard card) {

			objectsCards.add(card);
		}

		/**
		 * Methode um eine Karte vom CardStack zu ziehen.
		 * 
		 * @return ObjectCard
		 */

		private ObjectCard drawCard() {

			ObjectCard drawCard = objectsCards.get(0);
			objectsCards.remove(0);
			return drawCard;
		}

		/**
		 * Methode um zu �berpr�fen ob eine Karte gefunden wurde.
		 * 
		 * @param ObjectCard
		 * @return boolean
		 */

		private boolean cardFound(ObjectCard card) {
			boolean result = false;
			if (foundCards.add(card)) {
				result = true;
			}
			return result;
		}

		/**
		 * Methode um zu �berpr�fen ob alle Karten gefunden wurde
		 * 
		 * @return boolean
		 */

		private boolean isAllFound() {
			boolean result = false;
			if (objectsCards.size() == 0) {
				result = true;
			}
			return result;
		}

		/**
		 * �berschreiben der Object Methode "toString". Umwandlung des Objektes in einen
		 * String.
		 */

		@Override
		public String toString() {

			return "" + this.objectsCards.toString() + ";" + "" + this.foundCards.toString();
		}

	}

}
