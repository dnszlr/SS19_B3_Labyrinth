package Backend;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Backend.Cards.ObjectCard;
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
			save.put("color", split[1]); // Beim deserialisieren Color.valueOf()?
			JSONArray pos = new JSONArray();
			pos.add(Integer.parseInt(split[2]));
			pos.add(Integer.parseInt(split[3]));
			save.put("pos", pos);
			save.put("treasureCard", split[4]);
			JSONArray cardstack = new JSONArray();
			JSONArray objectCards = new JSONArray();
			JSONArray foundCards = new JSONArray();
			for (int i = 6; i < split.length; i = i + 2) {
				if (split[i + 1].equals("false")) {
					objectCards.add(split[i]);
				} else {
					foundCards.add(split[i]);
				}
			}
			cardstack.add(objectCards);
			cardstack.add(foundCards);
			save.put("CardsStack", cardstack);
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
				JSONArray position = (JSONArray) obj.get("pos");
				int[] pos = new int[2];
				for (int a = 0; a < position.size(); a++) {
					pos[a] = (int) (long) position.get(a);
				}
				String colorString = (String) obj.get("color");
				Color color = Color.valueOf(colorString);
				String treasure = (String) obj.get("treasureCard");
				ObjectCard treasureCard = new ObjectCard(Treasure.valueOf(treasure));
				Figure temp = new Figure(name, color, pos);
				temp.addCard(treasureCard);
				temp.drawCard();
				JSONArray cards = (JSONArray) obj.get("CardsStack");
				JSONArray objectsCards = (JSONArray) cards.get(0);
				JSONArray foundCards = (JSONArray) cards.get(1);
				if (objectsCards.size() > 0) {
					for (int x = 0; x < objectsCards.size(); x++) {

						ObjectCard objectCard = new ObjectCard(Treasure.valueOf((String) objectsCards.get(x)));
						temp.addCard(objectCard);
					}
				}

				if (foundCards.size() > 0) {
					for (int y = 0; y < objectsCards.size(); y++) {

						ObjectCard foundCard = new ObjectCard(Treasure.valueOf((String) foundCards.get(y)));
						foundCard.found(Treasure.valueOf((String) foundCards.get(y)));
						temp.addCard(foundCard);
					}
				}

				buffer.addFigure(temp);
			}

		} catch (

		ParseException e) {
			e.printStackTrace();
		} finally {
			parser.reset();
		}

		return buffer;
	}

}
