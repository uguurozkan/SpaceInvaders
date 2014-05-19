package gui;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import elements.Alien;

public class AlienView extends EntityView {
	private double fireChance = 0.0005;
	private static Random random = new Random();
	
	ImageIcon icon = new ImageIcon("Assets/Invaders/invaderGif.gif");
	public AlienView(Alien alien, GamePanel gamePanel) {
		super(alien, gamePanel);
		setIcon(icon);
	}
	@Override
	public void fire() {
		if(random.nextDouble() < fireChance) {
			super.fire();
		}
	}
	@Override
	public Bullet getBullet() {
		Rectangle r = entity.getBounds();
		return new Bullet((int) r.getCenterX(), (int) r.getCenterY(),
				Bullet.DOWN, BulletType.AlienBullet);
	}

}
