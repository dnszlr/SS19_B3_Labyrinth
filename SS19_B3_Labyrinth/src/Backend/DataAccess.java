package Backend;

public interface DataAccess {
	
	public String saveGame(String path, String type);
	
	public String loadGame(String path, String type);

}
