package solitaire.gui;

import javax.swing.JPanel;

import solitaire.cards.Deck;

//Abstract panel for all piles of cards
public abstract class CardPile extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int x, y;
	protected Deck deck;
	
	public CardPile(int x, int y) {
		super.setLocation(x, y);
	}
	
	public Deck getDeck() {
		return deck;
	}

}
