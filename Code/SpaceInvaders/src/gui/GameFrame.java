package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class GameFrame extends JFrame {
	
	private final int WIDTH = 900;
	private final int HEIGHT = 550;
	
	private GamePanel gamePanel;
	private WelcomePanel welcomePanel;
	
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		printWelcomePanel();
	}
	
	public void printPanel(JPanel panel) {
		getContentPane().removeAll();
		add(panel, BorderLayout.CENTER);
		repaint();
		revalidate();
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
			gamePanel = new GamePanel();
		printPanel(gamePanel);
	}

}
