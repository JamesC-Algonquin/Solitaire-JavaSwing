package solitaire.gui;

import java.awt.Color;
import java.awt.Graphics;

public class TableauPile extends CardPile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableauPile(int x, int y) {
		super(x, y);
		super.setSize(90, 400);
		super.setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.drawLine(0, 0, this.getWidth()-1, 0);
		g.drawLine(0, 135, this.getWidth()-1, 135);
		g.drawLine(0, 0, 0, 135);
		g.drawLine(this.getWidth()-1, 0, this.getWidth()-1, 135);
	}

}
