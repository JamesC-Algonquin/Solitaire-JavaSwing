package solitaire.listener;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import solitaire.cards.Card;
import solitaire.gui.BoardPanel;
import solitaire.gui.CardPile;
import solitaire.gui.DeckPile;
import solitaire.gui.TableauPile;
import solitaire.gui.WastePile;

public class MouseListener extends MouseAdapter {
	
	private BoardPanel game;
	private EventListener event;
	private CardPile selectedPile;
	private Card selectedCard;
	


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
			selectedPile = game.getWastePile();
			selectedCard = game.getWastePile().getDeck().top();
			event.wastePile(game);
		}
		if (pressed instanceof TableauPile) {
			selectedPile = (TableauPile) pressed;
			selectedCard = ((TableauPile) selectedPile).getSelectedCard(e.getY() - 220);
			if (selectedCard == selectedPile.getDeck().top()) {
				event.tableauToFoundation(game, selectedPile);
			}
		}
		
		e.getComponent().repaint();
	}
	
		@Override
	public void mouseReleased(MouseEvent e) {
		if (selectedCard != null && selectedPile == game.getWastePile()) {
			Component release = e.getComponent().getComponentAt(e.getPoint());
			if (release instanceof TableauPile) {
				event.wastePileToTableau(game, (TableauPile) release);
			}
		}
		
		if (selectedCard != null && selectedPile instanceof TableauPile) {
			Component release = e.getComponent().getComponentAt(e.getPoint());
			if (release instanceof TableauPile) {
				event.tableauToTableau(game, (TableauPile) selectedPile, (TableauPile) release, selectedCard);
			}
		}
		
		e.getComponent().repaint();
	}

}
