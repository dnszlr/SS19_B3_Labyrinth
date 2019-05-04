package Backend;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Backend.Figure.Figure;

public class RingBufferPlayers_Test {

	RingBufferPlayers buffer;
	Figure red;
	Figure blue;
	Figure green;
	Figure yellow;

	@Before
	public void initialize() {
		buffer = new RingBufferPlayers();
		red = new Figure("Dennis", Color.RED);
		blue = new Figure("Ganni", Color.BLUE);
		green = new Figure("Philipp", Color.GREEN);
		yellow = new Figure("Kevin", Color.YELLOW);
		buffer.addFigure(red);
		buffer.addFigure(blue);
		buffer.addFigure(green);
		buffer.addFigure(yellow);

	}

	@Test
	public void testAddFigure() {
		
		assertTrue (buffer.addFigure(yellow));
	}

	@Test
	public void testNextPlayer() {

		Figure figure = buffer.nextPlayer();
		assertTrue(figure.equals(blue));
		Figure figure2 = buffer.nextPlayer();
		assertTrue(figure2.equals(green));
		Figure figure3 = buffer.nextPlayer();
		assertTrue(figure3.equals(yellow));
		Figure figure4 = buffer.nextPlayer();
		assertTrue(figure4.equals(red));

	}
	
	@Test
	public void testShufflePlayers() {
		
		RingBufferPlayers bufferNew = new RingBufferPlayers();
		bufferNew.addFigure(red);
		bufferNew.addFigure(blue);
		bufferNew.addFigure(green);
		bufferNew.addFigure(yellow);
		
		
		
		buffer.shufflePlayers();
		assertNotSame(bufferNew, buffer); 
		//Sinnlos? Da bei random theoretisch auch die selben Werte Random wieder gewählt werden können. Dann wäre das Ergebnis trotzdem false!
		
	}

}
