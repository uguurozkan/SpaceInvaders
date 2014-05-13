package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import elements.Game;

public class GameFrame extends JFrame {

	private GamePanel gamePanel;
	private WelcomePanel welcomePanel;
	Game game;

	public GameFrame(Game game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		printWelcomePanel();
		this.game = game;
	}

	public void printPanel(JPanel panel) {
		getContentPane().removeAll();
		add(panel, BorderLayout.CENTER);
		repaint();
		validate();
		pack();
		setVisible(true);
	}

	public void newGameClicked() {
		printGamePanel(game);
	}

	private void printWelcomePanel() {
		if (welcomePanel == null)
			welcomePanel = new WelcomePanel(this);
		printPanel(welcomePanel);
	}

	private void printGamePanel(Game game) {
		if (gamePanel == null)
			gamePanel = new GamePanel(getContentPane().getBounds(), game);
		printPanel(gamePanel);
		gamePanel.paintAliens();
		gamePanel.paintBarriers();
		gamePanel.paintPlayer();
//		gamePanel.fireBullet(getWidth() / 2, getHeight() - 5); // this is for testing
	}

	public void refresh() {
		if (gamePanel != null) {
			gamePanel.refresh();
		}
	}

}
