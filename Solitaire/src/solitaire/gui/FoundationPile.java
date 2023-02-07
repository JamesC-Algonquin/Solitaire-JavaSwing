package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import solitaire.cards.Deck;

public class FoundationPile extends CardPile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String suit;

	public FoundationPile(int x, int y, String s) {
		super(x, y);
		super.setSize(90, 135);
		suit = s;
		deck = new Deck();
	}
	
	public String getSuit() {
		return suit;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Draw 2d image to the panel
		g.setColor(new Color(0, 115, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		Image foundation =  new ImageIcon(FoundationPile.class.getResource("/solitaire/gui/cards/" + suit + ".png")).getImage();
		g.drawImage(foundation, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	

}
