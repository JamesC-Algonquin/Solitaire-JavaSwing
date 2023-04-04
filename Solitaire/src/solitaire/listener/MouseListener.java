package solitaire.listener;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import solitaire.cards.Card;
import solitaire.gui.BoardPanel;
import solitaire.gui.CardPile;
import solitaire.gui.DeckPile;
import solitaire.gui.PauseButton;
import solitaire.gui.TableauPile;
import solitaire.gui.UndoButton;
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
		
		game.setMousePosition(e.getPoint());
		
		if (pressed instanceof DeckPile) {
			event.deckPile(game);
		}
		if(pressed instanceof WastePile) {
			selectedPile = game.getWastePile();
			selectedCard = game.getWastePile().getDeck().top();
			if (!selectedPile.getDeck().isEmpty()) {
				game.addMouseImage(selectedCard.getFace());
			}
		}
		if (pressed instanceof TableauPile) {
			selectedPile = (TableauPile) pressed;
			selectedCard = ((TableauPile) selectedPile).getSelectedCard(e.getY() - 250);
			if (!selectedPile.getDeck().isEmpty()) {
				
				Stack<Card> pile = selectedPile.getDeck().getStack();
				int size =  pile.search(selectedCard);
				for(int i = size; i > 0; i--) {
					game.addMouseImage(pile.get(pile.size()- i).getFace());
				}
			}
		}
		if (pressed instanceof PauseButton) {
			game.pauseMenu();
		}
		
		e.getComponent().repaint();
	}
	
		@Override
	public void mouseReleased(MouseEvent e) {
		Component release = e.getComponent().getComponentAt(e.getPoint());
		if (selectedCard != null && selectedPile == game.getWastePile()) {
			if (release instanceof TableauPile) {
				event.wastePileToTableau(game, (TableauPile) release);
			}
			else if (release instanceof WastePile) {
				event.wastePile(game);
			}
		}
		
		if (selectedCard != null && selectedPile instanceof TableauPile) {
			if (release == selectedPile) {
				if (selectedCard == selectedPile.getDeck().top()) {
					event.tableauToFoundation(game, selectedPile);
				}
			}
			else if (release instanceof TableauPile) {
				event.tableauToTableau(game, (TableauPile) selectedPile, (TableauPile) release, selectedCard);
			}
		}
		if (release instanceof UndoButton) {
			game.quickLoadState();
		}
		game.resetMouseImage();
		e.getComponent().repaint();
	}

}
