package solitaire.eventlistener;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import solitaire.cards.Deck;
import solitaire.gui.BoardPanel;
import solitaire.gui.DeckPile;

public class MouseListener extends MouseAdapter {
	
	private BoardPanel game;
	
	public MouseListener(BoardPanel b) {
		game = b;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Component pressed = e.getComponent().getComponentAt(e.getPoint());
		
		if (pressed instanceof DeckPile) {
			deckPile();
		}
		
		e.getComponent().repaint();
	}
	
	public void deckPile() {
		Deck hand = game.getDeckPile().getDeck();
		Deck waste = game.getWastePile().getDeck();
		if(!hand.isEmpty()) {
			waste.push(hand.pop());
			waste.top().flip();				
		}
		else {
			int size = waste.getStack().size();
			for (int i = 0; i < size; i++) {
				hand.push(waste.pop());
			}
		}
	}

}
