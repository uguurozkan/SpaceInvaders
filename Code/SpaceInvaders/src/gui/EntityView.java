package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elements.Entity;

public abstract class EntityView extends JLabel {
	public Entity entity;
	public EntityView(Entity entity) {
		this.entity = entity;
		setLocation(entity.getLocation());
		setSize(entity.getSize());
		setIcon(new ImageIcon(entity.getImagePath()));
	}
	public abstract void collide();
	public abstract void move();

}
