package Interface;

import java.io.IOException;

public interface DataAccess {

	public void writeToFile(Object ser, String path) throws IOException;

	public Object readFile(String path) throws IOException, ClassNotFoundException;

	

}
