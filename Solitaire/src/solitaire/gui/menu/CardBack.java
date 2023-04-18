package solitaire.gui.menu;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import solitaire.cards.Card;

public class CardBack extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resource;
	
	public CardBack(int x, int y, String r) {
		super.setLocation(x, y);
		super.setSize(90, 135);
		resource = r;
	}
	
	public String getResource() {
		return resource;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon(Card.class.getResource(resource)).getImage();
		g.drawImage(image, 0, 0, 90, 135, this);
	}

}
