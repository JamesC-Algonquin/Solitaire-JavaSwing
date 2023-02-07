package solitaire.cards;

import java.util.EmptyStackException;
import java.util.Stack;

public class Deck {
	
	public static final String[] suits = {"h", "d", "s", "c"};
	protected Stack<Card> cards = new Stack<Card>();
	
	public Deck() {
		
	}
	
	public Stack<Card> getStack(){
		return cards;
	}
	
	public void populate() {
		for (String s : suits) {
			for(int i = 1; i<=13; i++) {
				cards.push(new Card(i, s));
			}
		}
	}
	
	public boolean isEmpty() {
		return (cards.isEmpty());
	}
	
	public Card cardPop() {
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
	
	
	
	

}
