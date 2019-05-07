package Backend.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import Backend.Color;
import Backend.Direction;
import Backend.PositionsCard;
import Backend.Treasure;
import Backend.Figure.Figure;

public class Gameboard {
	/**
	 * Attribute der Klasse Gameboard.
	 */
	private MazeCard freeCard;
	private MazeCard[][] map;

	/**
	 * Konstruktor der Klasse Gameboard
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
	 * @param treasures
	 * @return
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

	private void setAllNeighbours() {

		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				if (i > 0 && i < this.map.length - 1 && j > 0 && j < this.map[i].length - 1) {
					this.map[i][j].setNeighboring(this.map[i][j - 1], Direction.north);
					this.map[i][j].setNeighboring(this.map[i + 1][j], Direction.east);
					this.map[i][j].setNeighboring(this.map[i][j + 1], Direction.south);
					this.map[i][j].setNeighboring(this.map[i - 1][j], Direction.west);
				} else if (i == 0 & j == 0 || i == 0 & j == this.map[i].length - 1
						|| i == this.map.length - 1 & j == this.map[i].length - 1
						|| i == this.map.length - 1 & j == 0) {
					this.map[0][0].setNeighboring(this.map[1][0], Direction.east); // Noch dynamisch machen.
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
				} else if (i > 0 && j < this.map[i].length - 1 && j == this.map[i].length) {
					this.map[i][j].setNeighboring(this.map[i][j - 1], Direction.north);
					this.map[i][j].setNeighboring(this.map[i][j + 1], Direction.south);
					this.map[i][j].setNeighboring(this.map[i - 1][j], Direction.west);
				}
			}
		}

	}

	/**
	 * Methode um die Figuren auf dem Spielfeld zu platzieren.
	 * 
	 * @param figures
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
	 * Methode um die Labyrinthkarten zu verschieben.
	 * 
	 * @param move
	 * @param card
	 * @return
	 */
	public MazeCard moveGears(PositionsCard move, MazeCard card) { // Variable für FreeCard erstellen oder direkt mit
																	// this arbeiten und diese zurückgeben?
		MazeCard mover = this.freeCard;
		MazeCard[][] safer = new MazeCard[7][7];
		switch (move) {
		case A2:
			if (this.map[1][6].getFigures().size() > 0) {
				mover.addFigures(this.map[1][6].getFigures());
			}
			mover = getMapCard(3, 6);
			for (int i = 0; i < this.map[1].length - 1; i++) {
				safer[1][i + 1] = this.map[1][i];
			}
			safer[1][0] = card;
			this.map = safer;

			break;

		case A4:
			if (this.map[3][6].getFigures().size() > 0) {
				mover.addFigures(this.map[3][6].getFigures());
			}
			mover = getMapCard(3, 6);
			for (int i = 0; i < this.map[3].length - 1; i++) {
				safer[3][i + 1] = this.map[3][i];
			}
			safer[3][0] = card;
			this.map = safer;

			break;

		case A6:
			
			if (this.map[5][6].getFigures().size() > 0) {
				mover.addFigures(this.map[5][6].getFigures());
			}
			mover = getMapCard(3, 6);
			for (int i = 0; i < this.map[5].length - 1; i++) {
				safer[5][i + 1] = this.map[5][i];
			}
			safer[5][0] = card;
			this.map = safer;

			break;

		case G2:
			if (this.map[1][0].getFigures().size() > 0) {
				mover.addFigures(this.map[1][0].getFigures());
			}
			for (int i = this.map[1].length - 1; i >= 0; i--) {
				if (i == this.map[1].length - 1) {
					this.map[1][i] = card;
				} else if (i > 0) {
					this.map[1][i - 1] = this.map[1][i];
				} else {
					mover = this.map[1][0];
				}
			}

			break;

		case G4:
			if (temp[3][0].getFigures().size() > 0) {
				mover.addFigures(temp[3][0].getFigures());
			}
			for (int i = this.map[3].length - 1; i >= 0; i--) {
				if (i == this.map[3].length - 1) {
					this.map[3][i] = card;
				} else if (i > 0) {
					this.map[3][i - 1] = temp[3][i];
				} else {
					mover = this.map[3][0];
				}
			}

			break;
		case G6:
			if (temp[5][0].getFigures().size() > 0) {
				mover.addFigures(temp[5][0].getFigures());
			}
			for (int i = this.map[5].length - 1; i >= 0; i--) {
				if (i == this.map[5].length - 1) {
					this.map[5][i] = card;
				} else if (i > 0) {
					this.map[5][i - 1] = temp[5][i];
				} else {
					mover = this.map[5][0];
				}
			}

			break;

		case B1:
			if (temp[6][1].getFigures().size() > 0) {
				mover.addFigures(temp[6][1].getFigures());
			}
			for (int i = 0; i < this.map.length; i++) {

				if (i == 0) {
					this.map[i][1] = card;
				} else if (i < this.map.length - 1) {
					this.map[i + 1][1] = temp[i][1];
				} else {
					mover = temp[6][1];
				}
			}

			break;

		case D1:
			if (temp[6][3].getFigures().size() > 0) {
				mover.addFigures(temp[6][3].getFigures());
			}
			for (int i = 0; i < this.map.length; i++) {

				if (i == 0) {
					this.map[i][3] = card;
				} else if (i < this.map.length - 1) {
					this.map[i + 1][3] = temp[i][3];
				} else {
					mover = temp[6][3];
				}
			}

			break;
		case F1:
			if (temp[6][5].getFigures().size() > 0) {
				mover.addFigures(temp[6][5].getFigures());
			}
			for (int i = 0; i < this.map.length; i++) {

				if (i == 0) {
					this.map[i][5] = card;
				} else if (i < this.map.length - 1) {
					this.map[i + 1][5] = temp[i][5];
				} else {
					mover = temp[6][5];
				}
			}

			break;
		case B7:
			if (temp[0][1].getFigures().size() > 0) {
				mover.addFigures(temp[0][1].getFigures());
			}
			for (int i = this.map.length - 1; i >= 0; i--) {

				if (i == this.map.length - 1) {
					this.map[1][i] = card;
				} else if (i > 0) {
					this.map[i - 1][1] = temp[i][1];
				} else {
					mover = temp[0][1];
				}
			}

			break;

		case D7:
			if (temp[0][3].getFigures().size() > 0) {
				mover.addFigures(temp[0][3].getFigures());
			}
			for (int i = this.map.length - 1; i >= 0; i--) {

				if (i == this.map.length - 1) {
					this.map[3][i] = card;
				} else if (i > 0) {
					this.map[i - 1][3] = temp[i][3];
				} else {
					mover = temp[0][3];
				}
			}

			break;
		case F7:
			if (temp[0][5].getFigures().size() > 0) {
				mover.addFigures(temp[0][5].getFigures());
			}
			for (int i = this.map.length - 1; i >= 0; i--) {

				if (i == this.map.length - 1) {
					this.map[5][i] = card;
				} else if (i > 0) {
					this.map[i - 1][5] = temp[i][5];
				} else {
					mover = temp[0][5];
				}
			}

			break;

		default:
			mover = this.freeCard;
			System.out.println("You can't move the gear at this position");
		}

		setAllNeighbours();

		return mover;

	}

