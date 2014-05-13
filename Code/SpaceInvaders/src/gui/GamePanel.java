package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import elements.Alien;
import elements.Game;
import elements.Level;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private final int WIDTH = 900;
	private final int HEIGHT = 550;

	private StatusPanel statusPanel;
	private PlayerView playerView;
	Game game;
	ArrayList<AlienView> alienViews;

	public GamePanel(Rectangle frameBounds,Game game) {
		setLayout(null);
		setBounds(frameBounds);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		this.game=game;
		this.alienViews = new ArrayList<AlienView>();
	}
	
	
	public void strayBullet() {
		Bullet strayBullet = new Bullet(getWidth() / 2, getHeight() - 5, Bullet.UP);
		add(strayBullet);
		new Thread(strayBullet).start();
	}
	
	public void refresh() {
		for (AlienView alienView : alienViews) {
			alienView.refresh();
		}
		repaint();
	}
	
	public void paintAliens() {
		Level level = game.getLevel();
		ArrayList<Alien> aliens = level.getAliens();
		alienViews = new ArrayList<AlienView>();
		
		for (Alien alien : aliens) {
			AlienView alienView = new AlienView(alien); 
			alienViews.add(alienView);
			add(alienView);
		}
		
	}

}
