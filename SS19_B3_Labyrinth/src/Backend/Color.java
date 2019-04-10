package Backend;

public enum Color {
	
	/**
	 *Die Attribute des Enums Color mit einer (x,y) Position
	 */
	RED(0,0),
	GREEN(0,0),
	BLUE(0,0),
	YELLOW(0,0);
	private static int[] pos;

	/**
	 * Konstruktor für die Klasse Color.
	 * @param x
	 * @param y
	 */
	private Color (int x, int y) {
	}

	/**
	 * Getter für das Attribut pos.
	 * @return
	 */
	public int[] getPos() {
		return pos;
	}
	

}
