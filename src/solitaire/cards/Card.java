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
	private static String imageSource;
	
	public Card(int v, String s, int c) {
		value = v;
		suit = s;
		faceUp = false;
		colour = c;
		imageSource = "/solitaire/gui/cards/cloud.png";
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
	
	public static void setImageSource(String source) {
		imageSource = source; 
		back = new ImageIcon(Card.class.getResource(imageSource)).getImage();
	}
	
	//Default background image for cards
	public static Image getBackground() {
		if (back==null) {
			back = new ImageIcon(Card.class.getResource(imageSource)).getImage();
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
