package Interface;

import java.io.IOException;

public interface Communication {
	
	/**
	 * Interface der Klasse Communikation welche von Manager implementiert wird.
	 */

	public String[][] getMap();

	public String[] getPlayers();

	public String getActivePlayer();

	public String getActivePlayerTreasureCard();

	public String getFoundTreasures(String color);

	public String addPlayer(String name, String color);

	public String startGame();

	public String moveGears(String position);

	public boolean moveFigure(int[] position);

	public String hasWon();

	public String endRound();

	public String saveGame(String path, String type) throws IOException;

	public String loadGame(String path, String type) throws ClassNotFoundException, IOException;
	
	public String getFreeMazeCard();
	
	public String rotateGear(String direction);

	
	/**
	 * Siehe Klasse Manager f�r genauere Beschreibung der Methoden
	 */

}
