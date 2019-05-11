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
	Figure figure4;
	Figure[] figures;

	@Before
	public void initialize() {
		gameboard = new Gameboard();
		figure1 = new Figure("Player1", Color.BLUE);
		figure2 = new Figure("Player2", Color.YELLOW);
		figure3 = new Figure("Player3", Color.RED);
		figure4 = new Figure("Player3", Color.GREEN);

		figures = new Figure[4];
		figures[0] = figure1;
		figures[1] = figure2;
		figures[2] = figure3;
		figures[3] = figure4;
	}

	@Test
	public void checkGameboard() {

		Gameboard gameboard = new Gameboard();

		System.out.println(gameboard);
		int EvenCard = 0;
		int CurveCard = 0;
		int CrotchCard = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {

				if (gameboard.getMapCard(i, j) instanceof EvenCard) {
					EvenCard++;
				}
				if (gameboard.getMapCard(i, j) instanceof CurveCard) {
					CurveCard++;
				}
				if (gameboard.getMapCard(i, j) instanceof CrotchCard) {
					CrotchCard++;
				}

			}
		}

		System.out.println("EvenCards: " + EvenCard);
		System.out.println("CurveCard: " + CurveCard);
		System.out.println("CrotchCards: " + CrotchCard);

		assertTrue(EvenCard + CurveCard + CrotchCard == 49);
	}

	@Test
	public void checkPlaceFigures() {

		gameboard.placeFigures(figures);

		assertEquals(gameboard.getMapCard(figure1.getPos()[0], figure1.getPos()[1]).getColor(), figure1.getColor());
		assertEquals(gameboard.getMapCard(figure2.getPos()[0], figure2.getPos()[1]).getColor(), figure2.getColor());
		assertEquals(gameboard.getMapCard(figure3.getPos()[0], figure3.getPos()[1]).getColor(), figure3.getColor());
		assertEquals(gameboard.getMapCard(figure4.getPos()[0], figure4.getPos()[1]).getColor(), figure4.getColor());

	}

	@Test
	public void checkMoveGears() {
		gameboard.getMapCard(1, 6).addFigure(figure1);
		MazeCard A2 = gameboard.getMapCard(1, 3);
		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());
		assertEquals(A2, gameboard.getMapCard(1, 4));
		assertTrue(gameboard.getMapCard(1, 0).getFigures().size() == 1);
		gameboard.getMapCard(1, 0).getFigures().remove(0);

		gameboard.getMapCard(3, 6).addFigure(figure1);
		MazeCard A4 = gameboard.getMapCard(3, 3);
		gameboard.moveGears(PositionsCard.A4, gameboard.getFreeCard());
		assertEquals(A4, gameboard.getMapCard(3, 4));
		assertTrue(gameboard.getMapCard(3, 0).getFigures().size() == 1);
		gameboard.getMapCard(3, 0).getFigures().remove(0);

		gameboard.getMapCard(5, 6).addFigure(figure1);
		MazeCard A6 = gameboard.getMapCard(5, 3);
		gameboard.moveGears(PositionsCard.A6, gameboard.getFreeCard());
		assertEquals(A6, gameboard.getMapCard(5, 4));
		assertTrue(gameboard.getMapCard(5, 0).getFigures().size() == 1);
		gameboard.getMapCard(5, 0).getFigures().remove(0);

		gameboard.getMapCard(1, 0).addFigure(figure1);
		MazeCard G2 = gameboard.getMapCard(1, 3);
		gameboard.moveGears(PositionsCard.G2, gameboard.getFreeCard());
		assertEquals(G2, gameboard.getMapCard(1, 2));
		assertTrue(gameboard.getMapCard(1, 6).getFigures().size() == 1);
		gameboard.getMapCard(1, 6).getFigures().remove(0);

		gameboard.getMapCard(3, 0).addFigure(figure1);
		MazeCard G4 = gameboard.getMapCard(3, 3);
		gameboard.moveGears(PositionsCard.G4, gameboard.getFreeCard());
		assertEquals(G4, gameboard.getMapCard(3, 2));
		assertTrue(gameboard.getMapCard(3, 6).getFigures().size() == 1);
		gameboard.getMapCard(3, 6).getFigures().remove(0);

		gameboard.getMapCard(5, 0).addFigure(figure1);
		MazeCard G6 = gameboard.getMapCard(5, 3);
		gameboard.moveGears(PositionsCard.G6, gameboard.getFreeCard());
		assertEquals(G6, gameboard.getMapCard(5, 2));
		assertTrue(gameboard.getMapCard(5, 6).getFigures().size() == 1);
		gameboard.getMapCard(5, 6).getFigures().remove(0);

		gameboard.getMapCard(6, 1).addFigure(figure1);
		MazeCard B1 = gameboard.getMapCard(3, 1);
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		assertEquals(B1, gameboard.getMapCard(4, 1));
		assertTrue(gameboard.getMapCard(0, 1).getFigures().size() == 1);
		gameboard.getMapCard(0, 1).getFigures().remove(0);

		gameboard.getMapCard(6, 3).addFigure(figure1);
		MazeCard D1 = gameboard.getMapCard(3, 3);
		gameboard.moveGears(PositionsCard.D1, gameboard.getFreeCard());
		assertEquals(D1, gameboard.getMapCard(4, 3));
		assertTrue(gameboard.getMapCard(0, 3).getFigures().size() == 1);
		gameboard.getMapCard(0, 3).getFigures().remove(0);

		gameboard.getMapCard(6, 5).addFigure(figure1);
		MazeCard F1 = gameboard.getMapCard(3, 5);
		gameboard.moveGears(PositionsCard.F1, gameboard.getFreeCard());
		assertEquals(F1, gameboard.getMapCard(4, 5));
		assertTrue(gameboard.getMapCard(0, 5).getFigures().size() == 1);
		gameboard.getMapCard(0, 5).getFigures().remove(0);

		gameboard.getMapCard(0, 1).addFigure(figure1);
		MazeCard B7 = gameboard.getMapCard(3, 1);
		gameboard.moveGears(PositionsCard.B7, gameboard.getFreeCard());
		assertEquals(B7, gameboard.getMapCard(2, 1));
		assertTrue(gameboard.getMapCard(6, 1).getFigures().size() == 1);
		gameboard.getMapCard(6, 1).getFigures().remove(0);
		
		gameboard.getMapCard(0, 3).addFigure(figure1);
		MazeCard D7 = gameboard.getMapCard(3, 3);
		gameboard.moveGears(PositionsCard.D7, gameboard.getFreeCard());
		assertEquals(D7, gameboard.getMapCard(2, 3));
		assertTrue(gameboard.getMapCard(6, 3).getFigures().size() == 1);
		gameboard.getMapCard(6, 3).getFigures().remove(0);
		
		gameboard.getMapCard(0, 5).addFigure(figure1);
		MazeCard F7 = gameboard.getMapCard(3, 5);
		gameboard.moveGears(PositionsCard.F7, gameboard.getFreeCard());
		assertEquals(F7, gameboard.getMapCard(2, 5));
		assertTrue(gameboard.getMapCard(6, 5).getFigures().size() == 1);
		gameboard.getMapCard(6, 5).getFigures().remove(0);

	}

	@Test
	public void checkMoveFigure() {
		
		figure1.setPos(new int[] {3,3});

		int[] north = { 3, 2 };
		int[] east = { 4, 3 };
		int[] south = { 3, 4 };
		int[] west = { 2, 3 };
		

//		assertTrue(gameboard.moveFigure(north, figure1.getPos(), figure1));
		assertTrue(gameboard.moveFigure(east, figure1.getPos(), figure1));
//		assertTrue(gameboard.moveFigure(south, figure1.getPos(), figure1));
//		assertTrue(gameboard.moveFigure(west, figure1.getPos(), figure1));

	}

}
