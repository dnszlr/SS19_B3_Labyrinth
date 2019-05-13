package Backend.Figure;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Backend.Color;
import Backend.Treasure;
import Backend.Cards.ObjectCard;

public class Figure_Test {

	Figure figure;
	ObjectCard card1;
	ObjectCard card2;
	ObjectCard card3;
	ObjectCard card4;

	@Before
	public void initialize() {

		figure = new Figure("Dennis", Color.RED);
		card1 = new ObjectCard(Treasure.bat);
		card2 = new ObjectCard(Treasure.book);
		card3 = new ObjectCard(Treasure.chest);
		card4 = new ObjectCard(Treasure.crown);
		figure.addCard(card1);
		figure.addCard(card2);
		figure.addCard(card3);
		figure.addCard(card4);
		figure.drawCard();

	}

	@Test
	public void TestAddCard() {

		figure.addCard(card1);
		boolean result = figure.isAllFound();
		assertFalse(result);

	}
	
	@Test
	public void testDrawCard() {
		
		figure.drawCard();
		assertTrue(figure.getTreasureCard().equals(card2));
		figure.drawCard();
		assertTrue(figure.getTreasureCard().equals(card3));
	}
	
	@Test
	public void testCardFound() {
		
		assertTrue(figure.getTreasureCard().equals(card1));
		assertTrue(figure.isFound(card1));
	}
	
	@Test
	public void testIsAllFound() {
		
		figure.isFound(card1);
		figure.drawCard();
		figure.isFound(card2);
		figure.drawCard();
		figure.isFound(card3);
		figure.drawCard();
		figure.isFound(card4);
		boolean result = figure.isAllFound();
		
		assertTrue(result);
		
	}
	
	@Test
	public void testToString() {
		
		
		assertEquals("Dennis;RED;bat;false;[book;false, chest;false, crown;false];[];[0, 0]", figure.toString());
		
		
	}

}
