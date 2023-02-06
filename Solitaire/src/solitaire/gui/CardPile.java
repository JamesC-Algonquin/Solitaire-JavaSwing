package solitaire.gui;

import javax.swing.JPanel;

public abstract class CardPile extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int x, y;
	
	public CardPile(int x, int y) {
		super.setLocation(x, y);
	}

}
