package Backend.Figure;

import java.util.ArrayList;
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
		this.name = name;
		this.color = color;
		this.pos = color.getPos();
	}

	/**
	 * Konstruktor der Klasse Figure.
	 * 
	 * @param name
	 * @param color
	 * @param pos
	 */

//	public Figure(String name, Color color, int[] pos) { Wird dieser Konstruktor überhaupt benötigt, wenn man sich von pos von Color holt?
//
//		this.cardstack = new CardsStack();
//		this.name = name;
//		this.color = color;
//		this.setPos(pos);
//	}

	/**
	 * Getter für das Attribut name.
	 * 
	 * @return
	 */

	public String getName() {

		return this.name;
	}

	/**
	 * Getter für das Attribut color.
	 * 
	 * @return
	 */

	public Color getColor() {

		return this.color;
	}

	/**
	 * Getter für das Attribut treasureCard.
	 * 
	 * @return
	 */

	public ObjectCard getTreasureCard() {

		return this.treasureCard;
	}

	/**
	 * Getter für das Attribut pos.
	 * 
	 * @return
	 */

	public int[] getPos() {

		return this.pos;
	}

	/**
	 * Getter für die gefundenen Karten.
	 * 
	 * @return
	 */

	public String getFoundCards() {

		return this.cardstack.foundCards.toString(); // Auf was zugreifen? --> CardsStack foundCards aber wie?
	}

	/**
	 * Setter für das Attribut pos.
	 * 
	 * @param pos
	 */

	public void setPos(int[] pos) {

		this.pos = pos; // Mehr funktionalität?!

	}

	/**
	 * Methode um eine Karte hinzuzufügen.
	 * 
	 * @param card
	 */
	public void addCard(ObjectCard card) {

		cardstack.addCard(card);

	}

	/**
	 * Methode um eine Karte zu ziehen.
	 * 
	 * @return
	 */

	public ObjectCard drawCard() {

		ObjectCard drawnCard = cardstack.drawCard();

		return drawnCard;
	}

	/**
	 * Methode um abzufragen ob eine Karte gefunden wurde.
	 * 
	 * @param card
	 * @return
	 */

	public boolean isFound(ObjectCard card) {

		return cardstack.cardFound(card);

	}

	/**
	 * Methode um herauszufinden ob alle Karten gefunden wurden
	 * 
	 * @return
	 */

	public boolean isAllFound() {

		return cardstack.isAllFound();

	}

	/**
	 * Überschreiben der Object Methode "toString". Umwandlung des Objektes in einen
	 * String.
	 */

	@Override
	public String toString() {
		return ""+ this.name + "" + this.color + "" + this.treasureCard + "" + this.cardstack + "" + this.pos;
	}

	/**
	 * Innere Klasse CardsStack
	 */
	private class CardsStack {

		/**
		 * Attribute der Klasse CardsStack
		 */
		private ArrayList<ObjectCard> foundCards;
		private ArrayList<ObjectCard> objectsCards;

		/**
		 * Konstruktor für die Klasse CardsStack
		 */

		private CardsStack() {

			foundCards = new ArrayList<ObjectCard>();
			objectsCards = new ArrayList<ObjectCard>();

		}

		/**
		 * Methode um eine Karte dem CardStack hinzuzufügen
		 * 
		 * @param card
		 */

		private void addCard(ObjectCard card) {

			objectsCards.add(card);
		}

		/**
		 * Methode um eine Karte vom CardStack zu ziehen.
		 * 
		 * @return
		 */

		private ObjectCard drawCard() {

			ObjectCard drawCard = objectsCards.get(0);
			objectsCards.remove(0);
			return drawCard;
		}

		/**
		 * Methode um zu überprüfen ob eine Karte gefunden wurde.
		 * 
		 * @param card
		 * @return
		 */

		private boolean cardFound(ObjectCard card) {
			boolean result = false;
			ObjectCard found = null;
			for (ObjectCard i : objectsCards) {
				if (result == false) {
					if (i.equals(card)) {
						found = i;
						result = true;
					}
				}
			}
			foundCards.add(found);
			objectsCards.remove(found);
			return result;
		}

		/**
		 * Methode um zu überprüfen ob alle Karten gefunden wurde
		 * 
		 * @return
		 */

		private boolean isAllFound() {
			boolean result = false;
			if (objectsCards.size() == 0) {
				result = true;
			}
			return result;
		}

		/**
		 * Überschreiben der Object Methode "toString". Umwandlung des Objektes in einen
		 * String.
		 */

		@Override
		public String toString() {

			return "" + this.objectsCards + "" + this.foundCards;
		}

	}

}
