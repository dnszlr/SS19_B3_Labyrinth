package Backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Backend.Cards.ObjectCard;
import Backend.Figure.Figure;
import Backend.Map.CrotchCard;
import Backend.Map.CurveCard;
import Backend.Map.EvenCard;
import Backend.Map.Gameboard;
import Backend.Map.MazeCard;
import Interface.Communication;

public class Manager implements Communication, Serializable {

	/**
	 * Klasse Manager implementiert das Interface Communication.
	 */

	/**
	 * Attribute der Klasse Manager.
	 */
	private Color color;
	private Treasure treasure;
	private Gameboard gameboard;
	private RingBufferPlayers players;
	private ArrayList<ObjectCard> objectCards;
	private boolean isMoveFigur;
	private boolean isPlaceMazeCard;
	private PositionsCard checkPosition;
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor der Klasse Manager
	 */

	public Manager() {

		this.players = new RingBufferPlayers();
		this.objectCards = new ArrayList<ObjectCard>();
		this.gameboard = new Gameboard();
		this.isMoveFigur = false;

	}
	/**
	 * CSV Laden.
	 * @param reader
	 * @throws IOException
	 */
	public Manager(BufferedReader reader) throws IOException { 
																

		String line = reader.readLine();
		String[] fields;
		while (!line.equals("LP")) {
			fields = line.split(";");
			String name = fields[0];
			Color color = Color.valueOf(fields[1]);
			int[] pos = new int[] { Integer.parseInt(fields[2]), Integer.parseInt(fields[3]) };
			Figure atm = new Figure(name, color, pos);
			ArrayList<ObjectCard> safer = new ArrayList<ObjectCard>();
			for (int i = 4; i < fields.length - 2; i = i + 2) {
				ObjectCard card = new ObjectCard(Treasure.valueOf(fields[i]));
				if (fields[i + 1].equals("true")) {
					card.found(Treasure.valueOf(fields[i]));
					safer.add(card);
				} else {
					safer.add(card);
				}

			}
			for (ObjectCard o : safer) {
				if (o.isFound() == false) {
					atm.addCard(o);
				} else {
					atm.isFound(o);
				}
			}
			atm.drawCard();
			this.players = new RingBufferPlayers();
			this.players.addFigure(atm);
			line = reader.readLine();
		}
		line = reader.readLine();
		this.isMoveFigur = Boolean.parseBoolean(line);
		line = reader.readLine();
		if (line.equals("null")) {
			this.checkPosition = null;
		} else {
			this.checkPosition = PositionsCard.valueOf(line);
		}
		line = reader.readLine();
		if (line.equals("null")) {
			this.objectCards = new ArrayList<ObjectCard>();
		} else {
			fields = line.split(";");
			this.objectCards = new ArrayList<ObjectCard>();
			for (int i = 0; i < fields.length; i = i + 2) {
				this.objectCards.add(new ObjectCard(Treasure.valueOf(fields[i])));
			}
		}
		line = reader.readLine();
		ArrayList<MazeCard> maze = new ArrayList<MazeCard>();
		while (!line.equals("csvEnd")) {
			fields = line.split(";");
			if (fields[0].equals("EvenCard")) {
				EvenCard mazeCard = new EvenCard(new int[] { Integer.parseInt(fields[1]), Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), Integer.parseInt(fields[4]) });
				maze.add(mazeCard);

			} else if (fields[0].equals("CurveCard")) {
				if (fields[5].equals("null") && fields[6].equals("null")) {
					CurveCard mazeCard = new CurveCard(new int[] { Integer.parseInt(fields[1]),
							Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]) },
							null, null);
					maze.add(mazeCard);
				} else if (fields[6].equals("null")) {
					CurveCard mazeCard = new CurveCard(
							new int[] { Integer.parseInt(fields[1]), Integer.parseInt(fields[2]),
									Integer.parseInt(fields[3]), Integer.parseInt(fields[4]) },
							Color.valueOf(fields[5]), null);
					maze.add(mazeCard);

				} else if (fields[5].equals("null")) {
					CurveCard mazeCard = new CurveCard(
							new int[] { Integer.parseInt(fields[1]), Integer.parseInt(fields[2]),
									Integer.parseInt(fields[3]), Integer.parseInt(fields[4]) },
							null, Treasure.valueOf(fields[6]));
					maze.add(mazeCard);
				}

			} else if (fields[0].equals("CrotchCard")) {
				CrotchCard mazeCard = new CrotchCard(
						new int[] { Integer.parseInt(fields[1]), Integer.parseInt(fields[2]),
								Integer.parseInt(fields[3]), Integer.parseInt(fields[4]) },
						Treasure.valueOf(fields[6]));
				maze.add(mazeCard);

			}
			line = reader.readLine();
		}
		this.gameboard = new Gameboard(maze);
		
		Figure safer = this.players.getActivePlayer();
		do {
			this.gameboard
					.getMapCard(this.players.getActivePlayer().getPos()[0], this.players.getActivePlayer().getPos()[1])
					.addFigure(this.players.getActivePlayer());
			
			this.players.nextPlayer();
		} while (!this.players.getActivePlayer().equals(safer));

	}

	/**
	 * Getter der Map des Gameboards.
	 * 
	 * @return String[][]
	 */
	@Override
	public String[][] getMap() {

		String[][] map = new String[7][7];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {

				String card = this.gameboard.getMapCard(i, j).toString();
				map[i][j] = card;
			}
		}

		return map;
	}

	/**
	 * Getter für die Spieler die am Spiel teilnehmen.
	 * 
	 * @return String[]
	 */
	@Override
	public String[] getPlayers() {
		List<String> getPlayers = new ArrayList<String>();
		Figure safer = this.players.getActivePlayer();

		do {
			getPlayers.add(this.players.getActivePlayer().toString());
			this.players.nextPlayer();
		} while (!this.players.getActivePlayer().equals(safer));

		String[] players = getPlayers.toArray(new String[0]);
		return players;

	}

	/**
	 * Getter für den Spieler der gerade am Zug ist.
	 * 
	 * @return String
	 */
	@Override
	public String getActivePlayer() {

		String activePlayer = this.players.getActivePlayer().toString();
		return activePlayer;
	}

	/**
	 * Getter für die Treasure Karte des Spielers der gerade am Zug ist.
	 */
	@Override
	public String getActivePlayerTreasureCard() {
		String activePlayerTreasureCard = this.players.getActivePlayer().getTreasureCard().toString();
		return activePlayerTreasureCard;
	}

	/**
	 * Getter für die bereits gefunden Treasures.
	 * 
	 * @return String
	 */
	@Override
	public String getFoundTreasures(String color) {
		String foundCards = null;
		try {
			Figure safer = this.players.getActivePlayer();
			Color playerColor = Color.valueOf(color);
			while (!this.players.getActivePlayer().getColor().equals(playerColor)) {
				this.players.nextPlayer();
			}
			foundCards = this.players.getActivePlayer().getFoundCards();
			while (!this.players.getActivePlayer().equals(safer)) {
				this.players.nextPlayer();
			}
		} catch (Exception e) {
			foundCards = "Couldn't find the cards of " + color;
		}

		return foundCards;

	}

	/**
	 * Methode um Spieler dem Spiel hinzuzufügen.
	 * 
	 * @return String
	 */
	@Override
	public String addPlayer(String name, String color) {

		String addPlayer = "Name can't be null or color name must be red, yellow, green or blue";
		if (name != null && (color.toLowerCase().equals("red") || color.toLowerCase().equals("blue")
				|| color.toLowerCase().equals("yellow") || color.toLowerCase().equals("green"))) {
			Color playerColor = Color.valueOf(color);
			Figure newPlayer = new Figure(name, playerColor);
			if (this.players.addFigure(newPlayer)) {
				addPlayer = newPlayer.toString();
			} else {
				addPlayer = "No duplicated colors allowed!";
			}
		}
		return addPlayer;
	}

	/**
	 * Methode um das Spiel zu starten.
	 * 
	 * @return String
	 */
	@Override
	public String startGame() {
		String startGame = null;
		try {

			if (this.players.getActivePlayer() != null) {
				for (Treasure i : Treasure.values()) {
					this.objectCards.add(new ObjectCard(i));
				}
				Collections.shuffle(this.objectCards);
				Figure[] participants = new Figure[getPlayers().length];
				for (int i = 0; i < participants.length; i++) {
					participants[i] = this.players.nextPlayer();
				}
				while (this.objectCards.size() > 0) {

					this.players.getActivePlayer().addCard(this.objectCards.get(0));
					this.objectCards.remove(0);
					if (this.players.getActivePlayer().getTreasureCard() == null) {
						this.players.getActivePlayer().drawCard();

					}

					this.players.nextPlayer();

				}

				gameboard.placeFigures(participants);

				startGame = getMap() + ";" + objectCards.toString();
			}

		} catch (Exception e) {
			startGame = "Please add Players befor you start the game";
		}

		return startGame;
	}

	/**
	 * Methode um die Wegkarten zu bewegen.
	 * 
	 * @return String
	 */
	@Override
	public String moveGears(String position) throws Exception {
		String moveResult = null;
		try {
			PositionsCard positionCard = PositionsCard.valueOf(position.toUpperCase());
			if (checkMoveGears(positionCard)) {
				this.checkPosition = positionCard;
				this.gameboard.moveGears(positionCard, this.gameboard.getFreeCard());
				this.isMoveFigur = true;
				this.checkPosition = positionCard;
				moveResult = gameboard.getFreeCard().toString();
			} else {
				moveResult = "Couldn't move, try again with other position";
			}
		} catch (Exception e) {
			moveResult = "Wrong position name";
		}

		return moveResult;
	}

	/**
	 * Methode um herauszufinden ob moveGears zulässig ist.
	 * 
	 * @param positionCard
	 * @return boolean
	 */

	private boolean checkMoveGears(PositionsCard positionCard) {
		boolean result = false;
		if (this.checkPosition == null) {
			result = true;
		} else {
			switch (positionCard) {
			case A2:
				if (!this.checkPosition.equals(PositionsCard.G2)) {
					result = true;
				}
				break;

			case A4:
				if (!this.checkPosition.equals(PositionsCard.G4)) {
					result = true;
				}
				break;

			case A6:
				if (!this.checkPosition.equals(PositionsCard.G6)) {
					result = true;
				}
				break;
			case G2:
				if (!this.checkPosition.equals(PositionsCard.A2)) {
					result = true;
				}
				break;

			case G4:
				if (!this.checkPosition.equals(PositionsCard.A4)) {
					result = true;
				}
				break;

			case G6:
				if (!this.checkPosition.equals(PositionsCard.A6)) {
					result = true;
				}
				break;

			case B1:
				if (!this.checkPosition.equals(PositionsCard.B7)) {
					result = true;
				}
				break;

			case D1:
				if (!this.checkPosition.equals(PositionsCard.D7)) {
					result = true;
				}
				break;

			case F1:
				if (!this.checkPosition.equals(PositionsCard.F7)) {
					result = true;
				}
				break;

			case B7:
				if (!this.checkPosition.equals(PositionsCard.B1)) {
					result = true;
				}
				break;

			case D7:
				if (!this.checkPosition.equals(PositionsCard.D1)) {
					result = true;
				}
				break;

			case F7:
				if (!this.checkPosition.equals(PositionsCard.F1)) {
					result = true;
				}
				break;

			default:
				break;
			}

		}

		return result;
	}

	/**
	 * Methode um die Spielfiguren zu bewegen.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean moveFigure(int[] position) {
		boolean result = false;
		if (position[0] <= 6 && position[0] >= 0 && position[1] <= 6 && position[1] >= 0) {
			if (this.gameboard.moveFigure(position, this.players.getActivePlayer().getPos(),
					this.players.getActivePlayer())) {
				this.gameboard
						.getMapCard(this.players.getActivePlayer().getPos()[0],
								this.players.getActivePlayer().getPos()[1])
						.removeFigure(this.players.getActivePlayer());
				this.gameboard.getMapCard(position[0], position[1]).addFigure(this.players.getActivePlayer());
				this.players.getActivePlayer().setPos(position);
				this.players.getActivePlayer().getTreasureCard()
						.found(this.gameboard.getMapCard(position[0], position[1]).getTreasure());
				result = true;

			}
		}

		return result;
	}

	/**
	 * Methode um den Sieger zu ermitteln.
	 * 
	 * @return String
	 */
	@Override
	public String hasWon() {
		String result = "notWon";
		if (this.players.getActivePlayer().isAllFound() && this.gameboard
				.getMapCard(this.players.getActivePlayer().getPos()[0], this.players.getActivePlayer().getPos()[1])
				.isStartFromFigure()) {
			result = this.players.getActivePlayer().getName();
		}
		return result;
	}

	/**
	 * Methode um eine Runde zu beenden.
	 * 
	 * @return String - tells if round could be ended or not.
	 */
	@Override
	public String endRound() {
		String result = "You have to move the gears once per round!";
		if (this.isMoveFigur == true) {
			if (this.players.getActivePlayer().getTreasureCard().isFound()) {
				this.players.getActivePlayer().isFound(players.getActivePlayer().getTreasureCard());
				if (hasWon().equals(this.players.getActivePlayer().getName())) {
					return "GameOver: " + this.players.getActivePlayer().getName() + " won the game!";
				} else {
					players.getActivePlayer().drawCard();
				}

			}
			this.players.nextPlayer();
			result = players.getActivePlayer().toString();
			this.isMoveFigur = false;
		}

		return result;
	}

	/**
	 * Methode um das Spiel zu speichern über CSV oder Serialisierung.
	 * 
	 * @return String
	 */
	@Override
	public String saveGame(String path, String type) {
		String saver = null;

		switch (type) {
		case "serialization":
			DataAccessSER saveSER = new DataAccessSER();
			try {
				saveSER.writeToFile(Manager.this, path);
				saver = "Game saved successfully!";
			} catch (IOException e) {
				saver = "Game couldn't save!";
				System.err.println(saver);
			}
			break;

		case "csv":
			DataAccessCSV saveCSV = new DataAccessCSV();
			try {
				saveCSV.writeToFile(Manager.this, path);
				saver = "Game saved successfully!";
			} catch (IOException e) {
				saver = "Game couldn't save!";
				System.err.println(saver);
			}

			break;
		}

		return saver;
	}

	/**
	 * Methode um ein gespeichertes Spiel zu laden.
	 *
	 * @return String
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@Override
	public String loadGame(String path, String type) throws ClassNotFoundException, IOException {
		String loader = null;

		switch (type) {
		case "serialization":
			
				DataAccessSER loadSER = new DataAccessSER();
				Manager deSer = (Manager) loadSER.readFile(path);
				this.gameboard = deSer.gameboard;
				this.players = deSer.players;
				this.objectCards = deSer.objectCards;
				this.isMoveFigur = deSer.isMoveFigur;
				this.checkPosition = deSer.checkPosition;
				loader = "Game successfully loaded!";

			
			break;

		case "csv":
			
			
			DataAccessCSV loadCSV = new DataAccessCSV();
			Manager deCSV = (Manager) loadCSV.readFile(path);
			this.gameboard = deCSV.gameboard;
			this.players = deCSV.players;
			this.objectCards = deCSV.objectCards;
			this.isMoveFigur = deCSV.isMoveFigur;
			this.checkPosition = deCSV.checkPosition;

		}

		return loader;
	}

	/**
	 * Methode um die freie Labyrintkarte zu erfragen.
	 */
	@Override
	public String getFreeMazeCard() {

		String freeCard = this.gameboard.getFreeCard().toString();
		return freeCard;
	}

	/**
	 * Methode um eine Karte zu drehen.
	 * 
	 * @return String
	 */
	@Override
	public String rotateGear(String direction) {
		String rotateGear = "Wrong direction use 'left' or 'right'";
		if (direction != null) {
			if (direction.toLowerCase().equals("left")) {
				this.gameboard.getFreeCard().rotateLeft();
				rotateGear = this.gameboard.getFreeCard().toString();
			} else if (direction.toLowerCase().equals("right")) {
				this.gameboard.getFreeCard().rotateRight();
				rotateGear = this.gameboard.getFreeCard().toString();
			}
		}
		return rotateGear;
	}
	/**
	 * writeToStream Methode
	 * @param pw
	 */
	public void writeToStream(PrintWriter pw) {

		for (int i = 0; i < this.getPlayers().length; i++) {
			pw.println(this.getPlayers()[i] + ".");

		}
		pw.println("LP");

		pw.println(this.isMoveFigur);
		pw.println(this.checkPosition);
		if (this.objectCards.size() == 0) {
			pw.println("null");
		} else {
			pw.println(this.objectCards);
		}
		pw.println(this.getFreeMazeCard() + ".");
		for (int i = 0; i < this.getMap().length; i++) {
			for (int j = 0; j < this.getMap()[i].length; j++) {
				pw.println(this.getMap()[i][j] + ".");

			}
		}
		pw.println("csvEnd");

		pw.flush();

	}

}
