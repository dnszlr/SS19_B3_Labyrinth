package Backend.Figure;

import Backend.Color;
import Backend.Cards.ObjectCard;

public class Figure {

	private String name;
	private int[] pos;
	private Color color;
	private ObjectCard treasureCard;
	private CardsStack cardstack;

	public Figure(String name, Color color) {
		
		this.cardstack = new CardsStack();
	}

	public Figure(String name, Color color, int[] pos) {

	}

	public String getName() {
		return null;
	}

	public Color getColor() {
		return null;
	}

	public ObjectCard getTreasureCard() {
		return null;
	}

	public int[] getPos() {
		return null;
	}

	public String getFoundCard() {
		return null;
	}

	public void setPos(int[] pos) {

	}

	public void addCard(ObjectCard card) {

	}
	
	public ObjectCard drawCard() {
		return null;
	}
	
	public boolean isFound(ObjectCard card) {
		return false;
	}
	
	public boolean isAllFound() {
		return false;
	}
	
	@Override
	public  String toString() {
		return null;
	}
	
	private class CardsStack {

		private ObjectCard[] foundCards;
		private ObjectCard[] objectsCards;

		public CardsStack() {

		}
		
		public void addCard(ObjectCard card) {
			
		}
		
		public ObjectCard drawCard() {
			return null;
		}
		
		public boolean cardFound(ObjectCard card) {
			return false;
		}
		
		public boolean isAllFound() {
			return false;
		}

		@Override
		public String toString() {
			return null;
		}

	}

}
