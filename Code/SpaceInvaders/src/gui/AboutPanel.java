package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutPanel extends JPanel {
	
	private WelcomePanel welcomePanel;

	public AboutPanel(WelcomePanel welcomePanel) {
		this.welcomePanel = welcomePanel;
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon("Assets/about.jpg")));
	}
	
	public void backToMenuClicked() {
		welcomePanel.backToMenuClicked();
	}

}
