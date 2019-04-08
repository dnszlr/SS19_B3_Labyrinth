package Backend;

public enum Color {

	RED(0,0),
	GREEN(0,0),
	BLUE(0,0),
	YELLOW(0,0);
	
	private static int[] pos;
	
	private Color (int x, int y) {
	}
	
	public int[] getPos() {
		return pos;
	}

}
