package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import elements.Controller;
import elements.Level;

public class GameFrame extends JFrame {

	private GamePanel gamePanel;
	private WelcomePanel welcomePanel;
	private Controller controller;

	public GameFrame(Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		printWelcomePanel();
		this.controller = controller;
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
		printGamePanel(controller.getLevel());
		
	}

	private void printWelcomePanel() {
		if (welcomePanel == null)
			welcomePanel = new WelcomePanel(this);
		printPanel(welcomePanel);
	}

	private void printGamePanel(Level level) {
		if (gamePanel == null)
			gamePanel = new GamePanel(level);
		printPanel(gamePanel);
		gamePanel.paintAliens();
		gamePanel.paintBarriers();
		gamePanel.paintPlayer(controller.getPlayer());
		run();
		//		gamePanel.fireBullet(getWidth() / 2, getHeight() - 5); // this is for testing
	}

	public void run() {
		ActionListener a = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gamePanel.run();
				
			}
		};
		new javax.swing.Timer(5, a).start();

	}

}
