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
	}

	/**
	 * Methode um zu überprüfen ob der Spieler etwas gefunden hat
	 * 
	 * @return
	 */

	public boolean isFound() {
		return false;
	}

	/**
	 * Methode um zu überprüfen ob ein bestimmter Schatz schon gefunden wurde
	 */

	public void found(Treasure treasure) {

	}

	/**
	 * Überschreiben der Object Methode "equals" Vergleicht zwei Objekte auf
	 * Inhaltsgleichheit.
	 */

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	/**
	 * Überschreiben der Object Methode "toString". Umwandlung des Objektes in einen
	 * String.
	 */

	@Override
	public String toString() {
		return null;
	}

}
