package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import solitaire.cards.Deck;
import solitaire.listener.MouseListener;

public class BoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DeckPile deckPile;
	private WastePile wastePile;
	private FoundationPile[] foundationPiles;
	private TableauPile[] tableauPiles;
	
	
	public BoardPanel() {
		super.setLayout(null);
		//Create table elements
		newGame();
		//Draw table elements
		drawTable();
		//Deal cards to tableau piles
		dealCards();
		
		MouseListener listener = new MouseListener(this);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	public void dealCards() {
		//deal Appropriate number of cards for each tableau
		for (int i = 0; i < tableauPiles.length; i++ ) {
			tableauPiles[i].dealCards(i + 1, deckPile.getDeck());
		}
	}
	
	public void drawTable() {
		//Create and draw deck panel to board
		//Run only once at initialization
		add(deckPile);
		add(wastePile);
		for(int i = 0; i < foundationPiles.length; i++) {
			add(foundationPiles[i]);
		}
		for(int i = 0; i < tableauPiles.length; i++) {
			add(tableauPiles[i]);	
			}
	}
	
	public void newGame() {
		// Is used for initial game and all new games
		//new deck panel
		deckPile = new DeckPile(30, 30);
		//populate deck of cards
		deckPile.getDeck().populate();
		//shuffle the deck
		deckPile.getDeck().shuffle();
		//New waste pile
		wastePile = new WastePile(150, 30);
		//New foundation piles
		foundationPiles = new FoundationPile[4];
		for(int i = 0; i < foundationPiles.length; i++) {
			foundationPiles[i] = new FoundationPile(390 + 120 * i, 30, Deck.suits[i]);
		}
		//New tableau piles
		tableauPiles = new TableauPile[7];
		for(int i = 0; i < tableauPiles.length; i++) {
			tableauPiles[i] = new TableauPile(30 + 120 * i, 220);			
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Set color to dark green, adjust size to dimension parameters.
		g.setColor(new Color(0, 153, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	
	public DeckPile getDeckPile() {
		return deckPile;
	}
	

	public WastePile getWastePile() {
		return wastePile;
	}
	
	
	public FoundationPile[] getFoundationPiles() {
		return foundationPiles;
	}


	public TableauPile[] getTableauPiles() {
		return tableauPiles;
	}

	
	
}
