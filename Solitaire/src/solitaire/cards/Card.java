package solitaire.cards;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Card {
	
	private int value;
	private String suit;
	private int colour;
	private Image face;
	private boolean faceUp;
	private static Image back;
	
	public Card(int v, String s, int c) {
		value = v;
		suit = s;
		faceUp = false;
		colour = c;
	}
	
	public boolean isFaceUp() {
		return faceUp;
	}
	
	public void flip() {
		faceUp = !faceUp;
	}

	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}
	public int getColour() {
		return colour;
	}
	
	//Default background image for cards
	public static Image getBackground() {
		if (back==null) {
			back = new ImageIcon(Card.class.getResource("/solitaire/gui/cards/backcloud.png")).getImage();
		}
		return back;
	}
	
	public Image getFace() {
		if (face == null) {
			face = new ImageIcon(Card.class.getResource("/solitaire/gui/cards/" + suit + value + ".png")).getImage();
		}
		return face;
	}
	

}
