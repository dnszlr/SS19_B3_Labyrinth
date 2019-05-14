package Backend;



public enum Color{
	
	/**
	 *Die Attribute des Enums Color mit einer (x,y) Position
	 */
	
	RED(0,0),
	GREEN(0,6),
	BLUE(6,6),
	YELLOW(6,0);
	private final int[] pos = new int[2];  
	/**
	 * Konstruktor für die Klasse Color.
	 * @param int x
	 * @param int y
	 */
	private Color(int x, int y) {
		pos[0] = x;
		pos[1] = y;
	}

	/**
	 * Getter für das Attribut pos.
	 * @return pos 
	 */
	public int[] getPos() {
		return pos;
	}
	

}
