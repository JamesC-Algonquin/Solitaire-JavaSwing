package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Stack;

import javax.swing.JPanel;

import solitaire.cards.Deck;
import solitaire.listener.MouseDragListener;
import solitaire.listener.MouseListener;

public class BoardPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DeckPile deckPile;
	private WastePile wastePile;
	private FoundationPile[] foundationPiles;
	private TableauPile[] tableauPiles;
	//private BoardPanel quickSave;
	private ScoreLabel score;
	
	private boolean klondike;
	
	Stack<Image> mouseImage = new Stack<>();
	Point mousePosition;
	
	
	public BoardPanel() {
		super.setLayout(null);
		//Create table elements
		//Draw table elements
		drawTable();
		//Deal cards to tableau piles
		dealCards();
		
		MouseListener listener = new MouseListener(this);
		addMouseListener(listener);
				
		MouseDragListener dragListener = new MouseDragListener(this);
		addMouseMotionListener(dragListener);
		
		mousePosition = new Point(0,0);
		
		PauseButton pauseButton = new PauseButton(840, 5);
		add(pauseButton);
		
		//UndoButton undoButton = new UndoButton(790, 5);
		//add(undoButton);
		
		score = new ScoreLabel(400, 2);
		add(score);
		
		klondike = false;
		
	}
	
	public void dealCards() {
		//deal Appropriate number of cards for each tableau
		for (int i = 0; i < tableauPiles.length; i++ ) {
			tableauPiles[i].dealCards(i + 1, deckPile.getDeck());
		}
	}
	
	public void drawTable() {
		//Create and draw deck panel to board
		//new deck panel
		deckPile = new DeckPile(30, 60);
		//populate deck of cards
		deckPile.getDeck().populate();
		//shuffle the deck
		deckPile.getDeck().shuffle();
		add(deckPile);
		//New waste pile
		wastePile = new WastePile(150, 60);
		add(wastePile);
		foundationPiles = new FoundationPile[4];
		for(int i = 0; i < foundationPiles.length; i++) {
			foundationPiles[i] = new FoundationPile(390 + 120 * i, 60, Deck.suits[i]);
			add(foundationPiles[i]);
		}
		tableauPiles = new TableauPile[7];
		for(int i = 0; i < tableauPiles.length; i++) {
			tableauPiles[i] = new TableauPile(30 + 120 * i, 250);
			add(tableauPiles[i]);	
			}
	}
	
	public void newGame() {
		//Remove current set
		remove(deckPile);
		remove(wastePile);
		for(int i = 0; i < foundationPiles.length; i++) {
			remove(foundationPiles[i]);
		}
		for(int i = 0; i < tableauPiles.length; i++) {
			remove(tableauPiles[i]);	
		}
		//Create new set
		drawTable();
		dealCards();
		
		score.resetScore();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Set color to dark green, adjust size to dimension parameters.
		g.setColor(new Color(0, 153, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	
	}
	//Drawn after components
	@Override
	public void paintChildren(Graphics g) {
		super.paintChildren(g);
		
		//Draw Mouse drag image if exists
		if (mouseImage != null) {
			int offset = 0;
			for(Image i : mouseImage) {
				g.drawImage(i, (int)mousePosition.getX() - 45, (int)mousePosition.getY() - 67 + offset, 90, 135, this);
				offset = offset + 20;
			}
		}
	}
	public void quickSaveState() {
		
	}
	
	public void quickLoadState() {
		
	}
	
	public Point getMousePosition() {
		return mousePosition;
	}
	public void setMousePosition(Point p) {
		mousePosition = p;
	}
	
	public void translateMousePosition(int x, int y) {
		mousePosition.translate(x, y);
	}
	
	public void addMouseImage(Image i) {
		mouseImage.push(i);
	}
	
	public void resetMouseImage() {
		mouseImage = new Stack<Image>();
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

	public void pauseMenu() {
		new PauseMenu(this);
	}
	
	public ScoreLabel getScore() {
		return score;
	}
	
	public boolean getGamemode() {
		return klondike;
	}
}
