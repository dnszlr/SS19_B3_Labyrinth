package Backend;

import java.io.File;
import java.io.IOException;
import Interface.DataAccess;
import com.fasterxml.jackson.databind.ObjectMapper;

import Backend.Figure.Figure;

public class DataAccessJSON implements DataAccess {

	@Override
	public void writeToFile(Object ser, String path) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(path), ser);
		
		
	}

	@Override
	public Object readFile(String path) throws IOException, ClassNotFoundException {

		ObjectMapper mapper = new ObjectMapper();
		Figure players = mapper.readValue(new File(path), Backend.Figure.Figure.class);
		
		
		
		return players;
	}

}
