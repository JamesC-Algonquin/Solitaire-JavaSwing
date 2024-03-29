package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;

import solitaire.cards.Card;
import solitaire.cards.Deck;

public class TableauPile extends CardPile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public TableauPile(int x, int y) {
		super(x, y);
		super.setSize(90, 400);
		super.setOpaque(false);
		
		//New deck represents tableau pile stack
		deck = new Deck();
	}
	
	public void dealCards(int index, Deck d) {
		for(int i = 1; i <= index; i++) {
			deck.push(d.pop());
			if (i == index) {
				deck.top().flip();
			}
		}
	}

	public Card getSelectedCard(int y) {
		
		int cardIndex = y/20;
		
		if (cardIndex < deck.getStack().toArray().length) {
			Card selected = (Card) deck.getStack().toArray()[cardIndex];
			if (selected.isFaceUp()) {
				return selected;
			}
		}
		
		return deck.top();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.drawLine(0, 0, this.getWidth()-1, 0);
		g.drawLine(0, 135, this.getWidth()-1, 135);
		g.drawLine(0, 0, 0, 135);
		g.drawLine(this.getWidth()-1, 0, this.getWidth()-1, 135);
		
		
		if(!deck.isEmpty()) {
			int offset = 0;
			for (Card c : deck.getStack()) {
				if(c.isFaceUp()) {
					g.drawImage(c.getFace(), 0, offset, 90, 135, this);
				}
				else {
					g.drawImage(Card.getBackground(), 0, offset, 90, 135, this);
				}
				offset += 20;
			}
		}
	}

}
