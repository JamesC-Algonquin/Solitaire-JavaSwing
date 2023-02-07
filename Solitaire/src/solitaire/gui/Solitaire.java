package solitaire.gui;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Solitaire extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Hard-coded initial resolution.
	public static final int WIDTH = 900, HEIGHT = 750;
	
	//Window background/game board for cards
	private BoardPanel gameBoard;
	
	
	//default constructor. 
	public Solitaire() {
		
		//Default close operation ends program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		
		//Create new board to fill window, set size
		gameBoard = new BoardPanel();
		gameBoard.setSize(new Dimension(WIDTH, HEIGHT));
				
		//Add to window
		add(gameBoard);
		
		//Adjusts window size to fit contents
		pack();
	}
	
	//Program launcher
	public static void main(String[] args) {
		
		//Creates new Window for game
		Solitaire window = new Solitaire();
		
		//Set title on window, make visible.
		window.setTitle("Solitaire");
		window.setVisible(true);
		

	}

}
