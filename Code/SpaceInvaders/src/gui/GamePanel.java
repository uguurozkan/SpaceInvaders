package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JPanel;

import elements.Alien;
import elements.Game;
import elements.KeyInputHandler;
import elements.Level;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private final int WIDTH = 900;
	private final int HEIGHT = 550;

	private StatusPanel statusPanel;
	private PlayerView playerView;
	Game game;
	ArrayList<AlienView> alienViews;

	public GamePanel(Rectangle frameBounds, Game game) {
		setLayout(null);
		setBounds(frameBounds);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		this.game = game;
		this.alienViews = new ArrayList<AlienView>();
	}

	public void fireBullet(int xPos, int yPos) {
		Bullet strayBullet = new Bullet(xPos, yPos, Bullet.UP);
		add(strayBullet);
		new Timer().schedule(strayBullet.getAnimation(), 0, 10);
	}

	public void refresh() {
		for (AlienView alienView : alienViews) {
			alienView.refresh();
		}
		repaint();
	}

	public void paintBarriers() {
		add(new Barrier(100, 400));
		add(new Barrier(150, 400));
		add(new Barrier(200, 400));
		add(new Barrier(50, 400));
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

	public void paintPlayer() {
		if (playerView == null)
			playerView = new PlayerView(game.player);
		add(playerView);
		playerView.requestFocus();
		playerView.requestFocusInWindow();
		playerView.addKeyListener(new KeyInputHandler(playerView, this));
	}

}
