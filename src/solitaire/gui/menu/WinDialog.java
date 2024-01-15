package solitaire.gui.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import solitaire.gui.BoardPanel;

public class WinDialog {
	
	private final String[] buttons = {"New Game", "Exit"};
	private JDialog dialog;
	private BoardPanel game;
	
	public WinDialog(BoardPanel g, String mode, int score) {
		game = g;
		JPanel pauseMenu = WinPanel(mode, score);
		
		JOptionPane jop = new JOptionPane();
		dialog = jop.createDialog("You Win!");
		
		dialog.setSize(315, 200);
		dialog.setContentPane(pauseMenu);
		dialog.setLocationRelativeTo(game);
		dialog.setVisible(true);
	}
	
	public JPanel WinPanel(String mode, int score) {
		JPanel win = new JPanel();
		win.setBounds(0, 0, 315, 200);
		win.setBackground(new Color(0, 185, 120));
		win.setLayout(null);
		
		JLabel message = new JLabel("Congratulations!");
		message.setSize(250, 30);
		message.setLocation(15, 15);
		message.setFont(new Font("SansSerif", Font.BOLD, 18));
		win.add(message);
		
		JLabel modeLabel = new JLabel("Gamemode: " + mode);
		modeLabel.setSize(250, 30);
		modeLabel.setLocation(15, 50);
		modeLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		win.add(modeLabel);
		
		JLabel scoreLabel = new JLabel("Score: " + Integer.toString(score));
		scoreLabel.setSize(250, 30);
		scoreLabel.setLocation(15, 75);
		scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		win.add(scoreLabel);
		
		int offset = 0;
		for(String type : buttons) {
			JButton button = new JButton(type);
			button.setSize(120, 40);
			button.setLocation(15 + offset, 120 );
			button.addActionListener(new ButtonListener());
			win.add(button);
			offset += 150;
		}
		
		return win;
	}
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton selected = (JButton) e.getSource();
			String type = selected.getText();
			
			if(type == buttons[0]) {
				game.newGameMenu();
				dialog.dispose();
			}
			else if (type == buttons[1]) {
				System.exit(0);
			}
		}
		
	}

}
