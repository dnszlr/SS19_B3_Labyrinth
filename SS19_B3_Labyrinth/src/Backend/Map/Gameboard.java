package Backend.Map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import Backend.Color;
import Backend.Direction;
import Backend.PositionsCard;
import Backend.Treasure;
import Backend.Figure.Figure;

public class Gameboard implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Attribute der Klasse Gameboard.
	 */
	private MazeCard freeCard;
	private MazeCard[][] map;

	/**
	 * Konstruktor der Klasse Gameboard.
	 */
	public Gameboard() {

		this.map = new MazeCard[7][7];
		this.map[Color.RED.getPos()[0]][Color.RED.getPos()[1]] = new CurveCard(Color.RED, null);
		this.map[Color.YELLOW.getPos()[0]][Color.YELLOW.getPos()[1]] = new CurveCard(Color.YELLOW, null);
		this.map[Color.BLUE.getPos()[0]][Color.BLUE.getPos()[1]] = new CurveCard(Color.BLUE, null);
		this.map[Color.GREEN.getPos()[0]][Color.GREEN.getPos()[1]] = new CurveCard(Color.GREEN, null);
		this.map[2][0] = new CrotchCard(Treasure.book);
		this.map[4][0] = new CrotchCard(Treasure.moneybag);
		this.map[0][2] = new CrotchCard(Treasure.map);
		this.map[2][2] = new CrotchCard(Treasure.crown);
		this.map[4][2] = new CrotchCard(Treasure.key);
		this.map[6][2] = new CrotchCard(Treasure.skull);
		this.map[0][4] = new CrotchCard(Treasure.ring);
		this.map[2][4] = new CrotchCard(Treasure.chest);
		this.map[4][4] = new CrotchCard(Treasure.emerald);
		this.map[6][4] = new CrotchCard(Treasure.sword);
		this.map[2][6] = new CrotchCard(Treasure.menorah);
		this.map[4][6] = new CrotchCard(Treasure.helmet);

		List<MazeCard> freeCards = generateFreeCards();
		Collections.shuffle(freeCards);

		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				if (this.map[i][j] == null) {
					this.map[i][j] = freeCards.get(0);
					freeCards.remove(0);
				}
			}
		}

		setAllNeighbours();

		this.freeCard = freeCards.get(0);
	}

	/**
	 * Methode um ein neue Labyrinthkarte zu generieren.
	 * 
	 * @param List<Treasure> treasures
	 * @return MazeCard
	 */
	private MazeCard generateNewMaze(List<Treasure> treasures) {
		int randomTreasure;
		if (treasures.size() > 1) {
			randomTreasure = (int) (Math.random() * (treasures.size() - 1) + 1);
		} else {
			randomTreasure = 0;
		}
		MazeCard generatedMaze;
		if (treasures.size() >= 7) {
			generatedMaze = new CrotchCard(treasures.get(randomTreasure));
		} else if (treasures.size() > 0 && treasures.size() < 7) {
			generatedMaze = new CurveCard(null, treasures.get(randomTreasure));
		} else {
			generatedMaze = new CurveCard(null, null);
		}

		return generatedMaze;

	}

	/**
	 * Erstellt eine Liste mit Karten die frei auf dem Feld verteilbar sind.
	 * 
	 * @return List<MazeCard>
	 */

	private List<MazeCard> generateFreeCards() {

		List<MazeCard> freeCards = new ArrayList<MazeCard>();
		List<Treasure> treasures = new ArrayList<Treasure>(Arrays.asList(Treasure.owl, Treasure.ghost,
				Treasure.sorceress, Treasure.rat, Treasure.dragon, Treasure.spider, Treasure.bat, Treasure.gnome,
				Treasure.moth, Treasure.lizard, Treasure.spook, Treasure.scarab));
		for (int a = 0; a <= 33; a++) {
			if (a <= 21) {
				freeCards.add(generateNewMaze(treasures));
				if (a <= 11) {
					treasures.remove(freeCards.get(a).getTreasure());
				}
			} else {
				freeCards.add(new EvenCard());
			}
		}

		return freeCards;

	}

	/**
	 * Methode um für jede Karte die Nachbarkarten zu ermitteln
	 */
	private void setAllNeighbours() {

		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				if (i > 0 && i < this.map.length - 1 && j > 0 && j < this.map[i].length - 1) {
					this.map[i][j].setNeighboring(this.map[i][j - 1], Direction.north);
					this.map[i][j].setNeighboring(this.map[i + 1][j], Direction.east);
					this.map[i][j].setNeighboring(this.map[i][j + 1], Direction.south);
					this.map[i][j].setNeighboring(this.map[i - 1][j], Direction.west);
				} else if (i == 0 && j == 0 || i == 0 && j == this.map[i].length - 1
						|| i == this.map.length - 1 && j == this.map[i].length - 1
						|| i == this.map.length - 1 && j == 0) {
					this.map[0][0].setNeighboring(this.map[1][0], Direction.east);
					this.map[0][0].setNeighboring(this.map[0][1], Direction.south);
					this.map[6][0].setNeighboring(this.map[5][0], Direction.west);
					this.map[6][0].setNeighboring(this.map[6][1], Direction.south);
					this.map[0][6].setNeighboring(this.map[0][5], Direction.north);
					this.map[0][6].setNeighboring(this.map[1][6], Direction.east);
					this.map[6][6].setNeighboring(this.map[6][5], Direction.north);
					this.map[6][6].setNeighboring(this.map[5][6], Direction.west);
				} else if (i == 0 && j > 0 && j < this.map[i].length - 1) {
					this.map[i][j].setNeighboring(this.map[i][j - 1], Direction.north);
					this.map[i][j].setNeighboring(this.map[i + 1][j], Direction.east);
					this.map[i][j].setNeighboring(this.map[i][j + 1], Direction.south);
				} else if (i > 0 && i < this.map.length - 1 && j == 0) {
					this.map[i][j].setNeighboring(this.map[i + 1][j], Direction.east);
					this.map[i][j].setNeighboring(this.map[i][j + 1], Direction.south);
					this.map[i][j].setNeighboring(this.map[i - 1][j], Direction.west);
				} else if (i == this.map.length - 1 && j > 0 && j < this.map[i].length - 1) {
					this.map[i][j].setNeighboring(this.map[i][j - 1], Direction.north);
					this.map[i][j].setNeighboring(this.map[i][j + 1], Direction.south);
					this.map[i][j].setNeighboring(this.map[i - 1][j], Direction.west);
				} else if (i > 0 && i < this.map.length - 1 && j == this.map[i].length - 1) {
					this.map[i][j].setNeighboring(this.map[i][j - 1], Direction.north);
					this.map[i][j].setNeighboring(this.map[i + 1][j], Direction.east);
					this.map[i][j].setNeighboring(this.map[i - 1][j], Direction.west);
				}
			}
		}

	}

	/**
	 * Methode um die Figuren auf dem Spielfeld zu platzieren.
	 * 
	 * @param Figure[] figures
	 */
	public void placeFigures(Figure[] figures) {

		for (int i = 0; i < figures.length; i++) {
			if (figures[i].getColor().equals(this.getMapCard(0, 0).getColor())) {
				this.getMapCard(0, 0).addFigure(figures[i]);
			} else if (figures[i].getColor().equals(this.getMapCard(6, 0).getColor())) {
				this.getMapCard(6, 0).addFigure(figures[i]);
			} else if (figures[i].getColor().equals(this.getMapCard(6, 6).getColor())) {
				this.getMapCard(6, 6).addFigure(figures[i]);
			} else if (figures[i].getColor().equals(this.getMapCard(0, 6).getColor())) {
				this.getMapCard(0, 6).addFigure(figures[i]);
			}

		}

	}

	/**
	 * Methode um die Labyrinthkarten zu verschieben. gibt neue freecard nach jedem
	 * schieben bekommt jeder neue nachbarn
	 * 
	 * @param PositionCard move
	 * @param MazeCard     card
	 * @return MazeCard
	 */
	public MazeCard moveGears(PositionsCard move, MazeCard card) {

		MazeCard newFreeCard = null;
		MazeCard[] safer = new MazeCard[7];
		switch (move) {
		case A2:
			if (this.map[1][6].getFigures().size() > 0) {
				card.addFigures(this.map[1][6].getFigures());
			}
			newFreeCard = getMapCard(1, 6);
			for (int i = 0; i < this.map[1].length - 1; i++) {
				safer[i + 1] = this.map[1][i];
			}
			safer[0] = card;
			this.map[1] = safer;

			break;

		case A4:
			if (this.map[3][6].getFigures().size() > 0) {
				card.addFigures(this.map[3][6].getFigures());
			}
			newFreeCard = getMapCard(3, 6);
			for (int i = 0; i < this.map[3].length - 1; i++) {
				safer[i + 1] = this.map[3][i];
			}
			safer[0] = card;
			this.map[3] = safer;

			break;

		case A6:

			if (this.map[5][6].getFigures().size() > 0) {
				card.addFigures(this.map[5][6].getFigures());
			}
			newFreeCard = getMapCard(5, 6);
			for (int i = 0; i < this.map[5].length - 1; i++) {
				safer[i + 1] = this.map[5][i];
			}
			safer[0] = card;
			this.map[5] = safer;

			break;

		case G2:
			if (this.map[1][0].getFigures().size() > 0) {
				card.addFigures(this.map[1][0].getFigures());
			}
			newFreeCard = getMapCard(1, 0);
			for (int i = this.map[1].length - 1; i > 0; i--) {
				safer[i - 1] = this.map[1][i];
			}
			safer[6] = card;
			this.map[1] = safer;
			break;

		case G4:
			if (this.map[3][0].getFigures().size() > 0) {
				card.addFigures(this.map[3][0].getFigures());
			}
			newFreeCard = getMapCard(3, 0);
			for (int i = this.map[3].length - 1; i > 0; i--) {
				safer[i - 1] = this.map[3][i];
			}
			safer[6] = card;
			this.map[3] = safer;

			break;
		case G6:
			if (this.map[5][0].getFigures().size() > 0) {
				card.addFigures(this.map[5][0].getFigures());
			}
			newFreeCard = getMapCard(5, 0);
			for (int i = this.map[5].length - 1; i > 0; i--) {
				safer[i - 1] = this.map[5][i];
			}
			safer[6] = card;
			this.map[5] = safer;

			break;

		case B1:
			if (this.map[6][1].getFigures().size() > 0) {
				card.addFigures(this.map[6][1].getFigures());
			}
			newFreeCard = getMapCard(6, 1);
			for (int i = 0; i < this.map.length - 1; i++) {
				safer[i + 1] = this.map[i][1];
			}
			safer[0] = card;
			for (int i = 0; i < this.map.length; i++) {
				this.map[i][1] = safer[i];
			}

			break;

		case D1:
			if (this.map[6][3].getFigures().size() > 0) {
				card.addFigures(this.map[6][3].getFigures());
			}
			newFreeCard = getMapCard(6, 3);
			for (int i = 0; i < this.map.length - 1; i++) {
				safer[i + 1] = this.map[i][3];
			}
			safer[0] = card;
			for (int i = 0; i < this.map.length; i++) {
				this.map[i][3] = safer[i];
			}

			break;
		case F1:
			if (this.map[6][5].getFigures().size() > 0) {
				card.addFigures(this.map[6][5].getFigures());
			}
			newFreeCard = getMapCard(6, 5);
			for (int i = 0; i < this.map.length - 1; i++) {
				safer[i + 1] = this.map[i][5];
			}
			safer[0] = card;
			for (int i = 0; i < this.map.length; i++) {
				this.map[i][5] = safer[i];
			}

			break;

		case B7:
			if (this.map[0][1].getFigures().size() > 0) {
				card.addFigures(this.map[0][1].getFigures());
			}
			newFreeCard = getMapCard(0, 1);
			for (int i = this.map.length - 1; i > 0; i--) {
				safer[i - 1] = this.map[i][1];
			}
			safer[6] = card;
			for (int i = 0; i < this.map.length; i++) {
				this.map[i][1] = safer[i];
			}

			break;

		case D7:
			if (this.map[0][3].getFigures().size() > 0) {
				card.addFigures(this.map[0][3].getFigures());
			}
			newFreeCard = getMapCard(0, 3);
			for (int i = this.map.length - 1; i > 0; i--) {
				safer[i - 1] = this.map[i][3];
			}
			safer[6] = card;
			for (int i = 0; i < this.map.length; i++) {
				this.map[i][3] = safer[i];
			}

			break;
		case F7:
			if (this.map[0][5].getFigures().size() > 0) {
				card.addFigures(this.map[0][5].getFigures());
			}
			newFreeCard = getMapCard(0, 5);
			for (int i = this.map.length - 1; i > 0; i--) {
				safer[i - 1] = this.map[i][5];
			}
			safer[6] = card;
			for (int i = 0; i < this.map.length; i++) {
				this.map[i][5] = safer[i];
			}

			break;
		}

		setAllNeighbours();
		this.freeCard = newFreeCard;
		return this.freeCard;

	}

	/**
	 * Getter um die aktuell freie Karte zu erhalten.
	 * 
	 * @return MazeCard
	 */
	public MazeCard getFreeCard() {

		return this.freeCard;
	}

	/**
	 * Getter um eine bestimmte Koordinate auf dem Spielfeld zu erfragen.
	 * 
	 * @param int x
	 * @param int y
	 * @return MazeCard
	 */
	public MazeCard getMapCard(int x, int y) {

		MazeCard maze = this.map[x][y];

		return maze;
	}

	/**
	 * Methode um zu erfragen ob ein Zug möglich wäre.
	 * 
	 * @param int[] currentPos
	 * @param int[] oldPos
	 * @param Figure figure
	 * @return boolean result
	 */

	public boolean moveFigure(int[] currentPos, int[] oldPos, Figure figure) {

		boolean result = false;
		int[][] visited = new int[7][7];
		if (moveFigureWithArray(currentPos, oldPos, visited, figure)) {
			result = true;
		}

		return result;

	}
	/**
	 * Hilfsmethode für moveFigure.
	 * @param int[] currentPos
	 * @param int[] oldPos
	 * @param int[][] visited
	 * @param Figure figure
	 * @return boolean
	 */
	private boolean moveFigureWithArray(int[] currentPos, int[] oldPos, int[][] visited, Figure figure) {

		if (oldPos[0] == currentPos[0] && oldPos[1] == currentPos[1]) {
			return true;
		}
		if (visited[oldPos[0]][oldPos[1]] == 1) {
			return false;
		}

		visited[oldPos[0]][oldPos[1]] = 1;
		MazeCard old = getMapCard(oldPos[0], oldPos[1]);

		if (old.getNeighboring(Direction.north) != null && old.getWall()[0] == 0
				&& old.getNeighboring(Direction.north).getWall()[2] == 0) {
			if (moveFigureWithArray(currentPos, new int[] { oldPos[0], oldPos[1] - 1 }, visited, figure)) {
				return true;

			}

		}
		if (old.getNeighboring(Direction.east) != null && old.getWall()[1] == 0
				&& old.getNeighboring(Direction.east).getWall()[3] == 0) {
			if (moveFigureWithArray(currentPos, new int[] { oldPos[0] + 1, oldPos[1] }, visited, figure)) {
				return true;

			}

		}
		if (old.getNeighboring(Direction.south) != null && old.getWall()[2] == 0
				&& old.getNeighboring(Direction.south).getWall()[0] == 0) {
			if (moveFigureWithArray(currentPos, new int[] { oldPos[0], oldPos[1] + 1 }, visited, figure)) {
				return true;

			}
		}
		if (old.getNeighboring(Direction.west) != null && old.getWall()[3] == 0
				&& old.getNeighboring(Direction.west).getWall()[1] == 0) {
			if (moveFigureWithArray(currentPos, new int[] { oldPos[0] - 1, oldPos[1] }, visited, figure)) {
				return true;

			}

		}

		return false;
	}

}
