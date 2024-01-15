package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

import solitaire.cards.Card;
import solitaire.cards.Deck;

public class WastePile extends CardPile{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean klondike;

	public WastePile(int x, int y, boolean mode) {
		super(x, y);
		if(mode) {
			super.setSize(130, 135);
		}
		else {
			super.setSize(90, 135);
		}
		deck = new Deck();
		
		klondike = mode;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		//Draw 2d image to the panel
		g.setColor(new Color(0, 115, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if(!deck.isEmpty()) {
			if(klondike) {
				Stack<Card> pile = deck.getStack();
				int num;
				if (pile.size() < 3) {
					num = pile.size();
				}
				else {
					num = 3;
				}
				int offset = 0;
				for (int i = num ; i > 0; i--) {
					g.drawImage(pile.get(pile.size() - i).getFace(), offset, 0, 90, this.getHeight(), this);
					offset += 20;
				}
			}
			else {
				g.drawImage(deck.top().getFace(), 0, 0, this.getWidth(), this.getHeight(), this);
				
			}
		}
		
	}
}
