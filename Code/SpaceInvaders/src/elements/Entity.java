package elements;

import gui.GamePanel;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Entity {
	public static final int BASE_SIZE = 32;

	private Point location;
	protected Rectangle bounds;

	protected int health;
	protected int speed;
	protected int horizontalSpeed;
	protected int verticalSpeed;

	public static Entity getEntity(char tileChar, int row, int col) {
		if (tileChar == 'x')
			return new Alien(row, col);
		else if (tileChar == 'b')
			return new Barrier(row, col);
		else
			return null;
	}

	public Entity(int row, int column) {
		location = new Point(column * BASE_SIZE, row * BASE_SIZE);
		bounds = new Rectangle(BASE_SIZE, BASE_SIZE);
		bounds.setLocation(location);
	}

	public boolean intersects(Entity entity) {
		return bounds.intersects(entity.getBounds());
	}

	public void moveHorizontally(double px) {
		if (isInBounds(px))
			setLocation(location.getX() + px, location.getY());
	}

	private boolean isInBounds(double px) {
		return (location.getX() + px) > 0
				&& (location.getX() + px) < (GamePanel.WIDTH - BASE_SIZE);
	}

	public void moveVertically(double py) {
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

	public boolean intersects(Rectangle r) {
		return bounds.intersects(r);
	}

	public Point getLocation() {
		return location;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void move() {
		moveVertically(verticalSpeed);
		moveHorizontally(horizontalSpeed);
	}

	public void goRight() {
		horizontalSpeed = speed;
	}

	public void goLeft() {
		horizontalSpeed = -speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void stop() {
		this.horizontalSpeed = 0;
		this.verticalSpeed = 0;
	}

	public abstract String getImagePath();

	public Dimension getSize() {
		return bounds.getSize();
	}

	public void stopRight() {
		if (horizontalSpeed > 0) {
			horizontalSpeed = 0;
		}
	}

	public void stopLeft() {
		if (horizontalSpeed < 0) {
			horizontalSpeed = 0;
		}
	}

	public int getHealth() {
		return health;
	}

	public void getHit() {
		health -= 1;
	}

}
