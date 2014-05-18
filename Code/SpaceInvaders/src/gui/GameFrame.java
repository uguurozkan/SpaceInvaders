package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import elements.Player;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	private GamePanel gamePanel;
	private InfoPanel infoPanel;
	private WelcomePanel welcomePanel;

	public static void main(String[] args) {
		new GameFrame();
	}
	
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
		validate();
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
			gamePanel = new GamePanel();
		printPanel(gamePanel);
		gamePanel.paintAliens();
		gamePanel.paintBarriers();
		gamePanel.paintPlayer(createPlayer());
		run();
		// gamePanel.fireBullet(getWidth() / 2, getHeight() - 5); // this is for
		// testing
	}
	
	private Player createPlayer() {
		return new Player(30, 14);
	}

	public void run() {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gamePanel.run();
			}
		};
		new javax.swing.Timer(5, listener).start();

	}

}
