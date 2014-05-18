package elements;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Entity {

	public static final int BASE_SIZE = 32;

	private Point location;
	protected Rectangle bounds;

	protected int shipSpeed;
	
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
		location = new Point(column*BASE_SIZE ,row*BASE_SIZE);
		bounds = new Rectangle(BASE_SIZE, BASE_SIZE);
		bounds.setLocation(location);
	}

	public abstract boolean collided();

	public void moveHorizontally(double px) {
		setLocation(location.getX() + px, location.getY());
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
	public boolean inBounds(Point point){
		return bounds.contains(point);
	}

	public Point getLocation() {
		return location;
	}
	
	public void move(){
		moveVertically(verticalSpeed);
		moveHorizontally(horizontalSpeed);
	}
	
	public void goRight() {
		horizontalSpeed = shipSpeed;
	}
	
	public void goLeft(){
		horizontalSpeed = shipSpeed;
	}
	
	public void stop() {
		this.horizontalSpeed = 0;
		this.verticalSpeed = 0;
	}

	public abstract String getImagePath();
	
	public Dimension getSize() {
		return bounds.getSize();
	}
}
