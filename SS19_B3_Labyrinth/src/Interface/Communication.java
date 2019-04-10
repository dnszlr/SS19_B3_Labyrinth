package Interface;

import Backend.Color;

public interface Communication {
	
	/**
	 * Interface der Klasse Communikation welche von Manager implementiert wird.
	 * @return
	 */

	public String[][] getMap();

	public String[] getPlayers();

	public String getActivePlayer();

	public String getActivePlayerTreasureCard();

	public String getFoundTreasures(Color color);

	public String addPlayer(String name, Color color);

	public String startGame();

	public boolean moveGears(String position);

	public boolean moveFigure(int[] position);

	public String hasWon();

	public boolean endRound();

	public boolean saveGame(String path);

	public boolean loadGame(String path);
	
	public String getFreeMazeCard();
	
	public String rotateGear(String direction);

	
	/**
	 * Siehe Klasse Manager für genauere Beschreibung der Methoden
	 */

}
