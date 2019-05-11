package Backend.Cards;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Backend.Treasure;

public class ObjectCard_Test {
	
	ObjectCard bat1;
	ObjectCard bat2;

	@Before
	public void initialize() {
		bat1 = new ObjectCard(Treasure.bat);
		bat2 = new ObjectCard(Treasure.bat);
	}
	
	@Test
	public void testFound() {
		
		bat1.found(Treasure.bat);
		assertTrue(bat1.isFound());
		
	}
	
	@Test
	public void testEquals() {
		
		assertTrue(bat1.equals(bat2));
		bat2.found(Treasure.bat);
		assertFalse(bat1.equals(bat2));
		
	}
	
	@Test
	public void testToString() {
		String bat = bat1.toString();
		String bat1 = "bat;false";
		System.out.println(bat);
		System.out.println(bat1);
		assertEquals(bat, bat1);
	}

}
