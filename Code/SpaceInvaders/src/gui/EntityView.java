package gui;

import java.awt.Color;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elements.Entity;

public abstract class EntityView extends JLabel {
	public Entity entity;

	public EntityView(Entity entity) {
		this.entity = entity;
		setLocation(entity.getLocation());
		setSize(entity.getSize());
		setEntityIcon(entity.getImagePath());
	}

	public void setEntityIcon(String imagePath) {
		setIcon(new ImageIcon(imagePath));
	}

	public boolean collide(Point point) {
		if (entity.inBounds(point)) {
			Explosion explosion = new Explosion(this);
			explosion.start();
			// setIcon(null);
			// setBackground(Color.BLACK);
			return true;
		} else
			return false;

	}

	public abstract void move();

}
