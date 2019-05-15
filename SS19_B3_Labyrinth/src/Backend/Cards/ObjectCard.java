package Backend.Cards;

import java.io.Serializable;

import Backend.Treasure;

public class ObjectCard implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Attribute der Klasse ObjectCard
	 */

	private boolean found;
	private Treasure treasure;
	

	/**
	 * Konstruktor der Klasse Object Card
	 * 
	 * @param Treasure treasure
	 * @return ObjectCard
	 */

	public ObjectCard(Treasure treasure) {

		this.treasure = treasure;
		this.found = false;
	}

	/**
	 * Methode um zu überprüfen ob der Spieler etwas gefunden hat
	 * 
	 * @return boolean found
	 */
	public boolean isFound() {

		return found;
	}

	/**
	 * Methode um eine Karte als gefunden zu markieren.
	 * @param Treasure treasure
	 */
	public void found(Treasure treasure) {

		if (this.treasure.equals(treasure)) {
			this.found = true;
		}else {
			this.found = false;
		}

	}

	/**
	 * Überschreiben der Object Methode "equals" vergleicht zwei Objekte auf
	 * Inhaltsgleichheit.
	 * @param Object o
	 * @return boolean result
	 */

	@Override
	public boolean equals(Object o) {
		boolean result = false;
		ObjectCard object;
		if (o instanceof ObjectCard) {
			if (!o.equals(null)) {
				object = (ObjectCard) o;

				if (this.treasure.equals(object.treasure) && this.found == object.found) {
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * Überschreiben der Object Methode "toString". Umwandlung des Objektes in einen
	 * String.
	 * @return String
	 */

	@Override
	public String toString() {
		return "" + this.treasure + ";" + "" + this.found;
	}

}
