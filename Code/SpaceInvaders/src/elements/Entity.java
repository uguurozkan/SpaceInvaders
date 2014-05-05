package elements;

import java.awt.Point;
import java.awt.Rectangle;

public abstract class Entity {

	public static final int BASE_SIZE = 32;

	private Point location;
	protected Rectangle bounds;
	protected Game game;

	public Entity(Game game ,int row, int column) {
		location = new Point(column*BASE_SIZE, row*BASE_SIZE);
		bounds = new Rectangle(BASE_SIZE, BASE_SIZE);
		bounds.setLocation(location);
		this.game = game;
	}

	public abstract void collided();
	
	public void changeX(double px) {
		setLocation(location.getX() + px, location.getY());
	}

	public void changeY(double py) {
		setLocation(location.getX(), location.getY() + py);
	}

	public void setLocation(Point p) {
		location.setLocation(p);
		bounds.setLocation(p);
	}

	public void setLocation(double x, double y) {
		location.setLocation(x, y);
		bounds.setLocation(location);
	}

	public Point getLocation() {
		return location;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}

}
