package solitaire.gui.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import solitaire.cards.Card;
import solitaire.gui.BoardPanel;


public class CardSelect {
	
	private String[] images = {"cloud", "horse", "dolphin", "lizard", "orca", "puffin"};
	private String resource = "/solitaire/gui/cards/";
	private String ext = ".png";
	
	private JDialog dialog;
	private BoardPanel game;
	
	public CardSelect(BoardPanel g) {
		
		game = g;
		
		JPanel cardMenu = cardMenuPanel();
		
		JOptionPane jop = new JOptionPane();
		dialog = jop.createDialog("Pause Menu");
		
		dialog.setSize(360, 400);
		dialog.setContentPane(cardMenu);
		dialog.setLocationRelativeTo(game);
		dialog.setVisible(true);
	}
	
	private JPanel cardMenuPanel() {
		JPanel cardMenu = new JPanel();
		cardMenu.setBounds(0, 0, 360, 400);
		cardMenu.setBackground(new Color(0, 165, 80));
		cardMenu.setLayout(null);
		cardMenu.addMouseListener(new CardListener());
		
		int xOffset = 0;
		int yOffset = 0;
		for (String name: images) {
			String path = resource + name + ext;
			CardBack image = new CardBack(30 + xOffset, 30 + yOffset, path);
			cardMenu.add(image);
			xOffset += 100;
			if (xOffset % 300 == 0) {
				yOffset += 160;
				xOffset = 0;
			}
		}
		
				
		return cardMenu;
	}
	
	class CardListener extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent e) {
			Component pressed = e.getComponent().getComponentAt(e.getPoint());
			if (pressed instanceof CardBack) {
				CardBack selected = (CardBack) pressed;
				Card.setImageSource(selected.getResource());
				game.repaint();
				dialog.dispose();
			}
		}
		
	}
	
}
