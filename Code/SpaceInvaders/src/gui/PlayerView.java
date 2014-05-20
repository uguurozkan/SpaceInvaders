package gui;

import java.awt.Rectangle;

import elements.Player;

@SuppressWarnings("serial")
public class PlayerView extends EntityView {

	public PlayerView(Player player, GamePanel gamePanel) {
		super(player, gamePanel);
		setLocation(320, 608);
		player.setLocation(getLocation());
		setFocusable(true);
	}

	public void goLeft() {
		entity.goLeft();
	}

	public void goRight() {
		entity.goRight();
	}

	public void stopRight() {
		entity.stopRight();
	}

	public void stopLeft() {
		entity.stopLeft();
	}

	@Override
	public Bullet getBullet() {
		Rectangle r = entity.getBounds();
		return new Bullet((int) r.getCenterX(), (int) r.getCenterY(),
				Bullet.UP, BulletType.PlayerBullet);
	}

}