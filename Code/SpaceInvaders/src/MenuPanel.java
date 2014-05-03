import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class MenuPanel extends JFrame{
	public MenuPanel()  {
		drawMenuScreen();
	}

	private static  JPanel openningPicturePanel;
	private static JPanel aboutPanel;
	private static JPanel howtoPanel;
	private static JLabel openingPictureLabel;
	private static JLabel openingLogoLabel;
	private static JLabel aboutLabel;

	

	private  void drawMenuScreen() {
		openningPicturePanel = new JPanel();
		openningPicturePanel.setLayout(null);

		aboutPanel = new JPanel();
		aboutPanel.setLayout(null);
		aboutLabel = (new JLabel(new ImageIcon("Assets/about.png")));

		openingPictureLabel = new JLabel(new ImageIcon(
				"Assets/Invader_Menu.jpg"));


		JButton newButton = new JButton("New Game");
		newButton.setSize(120, 25);
		newButton.setLocation(400, 250);
		newButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("game started");
			}
		});
		openningPicturePanel.add(newButton);

		JButton howtoButton = new JButton("How to Play");
		howtoButton.setSize(120, 25);
		howtoButton.setLocation(400, 300);
		openningPicturePanel.add(howtoButton);
		howtoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("how to opened");
			}
		});
		
		JButton backButton = new JButton("Back");
		// backButton.setBorder(new EmptyBorder(1,1,1,1));
		backButton.setSize(120, 25);
		backButton.setLocation(736, 289);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				aboutPanel.setVisible(false);
				openningPicturePanel.setVisible(true);
				repaint();
			}
		});
		backButton.setLocation(10, 10);
		aboutPanel.add(backButton);


		JButton aboutButton = new JButton("About");
		aboutButton.setSize(120, 25);
		aboutButton.setLocation(400, 350);
		aboutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				openningPicturePanel.setVisible(false);
				add(aboutPanel);
				aboutPanel.setVisible(true);
				repaint();
			}
		});
		openningPicturePanel.add(aboutButton);

		// Exit
		JButton exitButton = new JButton("Exit");
		exitButton.setSize(120, 25);
		exitButton.setLocation(400,400 );
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		openningPicturePanel.add(exitButton);

		aboutLabel.setLocation(0, 0);
		aboutLabel.setSize(900, 550);
		aboutPanel.add(aboutLabel);
		aboutPanel.setLayout(null);
		aboutPanel.setSize(900, 550);
		openingPictureLabel.setSize(900, 550);
		openingPictureLabel.setLocation(0, 0);
		openningPicturePanel.add(openingPictureLabel);
		add(openningPicturePanel); // Add panel to frame
		setSize(900, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

}
