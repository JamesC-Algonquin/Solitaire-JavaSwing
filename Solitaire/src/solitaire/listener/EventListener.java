package solitaire.listener;

import solitaire.cards.Deck;
import solitaire.gui.BoardPanel;
import solitaire.gui.FoundationPile;

public class EventListener {
	
	public void wastePile(BoardPanel game) {
		Deck waste = game.getWastePile().getDeck();
		
		if (waste.isEmpty()) {
			return;
		}
		
		for (FoundationPile foundation : game.getFoundationPiles()) {
			if (foundation.getSuit() == waste.top().getSuit()) {
				if(foundation.getDeck().isEmpty() && waste.top().getValue() == 1) {
					foundation.getDeck().push(waste.pop());
				}
				else if(!foundation.getDeck().isEmpty() && foundation.getDeck().top().getValue() == waste.top().getValue() - 1) {
					foundation.getDeck().push(waste.pop());
				}
			}
		}
		
	}

	public void deckPile(BoardPanel game) {
		Deck hand = game.getDeckPile().getDeck();
		Deck waste = game.getWastePile().getDeck();
		if(!hand.isEmpty()) {
			waste.push(hand.pop());
			if(!waste.top().isFaceUp()) {
				waste.top().flip();	
			}
		}
		else {
			int size = waste.getStack().size();
			for (int i = 0; i < size; i++) {
				hand.push(waste.pop());
			}
		}
	}


}
