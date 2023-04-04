package solitaire.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class UndoButton extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UndoButton(int x, int y) {
		super.setLocation(x,y);
		super.setSize(45, 45);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Image undoButton = new ImageIcon(PauseButton.class.getResource("/solitaire/gui/cards/undo.png")).getImage();
		
		g.drawImage(undoButton, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
