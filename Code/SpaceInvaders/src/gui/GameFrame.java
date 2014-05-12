package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import elements.Controller;
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
		this.game=game;
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
		printGamePanel(game);
	}
	
	private void printWelcomePanel() {
		if (welcomePanel == null)
			welcomePanel = new WelcomePanel(this);
		printPanel(welcomePanel);
	}
	
	private void printGamePanel( Game game) {
		if (gamePanel == null)
			gamePanel = new GamePanel(getContentPane().getBounds(),game);
		printPanel(gamePanel);
		//gamePanel.strayBullet();	// this is for testing
	}
	
	public void refresh() {
		if(gamePanel!=null){
		gamePanel.refresh();}
	}

}
