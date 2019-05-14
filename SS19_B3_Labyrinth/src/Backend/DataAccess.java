package Backend;

import java.io.IOException;

public interface DataAccess {

	public void writeToFile(Object ser, String path, String type) throws IOException;

	public Object readFile(String path, String type) throws IOException, ClassNotFoundException;

	

}
