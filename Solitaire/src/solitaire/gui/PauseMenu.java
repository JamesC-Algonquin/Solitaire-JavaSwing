package solitaire.gui;

import javax.swing.JOptionPane;

public class PauseMenu extends JOptionPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Object[] options = {"Resume", "New Game"};
	
	public PauseMenu(BoardPanel g) {
		
		int result = showOptionDialog(g, "", "Paused", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
		if (result == JOptionPane.NO_OPTION) {
			g.newGame();
			g.repaint();
		}
	}

}
