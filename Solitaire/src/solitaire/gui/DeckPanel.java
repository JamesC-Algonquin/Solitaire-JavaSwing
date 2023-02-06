package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import solitaire.cards.Card;
import solitaire.cards.Deck;

public class DeckPanel extends CardPile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Deck deck;

	public DeckPanel(int x, int y) {
		super(x, y);
		super.setSize(90, 135);
		
		deck = new Deck();
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		//Draw 2d image to the panel
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(0, 103, 0));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if(!deck.isEmpty()) {
			g2d.drawImage(Card.getBackground(), 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	
	

}
