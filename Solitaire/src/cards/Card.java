package cards;

public class Card {
	
	private int value;
	private String suit;
	
	public Card(int v, String s) {
		value = v;
		suit = s;
	}

	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}
	

}
