package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import solitaire.cards.Card;

public class DeckPanel extends CardPile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeckPanel(int x, int y) {
		super(x, y);
		super.setSize(90, 135);
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		//Draw 2d image to the panel
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(Color.WHITE);
		
		g2d.drawImage(Card.getBackground(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	

}
