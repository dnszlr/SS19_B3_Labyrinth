package Backend;

import java.io.IOException;

public interface DataAccess {

	public void writeToFile(String path, String type) throws IOException;

	public void readFile(String path, String type) throws IOException, ClassNotFoundException;

}
