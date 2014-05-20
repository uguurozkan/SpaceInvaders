package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elements.BackButtonHandler;

public class HowToPanel extends JPanel {

	private GameFrame gameFrame;

	public HowToPanel(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon("Assets/howToPlay.png")), BorderLayout.CENTER);
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new BackButtonHandler(gameFrame));
		add(backButton, BorderLayout.NORTH);
	}

}
