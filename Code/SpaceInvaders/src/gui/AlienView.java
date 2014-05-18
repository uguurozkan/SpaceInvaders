package gui;

import javax.swing.ImageIcon;

import elements.Alien;

public class AlienView extends EntityView {
	//String path = "Assets/Invaders/Invader1.png";
	ImageIcon icon = new ImageIcon("Assets/Invaders/invaderGif.gif");

	public AlienView(Alien alien) {
		super(alien);
		setIcon(icon);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}
