package gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import elements.Entity;

public abstract class EntityView extends JLabel {
	private Timer bulletTimer;
	protected Entity entity;
	protected GamePanel gamePanel;

	public EntityView(Entity entity, GamePanel gamePanel) {
		this.entity = entity;
		this.gamePanel = gamePanel;
		setLocation(entity.getLocation());
		setSize(entity.getSize());
		setEntityIcon(entity.getImagePath());
		setTimer();
	}


	private void setTimer() {
		bulletTimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bulletTimer.stop();
			}
		});
	}

	public void setEntityIcon(String imagePath) {
		setIcon(new ImageIcon(imagePath));
	}

	public boolean intersects(Entity other) {
		return entity.intersects(other);
	}
	
	public boolean intersects(Rectangle r) {
		return entity.intersects(r);
	}

	public void move() {
		entity.move();
		setBounds(entity.getBounds());
	}
	
	public void fire() {
		if (!bulletTimer.isRunning()) {
			gamePanel.addBullet(getBullet());
			bulletTimer.start();
		}
	}
	
	public void getHit() {
		entity.getHit();
	}
	
	public int getHealt() {
		return entity.getHealth();
	}
	
	public abstract Bullet getBullet(); 

}
