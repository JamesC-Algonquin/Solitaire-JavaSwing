package solitaire.gui.menu;

import javax.swing.JOptionPane;

import solitaire.gui.BoardPanel;

public class NewGameMenu extends JOptionPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Object[] options = {"Klondike", "Normal"};
	
	public NewGameMenu(BoardPanel g) {
		
		int result = showOptionDialog(g, "", "New Game?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
		if (result == JOptionPane.NO_OPTION) {
			g.newGame(false);
			g.repaint();
		}
		else if (result == JOptionPane.YES_OPTION) {
			g.newGame(true);
			g.repaint();
		}
	}

}
