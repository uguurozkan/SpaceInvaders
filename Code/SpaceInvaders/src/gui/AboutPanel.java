package gui;

import javax.swing.JPanel;

public class AboutPanel extends JPanel {
	
	private WelcomePanel welcomePanel;

	public AboutPanel(WelcomePanel welcomePanel) {
		this.welcomePanel = welcomePanel;
	}
	
	public void backToMenuClicked() {
		welcomePanel.backToMenuClicked();
	}

}
