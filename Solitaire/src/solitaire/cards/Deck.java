package solitaire.cards;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class Deck {
	
	public static final String[] suits = {"h", "d", "s", "c"};
	protected Stack<Card> cards = new Stack<Card>();
	
	public Stack<Card> getStack(){
		return cards;
	}
	
	public void populate() {
		for (String s : suits) {
			for(int i = 1; i<=13; i++) {
				if (s.equals("h") || s.equals("d")) {
					cards.push(new Card(i, s, 1));
				}
				else {
					cards.push(new Card(i, s, 2));
				}
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public boolean isEmpty() {
		return (cards.isEmpty());
	}
	
	public Card pop() {
		try {
		return cards.pop();
		}
		catch(EmptyStackException e) {
			return null;
		}
	}
	
	public void push(Card c) {
		cards.push(c);
	}
	
	public Card top() {
		if (!isEmpty()) {
			return cards.peek();
		}
		else {
			return null;
		}
	}
	
	
	
	

}
