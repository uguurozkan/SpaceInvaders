package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elements.PlayerEntity;

@SuppressWarnings("serial")
public class PlayerView extends GameWindow {

	private final String SHIP_IMAGE_PATH = ""; // TODO find ship image

	private PlayerEntity player;

	public PlayerView(PlayerEntity player) {
		this.player = player;
		JLabel shipLabel = new JLabel(getShipImage());
		add(shipLabel);
		repaint();
	}

	private ImageIcon getShipImage() {
		Image ship = new ImageIcon(SHIP_IMAGE_PATH).getImage();
		ship = ship.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		return new ImageIcon(ship);
	}

}