package Backend.Cards;

import Backend.Treasure;

public class ObjectCard {
	
	private boolean found;
	private Treasure treasure;
	
	public ObjectCard(Treasure treasure) {
		
		this.treasure = treasure;
	}
	
	public boolean isFound() {
		return false;
	}
	
	public void found(Treasure treasure) {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	@Override
	public String toString() {
		return null;
	}

}
