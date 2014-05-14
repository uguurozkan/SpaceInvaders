package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elements.Player;

@SuppressWarnings("serial")
public class PlayerView extends EntityView {


	public PlayerView(Player player) {
		super(player);
		setLocation(320, 608);
		setFocusable(true);

	}
	

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}