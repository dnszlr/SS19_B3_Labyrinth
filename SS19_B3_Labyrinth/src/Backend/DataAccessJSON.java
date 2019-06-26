package Backend;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import Backend.Figure.Figure;
import Interface.DataAccess;

public class DataAccessJSON implements DataAccess {

	@SuppressWarnings("unchecked")
	@Override
	public void writeToFile(Object json, String path) throws IOException {

		FileWriter saver = null;

		String[] players = (String[]) json;
		JSONArray buffer = new JSONArray();
		for (String player : players) {
			JSONObject save = new JSONObject();
			String[] split = player.split(";");
			save.put("name", split[0]);
			save.put("color", split[1]);
			buffer.add(save);
		}

		try {
			saver = new FileWriter(path);
			saver.write(buffer.toJSONString());
			saver.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Object readFile(String path) throws IOException, ClassNotFoundException {

		RingBufferPlayers buffer = new RingBufferPlayers();
		JSONParser parser = new JSONParser();

		try {

			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject obj = (JSONObject) jsonArray.get(i);

				String name = (String) obj.get("name");
				String colorString = (String) obj.get("color");
				Color color = Color.valueOf(colorString);
				Figure temp = new Figure(name, color);
				buffer.addFigure(temp);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			parser.reset();
		}

		return buffer;
	}

}
