package Backend;

public enum Color {
	
	/**
	 *Die Attribute des Enums Color mit einer (x,y) Position
	 */
	RED(0,0),
	GREEN(6,0),
	BLUE(6,6),
	YELLOW(0,6);
	private final int[] pos = {0, 6};

	/**
	 * Konstruktor für die Klasse Color.
	 * @param x
	 * @param y
	 */
	private Color(int x, int y) {
	}

	/**
	 * Getter für das Attribut pos.
	 * @return
	 */
	public int[] getPos() {
		return pos;
	}
	

}
