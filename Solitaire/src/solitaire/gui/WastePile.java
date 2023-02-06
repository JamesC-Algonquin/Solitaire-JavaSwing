package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;

public class WastePile extends CardPile{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WastePile(int x, int y) {
		super(x, y);
		super.setSize(90, 135);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		//Draw 2d image to the panel
		g.setColor(new Color(0, 115, 0));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	}

}
