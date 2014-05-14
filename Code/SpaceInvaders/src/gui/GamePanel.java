package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;

import elements.Alien;
import elements.Barrier;
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
	ArrayList<EntityView> entityView;
	ArrayList<Bullet> bullets;

	public GamePanel(Level level) {
		setLayout(null);
		setSize(WIDTH,HEIGHT);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		this.level = level;
		this.entityView = new ArrayList<EntityView>();
		bullets = new ArrayList<Bullet>();
	}

	public void fireBullet(int xPos, int yPos) {
		Bullet strayBullet = new Bullet(xPos, yPos, Bullet.UP);
		bullets.add(strayBullet);
//		entityView.add(strayBullet); TODO Bullet has to be turned into an EntityView
		add(strayBullet);
//		new Timer().schedule(strayBullet.getAnimation(), 0, 10);
	}



	public void paintBarriers() {
		for (Barrier barrier : level.getBarriers()) {
			BarrierView barrierView = new BarrierView(barrier);
			entityView.add(barrierView);
			add(barrierView);
		}
	}

	public void paintAliens() {
		for (Alien alien : level.getAliens()) {
			AlienView alienView = new AlienView(alien);
			entityView.add(alienView);
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

}
