package Backend.Cards;

import Backend.Treasure;

public class ObjectCard {

	/**
	 * Attribute der Klasse ObjectCard
	 */

	private boolean found;
	private Treasure treasure;

	/**
	 * Konstruktor der Klasse Object Card
	 * 
	 * @param treasure
	 */

	public ObjectCard(Treasure treasure) {

		this.treasure = treasure;
		this.found = false;
	}

	/**
	 * Methode um zu überprüfen ob der Spieler etwas gefunden hat
	 * 
	 * @return
	 */
	public boolean isFound() {

		return found;
	}

	/**
	 * Methode um eine Karte als gefunden zu markieren.
	 */
	public void found(Treasure treasure) {

		if (this.treasure.equals(treasure)) {
			this.found = true;
		}

	}

	/**
	 * Überschreiben der Object Methode "equals" Vergleicht zwei Objekte auf
	 * Inhaltsgleichheit.
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
	 */

	@Override
	public String toString() {
		return "" + this.treasure + "" + this.found;
	}

}
