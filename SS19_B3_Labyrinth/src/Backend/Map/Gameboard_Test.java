package Backend.Map;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Backend.Color;
import Backend.PositionsCard;
import Backend.Figure.Figure;

public class Gameboard_Test {

	Gameboard gameboard;
	Figure figure1;
	Figure figure2;
	Figure figure3;
	Figure[] figures;

	@Before
	public void initialize() {
		gameboard = new Gameboard();
		figure1 = new Figure("Player1", Color.BLUE);
		figure2 = new Figure("Player2", Color.YELLOW);
		figure3 = new Figure("Player3", Color.RED);

		figures = new Figure[3];
		figures[0] = figure1;
		figures[1] = figure2;
		figures[2] = figure3;
	}

	@Test
	public void checkGameboard() {

		Gameboard gameboard = new Gameboard();

		System.out.println(gameboard);
	}

	@Test
	public void checkAddPlayers() {

		gameboard.placeFigures(figures);

		assertEquals(gameboard.getMapCard(figure1.getPos()[0], figure1.getPos()[1]).getColor(), figure1.getColor());

	}

	@Test
	public void checkMoveGears() {
		MazeCard atm = gameboard.getMapCard(3, 3);
		gameboard.moveGears(PositionsCard.A4, gameboard.getFreeCard());
		assertEquals(atm, gameboard.getMapCard(3, 4));
//		System.out.println(atm.toString());
//		System.out.println(gameboard.getMapCard(3, 4).toString());

		MazeCard atm2 = gameboard.getMapCard(3, 3);
		gameboard.moveGears(PositionsCard.G4, gameboard.getFreeCard());
		assertEquals(atm2, gameboard.getMapCard(3, 2));
//		System.out.println(atm2.toString());
//		System.out.println(gameboard.getMapCard(3, 2).toString());

		MazeCard atm3 = gameboard.getMapCard(3, 1);
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		assertEquals(atm3, gameboard.getMapCard(4, 1));
//		System.out.println(atm3.toString());
//		System.out.println(gameboard.getMapCard(4, 1).toString());

		MazeCard atm4 = gameboard.getMapCard(3, 1);
		gameboard.moveGears(PositionsCard.B7, gameboard.getFreeCard());
		assertEquals(atm4, gameboard.getMapCard(2, 1));
//		System.out.println(atm4.toString());
//		System.out.println(gameboard.getMapCard(2, 1).toString());
	}

	@Test
	public void checkMoveFigure() {

		int[] a = { 6, 5 };

		assertTrue(gameboard.moveFigure(a, figure1.getPos(), figure1));

	}

}
