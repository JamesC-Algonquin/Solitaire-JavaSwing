package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import solitaire.cards.Deck;

public class BoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DeckPile deckPile;
	private WastePile wastePile;
	private FoundationPile[] foundationPiles;
	
	
	public BoardPanel() {
		super.setLayout(null);
		
		//Create and draw deck panel to board
		deckPile = new DeckPile(30, 30);
		add(deckPile);
		
		wastePile = new WastePile(170, 30);
		add(wastePile);
		
		foundationPiles = new FoundationPile[4];
		for(int i = 0; i < foundationPiles.length; i++) {
			foundationPiles[i] = new FoundationPile(380 + 120 * i, 30, Deck.suits[i]);
			add(foundationPiles[i]);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Set color to dark green, adjust size to dimension parameters.
		g.setColor(new Color(0, 153, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

}
