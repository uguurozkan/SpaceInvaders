package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import elements.Alien;
import elements.Barrier;
import elements.KeyInputHandler;
import elements.Level;
import elements.LevelLoader;
import elements.Player;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	public static final int WIDTH = 640;
	public static int HEIGHT = 640;

	private PlayerView playerView;
	private Level level;
	private boolean running = true;
	CopyOnWriteArrayList<EntityView> entityViews;
	CopyOnWriteArrayList<Bullet> bullets;
	private GameFrame gameFrame;
	private int remainingAliens;

	public GamePanel(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		setLayout(null);
		setSize(WIDTH, HEIGHT);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		setBorder(new LineBorder(Color.white));
		level = LevelLoader.getInstance().loadNextLevel();
		this.entityViews = new CopyOnWriteArrayList<EntityView>();
		bullets = new CopyOnWriteArrayList<Bullet>();
	}

	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
		try {
			add(bullet);
		} catch (Exception e) {
			bullets.remove(bullet);
		}
	}

	public void paintBarriers() {
		for (Barrier barrier : level.getBarriers()) {
			BarrierView barrierView = new BarrierView(barrier, this);
			entityViews.add(barrierView);
			add(barrierView);
		}
	}

	public void paintAliens() {
		for (Alien alien : level.getAliens()) {
			AlienView alienView = new AlienView(alien, this);
			entityViews.add(alienView);
			add(alienView);
			remainingAliens++;
		}
	}

	public void paintPlayer(Player player) {
		if (playerView == null)
			playerView = new PlayerView(player, this);
		add(playerView);
		playerView.requestFocus();
		playerView.requestFocusInWindow();
		playerView.addKeyListener(new KeyInputHandler(playerView));
	}

	public void run() {
		moveEntities();
		moveBullets();
	}

	private void moveEntities() {
		for (EntityView entityView : entityViews) {
			entityView.move();
			entityView.fire();
		}
		playerView.move();
	}

	private void moveBullets() {
		for (Bullet bullet : bullets) {
			if (bullet.getType() == BulletType.PlayerBullet) {
				alienGetHit(bullet);
			} else if (bullet.getType() == BulletType.AlienBullet) {
				playerGetHit(bullet);
			} else {
				System.err.println("Another bullet type ???");
			}

			if (bullet.isInsidePanel())
				bullet.move();
			else {
				removeBullet(bullet);
			}
		}
	}

	private void alienGetHit(Bullet bullet) {
		for (EntityView entityView : entityViews) {
			if (entityView.intersects(bullet.getBounds())) {
				entityView.getHit();
				removeBullet(bullet);
				gameFrame.scoreUp();
				if (entityView instanceof AlienView) {
					remainingAliens--;
					if (remainingAliens == 0) {
						running = false;
						gameFrame.printVictoryLabel();
					}
				}
			}
			if (entityView.getHealt() == 0) {
				new Explosion(entityView).start();
				entityViews.remove(entityView);
			}
		}
	}

	private void playerGetHit(Bullet bullet) {
		if (playerView.intersects(bullet.getBounds())) {
			playerView.getHit();
			removeBullet(bullet);
			if (!gameFrame.lifeDown()) {
				running = false;
				gameFrame.printDefeatLabel();
			}
		}
		if (playerView.getHealt() == 0) {
			new Explosion(playerView).start();
			entityViews.remove(playerView);
			running = false;
		}
	}

	private void removeBullet(Bullet bullet) {
		remove(bullet);
		bullets.remove(bullet);
		repaint();
		revalidate();
	}

	public boolean isRunning() {
		return running;
	}

}
