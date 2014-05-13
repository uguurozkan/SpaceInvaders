package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elements.Player;

@SuppressWarnings("serial")
public class PlayerView extends JPanel {

	private final String SHIP_IMAGE_PATH = "Assets/ship1.png"; 

	private Player player;

	public PlayerView(Player player) {
		setLocation(100, 500);
		setFocusable(true);
		this.player = player;
		setBackground(Color.black);
		setSize(28,14);
		add(new JLabel(new ImageIcon(SHIP_IMAGE_PATH)));
		repaint();
	}

	private ImageIcon getShipImage() {
		Image ship = new ImageIcon(SHIP_IMAGE_PATH).getImage();
		ship = ship.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		return new ImageIcon(ship);
	}

	public void refresh() {
		setLocation(player.getLocation());
		setSize(28,14);
		
	}

}