	/**
	 * Getter um die aktuell freie Karte zu erhalten.
	 * 
	 * @return
	 */
	public MazeCard getFreeCard() {

		return this.freeCard;
	}

	/**
	 * Getter um eine bestimmte Koordinate auf dem Spielfeld zu erfragen.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public MazeCard getMapCard(int x, int y) {

		MazeCard maze = this.map[x][y];

		return maze;
	}

	/**
	 * Methode um zu erfragen ob ein Zug möglich wäre?!?!.
	 * 
	 * @param currentPos
	 * @param oldPos
	 * @param figure
	 * @return
	 */
	public boolean moveFigure(int[] currentPos, int[] oldPos, Figure figure) {
		boolean result = false;

		MazeCard current = getMapCard(currentPos[0], currentPos[1]);
		MazeCard old = getMapCard(oldPos[0], oldPos[1]);

		if (current.equals(old.getNeighboring(Direction.north))) {
			if (current.getWall()[0] == 0 && old.getWall()[2] == 0) {
				result = true;
			}
		} else if (current.equals(old.getNeighboring(Direction.east))) {
			if (current.getWall()[1] == 0 && old.getWall()[3] == 0) {
				result = true;
			}
		} else if (current.equals(old.getNeighboring(Direction.south))) {
			if (current.getWall()[2] == 0 && old.getWall()[0] == 0) {
				result = true;
			}
		} else if (current.equals(old.getNeighboring(Direction.west))) {
			if (current.getWall()[3] == 0 && old.getWall()[1] == 0) {
				result = true;
			}
		}

		return result;

	}

}
