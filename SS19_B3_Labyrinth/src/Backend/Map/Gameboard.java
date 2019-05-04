package Backend.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import Backend.Color;
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
		this.map[0][0] = new CurveCard(Color.RED, null);
		this.map[6][0] = new CurveCard(Color.YELLOW, null);
		this.map[6][6] = new CurveCard(Color.BLUE, null);
		this.map[0][6] = new CurveCard(Color.GREEN, null);
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
		List<Treasure> treasures = new ArrayList<Treasure>(Arrays.asList(Treasure.owl, Treasure.ghost,
				Treasure.sorceress, Treasure.rat, Treasure.dragon, Treasure.spider, Treasure.bat, Treasure.gnome,
				Treasure.moth, Treasure.lizard, Treasure.spook, Treasure.scarab));
		Collections.shuffle(treasures);
		List<MazeCard> freeCards = new ArrayList<MazeCard>();
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

		Collections.shuffle(freeCards);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == null) {
					map[i][j] = freeCards.get(0);
					freeCards.remove(0);
				}
			}
		}
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

	/**
	 * Methode um die Figuren auf dem Spielfeld zu platzieren.
	 * 
	 * @param figures
	 */
	public void placeFigures(Figure[] figures) {

	}

	/**
	 * Methode um die Labyrinthkarten zu verschieben.
	 * 
	 * @param move
	 * @param card
	 * @return
	 */
	public MazeCard moveGears(PositionsCard move, MazeCard card) {
		return null;

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

		return this.map[x][y];
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

		return false;
	}

}
