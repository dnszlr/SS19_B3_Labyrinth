package JUNIT;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import Backend.Color;
import Backend.Direction;
import Backend.PositionsCard;
import Backend.Figure.Figure;
import Backend.Map.CrotchCard;
import Backend.Map.CurveCard;
import Backend.Map.EvenCard;
import Backend.Map.Gameboard;
import Backend.Map.MazeCard;

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
		figure1 = new Figure("figure1", Color.RED);
		figure2 = new Figure("figure2", Color.YELLOW);
		figure3 = new Figure("figure3", Color.GREEN);
		figure4 = new Figure("figure4", Color.BLUE);

		figures = new Figure[4];
		figures[0] = figure1;
		figures[1] = figure2;
		figures[2] = figure3;
		figures[3] = figure4;
	}

	@Test
	public void checkGameboard() {

		Gameboard gameboard = new Gameboard();

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

//		System.out.println("EvenCards: " + EvenCard);
//		System.out.println("CurveCard: " + CurveCard);
//		System.out.println("CrotchCards: " + CrotchCard);

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

		figure1.setPos(new int[] { 1, 1 });
		gameboard.getMapCard(1, 1).addFigure(figure1);
		figure2.setPos(new int[] { 5, 1 });
		gameboard.getMapCard(5, 1).addFigure(figure2);
		figure3.setPos(new int[] { 1, 5 });
		gameboard.getMapCard(1, 5).addFigure(figure3);
		figure4.setPos(new int[] { 5, 5 });
		gameboard.getMapCard(5, 5).addFigure(figure4);


//		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
		
//		gameboard.moveGears(PositionsCard.A6, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.A6, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.A6, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.A6, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.A6, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.A6, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.A6, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure2.getPos()));
		
//		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
		
//		gameboard.moveGears(PositionsCard.B7, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B7, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B7, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B7, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B7, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B7, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
//		gameboard.moveGears(PositionsCard.B7, gameboard.getFreeCard());
//		System.out.println(Arrays.toString(figure1.getPos()));
//		System.out.println(Arrays.toString(figure2.getPos()));
		

		
		
		gameboard.moveGears(PositionsCard.F7, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.D7, gameboard.getFreeCard());
		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
		gameboard.moveGears(PositionsCard.G6, gameboard.getFreeCard());
//		System.out.println(gameboard.getMapCard(1, 0).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 2).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 4).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 6).getFigures().toString());

		MazeCard A4 = gameboard.getMapCard(3, 3);
		gameboard.moveGears(PositionsCard.A4, gameboard.getFreeCard());
		assertEquals(A4, gameboard.getMapCard(3, 4));
		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
//		System.out.println(gameboard.getMapCard(3, 0).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 2).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 4).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 6).getFigures().toString());
		gameboard.moveGears(PositionsCard.F7, gameboard.getFreeCard());

		MazeCard A6 = gameboard.getMapCard(5, 3);
		gameboard.moveGears(PositionsCard.A6, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.G6, gameboard.getFreeCard());
		
		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
//		System.out.println(gameboard.getMapCard(5, 0).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 2).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 4).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 6).getFigures().toString());
		gameboard.moveGears(PositionsCard.D7, gameboard.getFreeCard());
		MazeCard G2 = gameboard.getMapCard(1, 3);
		gameboard.moveGears(PositionsCard.G2, gameboard.getFreeCard());
		
		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
		gameboard.moveGears(PositionsCard.A4, gameboard.getFreeCard());
//		System.out.println(gameboard.getMapCard(1, 0).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 2).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 4).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 6).getFigures().toString());

		MazeCard G4 = gameboard.getMapCard(3, 3);
		gameboard.moveGears(PositionsCard.G4, gameboard.getFreeCard());
	
		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
//		System.out.println(gameboard.getMapCard(3, 0).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 2).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 4).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 6).getFigures().toString());

		MazeCard G6 = gameboard.getMapCard(5, 3);
		gameboard.moveGears(PositionsCard.G6, gameboard.getFreeCard());
	
		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
//		System.out.println(gameboard.getMapCard(5, 0).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 2).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 4).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 6).getFigures().toString());

		MazeCard B1 = gameboard.getMapCard(3, 1);
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
	
		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
//		System.out.println(gameboard.getMapCard(0, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(2, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(4, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(6, 1).getFigures().toString());

		MazeCard D1 = gameboard.getMapCard(3, 3);
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.D1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
	
		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
//		System.out.println(gameboard.getMapCard(0, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(2, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(4, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(6, 3).getFigures().toString());
		gameboard.moveGears(PositionsCard.F7, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());

		MazeCard F1 = gameboard.getMapCard(3, 5);
		gameboard.moveGears(PositionsCard.F1, gameboard.getFreeCard());

		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
//		System.out.println(gameboard.getMapCard(0, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(2, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(4, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(6, 5).getFigures().toString());

		MazeCard B7 = gameboard.getMapCard(3, 1);
		gameboard.moveGears(PositionsCard.B7, gameboard.getFreeCard());

		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
//		System.out.println(gameboard.getMapCard(0, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(2, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(4, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 1).getFigures().toString());
//		System.out.println(gameboard.getMapCard(6, 1).getFigures().toString());
		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.A2, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());
		gameboard.moveGears(PositionsCard.B1, gameboard.getFreeCard());

		MazeCard D7 = gameboard.getMapCard(3, 3);
		MazeCard free = gameboard.getFreeCard();
		gameboard.moveGears(PositionsCard.D7, gameboard.getFreeCard());

		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
//		System.out.println(gameboard.getMapCard(0, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(2, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(4, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 3).getFigures().toString());
//		System.out.println(gameboard.getMapCard(6, 3).getFigures().toString());

		MazeCard F7 = gameboard.getMapCard(3, 5);
		gameboard.moveGears(PositionsCard.F7, gameboard.getFreeCard());
		assertEquals(F7, gameboard.getMapCard(2, 5));
		gameboard.moveGears(PositionsCard.D7, gameboard.getFreeCard());
		assertTrue(this.gameboard.getFreeCard().getFigures().size() == 0);
		gameboard.moveGears(PositionsCard.G4, gameboard.getFreeCard());
//		System.out.println(gameboard.getMapCard(0, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(1, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(2, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(3, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(4, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(5, 5).getFigures().toString());
//		System.out.println(gameboard.getMapCard(6, 5).getFigures().toString());

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {

				System.out.println(i + "|" + j);
//				System.out.println(this.gameboard.getMapCard(i, j).getFigures().toString());
				System.out.println(this.gameboard.getMapCard(i, j).getNeighboring(Direction.north));
				System.out.println(this.gameboard.getMapCard(i, j).getNeighboring(Direction.east));
				System.out.println(this.gameboard.getMapCard(i, j).getNeighboring(Direction.south));
				System.out.println(this.gameboard.getMapCard(i, j).getNeighboring(Direction.west));

			}
		}

//


	}

	@Test
	public void checkMoveFigure() {

		figure1.setPos(new int[] { 3, 3 });

		int[] west = { 2, 3 };

		gameboard.moveFigure(west, figure1.getPos(), figure1);

	}

}
