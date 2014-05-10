package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {

	private JLabel openingPictureLabel;
	private WelcomePanel welcomePanel;

	public MenuPanel(WelcomePanel welcomePanel) {
		this.welcomePanel = welcomePanel;
		setLayout(null);
		openingPictureLabel = new JLabel(new ImageIcon(
				"Assets/Invader_Menu.jpg"));
		addButtons();
		openingPictureLabel.setSize(900, 550);
		openingPictureLabel.setLocation(0, 0);
		add(openingPictureLabel);
	}

	private void addButtons() {
		addNewButton();
		addHowToButton();
		addAboutButton();
		addExitButton();
	}

	private void addNewButton() {
		JButton newButton = makeButton("New Game", 400, 250);
		newButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				welcomePanel.newGameClicked();
			}
		});
		add(newButton);
	}

	private void addHowToButton() {
		JButton howtoButton = makeButton("How to Play", 400, 300);
		howtoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				welcomePanel.howToClicked();
			}
		});
		add(howtoButton);
	}

	private void addAboutButton() {
		JButton aboutButton = makeButton("About", 400, 350);
		aboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("about Clicked");
				welcomePanel.aboutClicked();
			}
		});
		add(aboutButton);
	}

	private void addExitButton() {
		JButton exitButton = makeButton("Exit", 400, 400);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		add(exitButton);
	}

	private JButton makeButton(String label, int x, int y) {
		JButton button = new JButton(label);
		button.setSize(120, 25);
		button.setLocation(x, y);
		return button;
	}

}
