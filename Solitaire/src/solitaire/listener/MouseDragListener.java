package solitaire.listener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import solitaire.gui.BoardPanel;

public class MouseDragListener extends MouseMotionAdapter {
	
	BoardPanel game;
	
	public MouseDragListener(BoardPanel g) {
		game = g;
	}
	
	public void mouseDragged(MouseEvent e) {
		Point cur = e.getPoint();
		game.translateMousePosition((int) (cur.getX() - game.getMousePosition().getX()), (int) (cur.getY() - game.getMousePosition().getY()));
		game.repaint();
		
	}

}
