package Interface;

import Backend.Color;

public interface Communication {
	
	/**
	 * Interface der Klasse Communikation welche von Manager implementiert wird.
	 * @return
	 */

	public String[][] getMap();

	public boolean moveFigure(Color color, int[] pos);

	public String[] getPlayers();

	public String getActivePlayer();

	public String getActivePlayerTreasureCard();

	public String getFoundTreasures(Color color);

	public String addPlayer(String name, Color color);

	public String startGame();

	public boolean moveGears(String position);

	public boolean moveFigure(int[] position);

	public String hasWon();

	public boolean endGame();

	public boolean saveGame(String path);

	public boolean loadGame(String path);
	
	/**
	 * Siehe Klasse Manager für genauere Beschreibung der Methoden
	 */

}
