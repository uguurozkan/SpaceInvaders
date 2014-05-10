package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elements.Player;

@SuppressWarnings("serial")
public class PlayerView extends JLabel {

	private final String SHIP_IMAGE_PATH = "Assets/ship.jpg"; 

	private Player player;

	public PlayerView(Player player) {
		this.player = player;
		setIcon(getShipImage());
		repaint();
	}

	private ImageIcon getShipImage() {
		Image ship = new ImageIcon(SHIP_IMAGE_PATH).getImage();
		ship = ship.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		return new ImageIcon(ship);
	}

}