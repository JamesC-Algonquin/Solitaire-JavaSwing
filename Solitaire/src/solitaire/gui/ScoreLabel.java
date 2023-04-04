package solitaire.gui;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class ScoreLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int score = 0;
	
	public ScoreLabel(int x, int y) {
		super.setLocation(x,y);
		super.setSize(450, 45);
		this.setFont(new Font("SansSerif", Font.BOLD, 18));
		setText();
	}
	
	public void incrementScore(int num) {
		score += num;
		if (score < 0) {
			score = 0;
		}
		setText();
	}
	
	public void resetScore() {
		score = 0;
		setText();
	}
	
	public void setText() {
		super.setText("Score: " + Integer.toString(score));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
