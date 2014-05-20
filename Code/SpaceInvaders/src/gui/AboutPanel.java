package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elements.BackButtonHandler;

public class AboutPanel extends JPanel {

	private GameFrame gameFrame;

	public AboutPanel(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon("Assets/about.jpg")), BorderLayout.CENTER);
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new BackButtonHandler(gameFrame));
		add(backButton, BorderLayout.NORTH);
	}

}
