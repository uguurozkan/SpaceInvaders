package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WelcomePanel extends JPanel {
	
	private final int WIDTH = 900;
	private final int HEIGHT = 550;
	
	private GameFrame gameFrame;
	private MenuPanel menuPanel;
	private AboutPanel aboutPanel;
	private HowToPanel howToPanel;
	
	public WelcomePanel(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		printMenuPanel();
	}
	
	private void printMenuPanel() {
		if (menuPanel == null)
			menuPanel = new MenuPanel(this);
		printPanel(menuPanel);
	}

	private void printPanel(JPanel panel) {
		removeAll();
		add(panel, BorderLayout.CENTER);
		repaint();
		revalidate();
	}

	public void newGameClicked() {
		gameFrame.newGameClicked();
	}
	
	public void aboutClicked() {
		printAboutPanel();
	}
	
	public void howToClicked() {
		printHowToPanel();
	}

	private void printHowToPanel() {
		if (howToPanel == null)
			howToPanel = new HowToPanel(this);
		printPanel(howToPanel);
	}

	private void printAboutPanel() {
		if (aboutPanel == null)
			aboutPanel = new AboutPanel(this);
		printPanel(aboutPanel);
	}

	public void backToMenuClicked() {
		printMenuPanel();
	}

}
