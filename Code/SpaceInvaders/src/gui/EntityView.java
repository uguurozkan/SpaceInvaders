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
		setIcon(new ImageIcon(entity.getImagePath()));
	}
	public boolean collide(Point point){
		if(entity.inBounds(point)){
			setIcon(null);
			setBackground(Color.BLACK);
			return true;
		}else 
			return false;

	}
	public abstract void move();

}
