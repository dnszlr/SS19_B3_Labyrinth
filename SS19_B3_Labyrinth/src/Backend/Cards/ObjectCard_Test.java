package Backend.Cards;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Backend.Treasure;

public class ObjectCard_Test {
	
	ObjectCard test;

	@Before
	public void initialize() {
		test = new ObjectCard(Treasure.bat);	
	}
	
	@Test
	public void testFound() {
		
		test.found(Treasure.bat);
		assertTrue(test.isFound());
		
	}

}
