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
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(new BorderLayout());
	}
	
	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}
	
	public void setAboutPanel(AboutPanel aboutPanel) {
		this.aboutPanel = aboutPanel;
	}
	
	public void setHowToPanel(HowToPanel howToPanel) {
		this.howToPanel = howToPanel;
	}
	
	public void printPanel(JPanel panel) {
		removeAll();
		add(panel, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	public void printAboutPanel() {
		if (aboutPanel != null)
			printPanel(aboutPanel);
		else
			throw new NullPointerException("AboutPanel is null!");
	}
	
	public void printHowToPanel() {
		if (howToPanel != null)
			printPanel(howToPanel);
		else
			throw new NullPointerException("HowToPanel is null!");
	}
	
	public void printMenuPanel() {
		if (menuPanel != null)
			printPanel(menuPanel);
		else
			throw new NullPointerException("MenuPanel is null!");
	}

}
