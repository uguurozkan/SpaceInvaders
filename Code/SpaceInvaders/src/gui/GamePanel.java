package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import elements.Alien;
import elements.Barrier;
import elements.Entity;
import elements.KeyInputHandler;
import elements.Level;
import elements.Player;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	public static final int WIDTH = 640;
	public static int HEIGHT = 640;

	private StatusPanel statusPanel;
	private PlayerView playerView;
	private Level level;
	CopyOnWriteArrayList<EntityView> entityViews;
	CopyOnWriteArrayList<Bullet> bullets;

	public GamePanel(Level level) {
		setLayout(null);
		setSize(WIDTH, HEIGHT);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		this.level = level;
		this.entityViews = new CopyOnWriteArrayList<EntityView>();
		bullets = new CopyOnWriteArrayList<Bullet>();
	}

	public void fireBullet(int xPos, int yPos) {
		Bullet strayBullet = new Bullet(xPos, yPos, Bullet.UP);
		bullets.add(strayBullet);
		add(strayBullet);
	}

	public void paintBarriers() {
		for (Barrier barrier : level.getBarriers()) {
			BarrierView barrierView = new BarrierView(barrier);
			entityViews.add(barrierView);
			add(barrierView);
		}
	}

	public void paintAliens() {
		for (Alien alien : level.getAliens()) {
			AlienView alienView = new AlienView(alien);
			entityViews.add(alienView);
			add(alienView);
		}

	}

	public void paintPlayer(Player player) {
		if (playerView == null)
			playerView = new PlayerView(player);
		add(playerView);
		playerView.requestFocus();
		playerView.requestFocusInWindow();
		playerView.addKeyListener(new KeyInputHandler(playerView, this));
	}

	public void run() {
		for (Bullet bullet : bullets) {
			for (EntityView entityView : entityViews) {
				try {
					if (entityView.collide(bullet.getLocation())) {
						entityViews.remove(entityView);
						removeBullet(bullet);
					}
				} catch (Exception e) {
					continue;
				}

			}
			try {
				if (bullet.isInsidePanel())
					bullet.move();
				else {
					removeBullet(bullet);
				}
			} catch (Exception e) {
				continue;
			}

		}
	}

	private void removeBullet(Bullet bullet) {
		remove(bullet);
		bullets.remove(bullet);
		repaint();
		revalidate();
	}

}
