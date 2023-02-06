package solitaire.cards;

import java.util.Stack;

public class Deck {
	
	public static final String[] suits = {"h", "d", "s", "c"};
	public Stack<Card> cards = new Stack<Card>();
	
	public Deck() {
		for (String s : suits) {
			for(int i = 1; i<=13; i++) {
				cards.push(new Card(i, s));
			}
		}
	}
	
	public boolean isEmpty() {
		return (cards.isEmpty());
	}
	
	

}
