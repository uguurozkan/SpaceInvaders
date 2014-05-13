package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elements.Alien;

public class AlienView extends JLabel {
	Alien alien;
	String path = "Assets/Invaders/Invader1.png";

	public AlienView(Alien alien) {
		this.alien = alien;
	}
	
	public void refresh() {
		setImage(alien.getImagePath());
		setLocation(alien.getLocation());
		setSize(32,16);
	}
	
	public void setImage(String imagePath) {
		setIcon(new ImageIcon(imagePath));
	}	

}
