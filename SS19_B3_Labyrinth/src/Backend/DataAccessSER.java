package Backend;

import java.io.PrintWriter;

public class DataAccessSER {
	
	Manager manager;
	String[][] map;
	String[] players;
	String freeMazeCard;
	
	public DataAccessSER() {
		
		this.map = manager.getMap();
		this.players = manager.getPlayers();
		this.freeMazeCard = manager.getFreeMazeCard();
	}
	
	public void writeToStream(PrintWriter pw) {
		pw.println(map + ";" + players + ";" + freeMazeCard);
		pw.flush();
	}

}
