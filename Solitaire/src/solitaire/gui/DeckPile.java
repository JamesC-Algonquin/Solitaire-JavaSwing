package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;
import solitaire.cards.Card;
import solitaire.cards.Deck;

public class DeckPile extends CardPile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeckPile(int x, int y) {
		super(x, y);
		super.setSize(90, 135);
		
		deck = new Deck();
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		//Draw 2d image to the panel
		g.setColor(new Color(0, 115, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if(!deck.isEmpty()) {
			g.drawImage(Card.getBackground(), 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	
	

}
