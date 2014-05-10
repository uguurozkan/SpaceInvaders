package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class GameFrame extends JFrame {
	
	private final int WIDTH = 900;
	private final int HEIGHT = 550;
	
	private MenuPanel menuPanel;
	private AboutPanel aboutPanel;
	private HowToPanel howToPanel;
	
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
	}
	
	public void printPanel(JPanel panel) {
		getContentPane().removeAll();
		add(panel, BorderLayout.CENTER);
		repaint();
		revalidate();
		setVisible(true);
	}
	
	public void printAboutPanel() {
		if (aboutPanel == null)
			aboutPanel = new AboutPanel();
		printPanel(aboutPanel);
	}
	
	public void printHowToPanel() {
		if (howToPanel == null)
			howToPanel = new HowToPanel();
		printPanel(howToPanel);
	}
	
	public void printMenuPanel() {
		if (menuPanel == null)
			menuPanel = new MenuPanel();
		printPanel(menuPanel);
	}

}
