package JUNIT;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import Backend.Color;
import Backend.Direction;
import Backend.Treasure;
import Backend.Figure.Figure;
import Backend.Map.CurveCard;

public class CurveCard_Test {

	CurveCard red;
	CurveCard blue;
	CurveCard yellow;
	CurveCard green;
	CurveCard north;
	CurveCard east;
	CurveCard south;
	CurveCard west;
	Figure adder1;
	Figure adder2;
	ArrayList<Figure> added = new ArrayList<Figure>();
	
	

	@Before
	public void initialize() {
		red = new CurveCard(Color.RED, null);
		blue = new CurveCard(Color.BLUE, null);
		yellow = new CurveCard(Color.YELLOW, null);
		green = new CurveCard(Color.GREEN, null);
		north = new CurveCard(null, Treasure.book);
		east = new CurveCard(null, Treasure.bat);
		south = new CurveCard(null, null);
		west = new CurveCard(Color.GREEN, Treasure.chest);
		adder1 = new Figure("hans", Color.RED);
		adder2= new Figure("torben", Color.GREEN);
	}

	@Test
	public void checkRotateLeft() {
		
		System.out.println(Arrays.toString(red.getWall()));
		red.rotateLeft();
		System.out.println(Arrays.toString(red.getWall()));
		red.rotateLeft();
		System.out.println(Arrays.toString(red.getWall()));
		red.rotateLeft();
		System.out.println(Arrays.toString(red.getWall()));
		red.rotateLeft();
		System.out.println(Arrays.toString(red.getWall()));
	}

	@Test
	public void checkRotateRight() {
		
		System.out.println(Arrays.toString(red.getWall()));
		red.rotateRight();
		System.out.println(Arrays.toString(red.getWall()));
		red.rotateRight();
		System.out.println(Arrays.toString(red.getWall()));
		red.rotateRight();
		System.out.println(Arrays.toString(red.getWall()));
		red.rotateRight();
		System.out.println(Arrays.toString(red.getWall()));
	}
	
	@Test
	public void checkSetAndGetNeighbours() {
		red.setNeighboring(north, Direction.north);
		red.setNeighboring(east, Direction.east);
		red.setNeighboring(south, Direction.south);
		red.setNeighboring(west, Direction.west);
		
		assertTrue(red.getNeighboring(Direction.north).equals(north));
		assertTrue(red.getNeighboring(Direction.east).equals(east));
		assertTrue(red.getNeighboring(Direction.south).equals(south));
		assertTrue(red.getNeighboring(Direction.west).equals(west));
	}
	
	@Test
	public void checkAddFigure() {
		
		int size = red.getFigures().size();
		red.addFigure(adder1);
		assertFalse(size == red.getFigures().size());
	}
	
	@Test
	public void checkAddFigures() {
		added.add(adder1);
		added.add(adder2);
		
		int size = red.getFigures().size();
		red.addFigures(added);
		blue.addFigures(added);
		assertFalse(size == red.getFigures().size());
	}
	
	@Test
	public void checkRemoveFigure() {
		
		red.addFigure(adder1);
		red.addFigure(adder2);
		int size = red.getFigures().size();
		red.removeFigure(adder1);
		assertFalse(size == red.getFigures().size());
		
	}
	
	@Test
	public void checkRemoveFigures() {
		red.addFigure(adder1);
		red.addFigure(adder2);
		
		red.removeFigures();
		assertTrue(red.getFigures().size() == 0);
	}
	
	 @Test
	 public void checkIsStart() {
		 assertTrue(red.isStart());
	 }
	 
	 @Test
	 public void checkIsStartFromFigure() {
		 red.addFigure(adder1);
		 red.addFigure(adder2);
		 
		 assertTrue(red.isStartFromFigure());
		 
	 }
	 
	 @Test
	 public void checkToString() {
		 System.out.println(red.toString());
		 System.out.println(green.toString());
		 System.out.println(yellow.toString());
		 System.out.println(blue.toString());
	 }
	
	

}
