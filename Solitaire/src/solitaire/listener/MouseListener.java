package solitaire.listener;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import solitaire.cards.Deck;
import solitaire.gui.BoardPanel;
import solitaire.gui.DeckPile;
import solitaire.gui.WastePile;

public class MouseListener extends MouseAdapter {
	
	private BoardPanel game;
	private EventListener event;
	
	public MouseListener(BoardPanel b) {
		game = b;
		event = new EventListener();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Component pressed = e.getComponent().getComponentAt(e.getPoint());
		
		if (pressed instanceof DeckPile) {
			event.deckPile(game);
		}
		if(pressed instanceof WastePile) {
			event.wastePile(game);
		}
		
		e.getComponent().repaint();
	}
	

}
