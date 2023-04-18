package solitaire.gui.menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import solitaire.gui.BoardPanel;

public class PauseMenu {
	
	private BoardPanel game;
	
	private final String[] buttons = {"Resume", "New Game", "Change Cards", "Exit"};
	
	private JDialog dialog;
	
	public PauseMenu(BoardPanel g) {
		
		game = g;
		
		JPanel pauseMenu = pauseMenuPanel();
		
		JOptionPane jop = new JOptionPane();
		dialog = jop.createDialog("Pause Menu");
		
		dialog.setSize(320, 360);
		dialog.setContentPane(pauseMenu);
		dialog.setLocationRelativeTo(game);
		dialog.setVisible(true);
	}
	
	private JPanel pauseMenuPanel() {
		JPanel pauseMenu = new JPanel();
		pauseMenu.setBounds(0, 0, 320, 360);
		pauseMenu.setBackground(new Color(0, 165, 80));
		pauseMenu.setLayout(null);
		
		int offset = 0;
		for(String type : buttons) {
			JButton button = new JButton(type);
			button.setSize(120, 40);
			button.setLocation(100, 30 + offset);
			button.addActionListener(new ButtonListener());
			pauseMenu.add(button);
			offset += 70;
		}
				
		return pauseMenu;
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton selected = (JButton) e.getSource();
			String type = selected.getText();
			
			if(type == buttons[0]) {
				dialog.dispose();
			}
			else if (type == buttons[1]) {
				game.newGameMenu();
				dialog.dispose();
			}
			else if (type == buttons[2]) {
				new CardSelect(game);
				dialog.dispose();
			}
			else if (type == buttons[3]) {
				System.exit(0);
			}
		}
		
	}

}
