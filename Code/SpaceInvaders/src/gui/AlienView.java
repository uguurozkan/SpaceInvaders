package gui;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import elements.Alien;

public class AlienView extends EntityView {
	private double fireChance = 0.0005;
	private int alienIconTurn;
	private final static int FREQ = 32;
	private int frequency;
	private static Random random = new Random();

	ImageIcon icon = new ImageIcon("Assets/Invaders/Invader0.png");

	public AlienView(Alien alien, GamePanel gamePanel) {
		super(alien, gamePanel);
		alienIconTurn = 0;
		setIcon(icon);
	}

	@Override
	public void fire() {
		if (random.nextDouble() < fireChance) {
			super.fire();
		}
	}

	@Override
	public Bullet getBullet() {
		Rectangle r = entity.getBounds();
		return new Bullet((int) r.getCenterX(), (int) r.getCenterY(),
				Bullet.DOWN, BulletType.AlienBullet);
	}

	@Override
	public void move() {
		entity.move();
		frequency++;
		if (frequency == FREQ) {
			setNextIcon();
			frequency = 0;
		}
		setBounds(entity.getBounds());
	}

	private void setNextIcon() {
		alienIconTurn = (alienIconTurn + 1) % 2;
		setIcon(new ImageIcon("Assets/Invaders/Invader" + alienIconTurn	+ ".png"));
	}
}
