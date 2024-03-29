package solitaire.listener;

import java.util.Stack;

import solitaire.cards.Card;
import solitaire.cards.Deck;
import solitaire.gui.BoardPanel;
import solitaire.gui.CardPile;
import solitaire.gui.FoundationPile;
import solitaire.gui.TableauPile;

public class EventListener {
	
	public void wastePile(BoardPanel game) {
		Deck waste = game.getWastePile().getDeck();
				
		for (FoundationPile foundation : game.getFoundationPiles()) {
			if (!waste.isEmpty() && foundation.getSuit() == waste.top().getSuit()) {
				if(foundation.getDeck().isEmpty() && waste.top().getValue() == 1) {
					foundation.getDeck().push(waste.pop());
					game.getScore().incrementScore(15);
				}
				else if(!foundation.getDeck().isEmpty() && foundation.getDeck().top().getValue() == waste.top().getValue() - 1) {
					foundation.getDeck().push(waste.pop());
					game.getScore().incrementScore(15);
				}
				
			}
		}
		
		for (FoundationPile foundation : game.getFoundationPiles()) {
			if(!foundation.getDeck().isEmpty()) {
				int top = foundation.getDeck().top().getValue();
				if(top != 13) {
					return;
				}
			}
			else {
				return;
			}
		}
		game.winMenu();
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
			game.getScore().incrementScore(-25);
		}
	}
	
	public void klondikeDeckPile(BoardPanel game) {
		Deck hand = game.getDeckPile().getDeck();
		Deck waste = game.getWastePile().getDeck();
		if(!hand.isEmpty()) {
			for (int i = 0; i < hand.getStack().size() && i < 3; i++) {
				waste.push(hand.pop());
				if(!waste.top().isFaceUp()) {
					waste.top().flip();	
				}
			}
		}
		else {
			int size = waste.getStack().size();
			for (int i = 0; i < size; i++) {
				hand.push(waste.pop());
			}
			game.getScore().incrementScore(-25);
		}
	}

	public void wastePileToTableau(BoardPanel game, TableauPile destination) {
		Deck waste = game.getWastePile().getDeck();
		Deck tableau = destination.getDeck();
		
		if (tableau.isEmpty() && waste.top().getValue() == 13) {
			
			tableau.push(waste.pop());
			game.getScore().incrementScore(5);
		}
		else if (!tableau.isEmpty() 
				&& waste.top().getColour() != tableau.top().getColour() 
				&& waste.top().getValue() == tableau.top().getValue() -1) {
		
			tableau.push(waste.pop());
			game.getScore().incrementScore(5);
		}
		
	}

	public void tableauToTableau(BoardPanel game, TableauPile source, TableauPile destination, Card selected) {
		Deck sourceDeck = source.getDeck();
		Deck destDeck = destination.getDeck();
		
		if (destDeck.isEmpty() && selected.getValue() == 13) {
			
			Stack<Card> tempCards = new Stack<Card>();
			//get Cards
			int size = sourceDeck.getStack().search(selected);
			for(int i = 0; i < size; i++) {
				tempCards.push(sourceDeck.pop());
			}
			
			//move cards
			size = tempCards.size();
			for (int i = 0; i < size; i++ ) {
				destDeck.push(tempCards.pop());
			}
			if(!sourceDeck.isEmpty()) {
				sourceDeck.top().flip();
			}
			game.getScore().incrementScore(5);
			
		}
		else if (!destDeck.isEmpty()
				&& selected.getColour() != destDeck.top().getColour()
				&& selected.getValue() == destDeck.top().getValue() - 1) {
			
			Stack<Card> tempCards = new Stack<Card>();
			//get Cards
			int size = sourceDeck.getStack().search(selected);
			for(int i = 0; i < size; i++) {
				tempCards.push(sourceDeck.pop());
			}
			
			//move cards
			size = tempCards.size();
			for (int i = 0; i < size; i++ ) {
				destDeck.push(tempCards.pop());
			}
			if (!sourceDeck.isEmpty() && !sourceDeck.top().isFaceUp()) {
				sourceDeck.top().flip();
				game.getScore().incrementScore(5);
			}
		}
		
	}

	public void tableauToFoundation(BoardPanel game, CardPile selectedPile) {
		Deck tableau = selectedPile.getDeck();
		
		for (FoundationPile foundation : game.getFoundationPiles()) {
			if (!tableau.isEmpty() && foundation.getSuit() == tableau.top().getSuit()) {
				if(foundation.getDeck().isEmpty() && tableau.top().getValue() == 1) {
					foundation.getDeck().push(tableau.pop());
					game.getScore().incrementScore(15);
				}
				else if(!foundation.getDeck().isEmpty() && foundation.getDeck().top().getValue() == tableau.top().getValue() - 1) {
					
					foundation.getDeck().push(tableau.pop());
					game.getScore().incrementScore(15);
				}
			}
		}
		
		if (!tableau.isEmpty() && !tableau.top().isFaceUp()) {
			tableau.top().flip();
			game.getScore().incrementScore(5);
		}
		
		for (FoundationPile foundation : game.getFoundationPiles()) {
			if(!foundation.getDeck().isEmpty()) {
				int top = foundation.getDeck().top().getValue();
				if(top != 13) {
					return;
				}
			}
			else {
				return;
			}
		}
		game.winMenu();
	}


}
