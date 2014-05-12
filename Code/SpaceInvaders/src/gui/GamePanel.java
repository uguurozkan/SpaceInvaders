package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import elements.Game;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private final int WIDTH = 900;
	private final int HEIGHT = 550;

	private StatusPanel statusPanel;
	private PlayerView playerView;
	Game game;

	public GamePanel(Rectangle frameBounds,Game game) {
		setLayout(null);
		setBounds(frameBounds);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		this.game=game;
	}
	
	
	public void strayBullet() {
		Bullet strayBullet = new Bullet(getWidth() / 2, getHeight() - 5, Bullet.UP);
		add(strayBullet);
		new Thread(strayBullet).start();
	}
	
	public void refresh() {
		//TODO Queries the game for the positions of entities and updates the screen.
		//draw enemies;
		repaint();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		this.removeAll();
		game.draw(g);
		
	}

}
