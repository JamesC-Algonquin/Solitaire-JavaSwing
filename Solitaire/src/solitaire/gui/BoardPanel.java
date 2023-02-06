package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Panel for deck of cards image
	private static DeckPanel deckPanel;
	
	
	public BoardPanel() {
		super.setLayout(null);
		
		//Create and draw deck panel to board
		deckPanel = new DeckPanel(30, 30);
		add(deckPanel);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Set color to dark green, adjust size to dimension parameters.
		g.setColor(new Color(0, 153, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

}
