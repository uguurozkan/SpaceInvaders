package gui;
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



public class MenuPanel extends JPanel {
//	JPanel openningPicturePanel;
	JLabel openingPictureLabel;


	public MenuPanel()  {

	}

	public MenuPanel getMenuPanel() {
//		openningPicturePanel = new JPanel();
		/*openningPicturePanel.*/setLayout(null);
		openingPictureLabel = new JLabel(new ImageIcon(
				"Assets/Invader_Menu.jpg"));
		addButtons();
		openingPictureLabel.setSize(900, 550);
		openingPictureLabel.setLocation(0, 0);
		/*openningPicturePanel.*/add(openingPictureLabel);
		return /*openningPicturePanel*/this;
	}

	private void addButtons() {
		JButton newButton = makeButton("New Game", 400, 250);
		newButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("game started");
			}
		});
		
		/*openningPicturePanel.*/add(newButton);

		JButton howtoButton =makeButton("How to Play",400,300);
		/*openningPicturePanel.*/add(howtoButton);
		howtoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("how to opened");
			}
		});

		JButton aboutButton = makeButton("About",400,350);
		aboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("about Clicked");
			}
		});
		/*openningPicturePanel.*/add(aboutButton);

		// Exit
		JButton exitButton =makeButton("Exit",400,400);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		/*openningPicturePanel.*/add(exitButton);
	}
	private JButton makeButton(String label,int x, int y){
		 JButton button=new JButton(label);
			button.setSize(120, 25);
			button.setLocation(x,y);
			return button;
	}

}
