package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class GameFrame extends JFrame {
	
	private GamePanel gamePanel;
	private WelcomePanel welcomePanel;
	
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		printWelcomePanel();
	}
	
	public void printPanel(JPanel panel) {
		getContentPane().removeAll();
		add(panel, BorderLayout.CENTER);
		repaint();
		revalidate();
		pack();
		setVisible(true);
	}
	
	public void newGameClicked() {
		printGamePanel();
	}
	
	private void printWelcomePanel() {
		if (welcomePanel == null)
			welcomePanel = new WelcomePanel(this);
		printPanel(welcomePanel);
	}
	
	private void printGamePanel() {
		if (gamePanel == null)
			gamePanel = new GamePanel(getContentPane().getBounds());
		printPanel(gamePanel);
		gamePanel.strayBullet();	// this is for testing
	}

}
