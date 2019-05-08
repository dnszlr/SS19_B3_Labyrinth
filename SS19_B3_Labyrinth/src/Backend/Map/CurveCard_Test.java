package Backend.Map;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import Backend.Color;
import Backend.Direction;
import Backend.Treasure;
import Backend.Figure.Figure;

public class CurveCard_Test {

	CurveCard tester;
	CurveCard north;
	CurveCard east;
	CurveCard south;
	CurveCard west;
	Figure adder;
	Figure adderer;
	ArrayList<Figure> added = new ArrayList<Figure>();
	
	

	@Before
	public void initialize() {
		tester = new CurveCard(Color.RED, null);
		north = new CurveCard(Color.RED, null);
		east = new CurveCard(null, Treasure.bat);
		south = new CurveCard(null, null);
		west = new CurveCard(Color.GREEN, Treasure.chest);
		adder = new Figure("hans", Color.RED);
		adderer = new Figure("torben", Color.GREEN);
	}

	@Test
	public void checkRotateLeft() {
		
		System.out.println(Arrays.toString(tester.getWall()));
		tester.rotateLeft();
		System.out.println(Arrays.toString(tester.getWall()));
	}

	@Test
	public void checkRotateRight() {
		
		System.out.println(Arrays.toString(tester.getWall()));
		tester.rotateRight();
		System.out.println(Arrays.toString(tester.getWall()));
	}
	
	@Test
	public void checkSetAndGetNeighbours() {
		tester.setNeighboring(north, Direction.north);
		tester.setNeighboring(east, Direction.east);
		tester.setNeighboring(south, Direction.south);
		tester.setNeighboring(west, Direction.west);
		
		assertTrue(tester.getNeighboring(Direction.north).equals(north));
	}
	
	@Test
	public void checkAddFigure() {
		
		int size = tester.getFigures().size();
		tester.addFigure(adder);
		assertFalse(size == tester.getFigures().size());
	}
	
	@Test
	public void checkAddFigures() {
		added.add(adder);
		added.add(adderer);
		
		int size = tester.getFigures().size();
		tester.addFigures(added);
		assertFalse(size == tester.getFigures().size());
	}
	
	@Test
	public void checkRemoveFigure() {
		
		tester.addFigure(adder);
		tester.addFigure(adderer);
		int size = tester.getFigures().size();
		tester.removeFigure(adder);
		assertFalse(size == tester.getFigures().size());
		
	}
	
	@Test
	public void checkRemoveFigures() {
		tester.addFigure(adder);
		tester.addFigure(adderer);
		
		tester.removeFigures();
		assertTrue(tester.getFigures().size() == 0);
	}
	
	 @Test
	 public void checkIsStart() {
		 assertTrue(north.isStart());
	 }
	 
	 @Test
	 public void checkIsStartFromFigure() {
		 tester.addFigure(adder);
		 tester.addFigure(adderer);
		 
		 assertTrue(tester.isStartFromFigure());
		 
	 }
	 
	 @Test
	 public void checkToString() {
		 System.out.println(tester.toString());
	 }
	
	

}
