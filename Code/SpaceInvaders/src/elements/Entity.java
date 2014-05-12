package elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.prefs.BackingStoreException;

public abstract class Entity {

	public static final int BASE_SIZE = 32;

	private Point location;
	protected Rectangle bounds;
	protected Game game;

	protected int shipSpeed;
	
	protected int horizontalSpeed;
	protected int verticalSpeed;
	Color color;

	public Entity(Game game ,int column, int row) {
		location = new Point(column*BASE_SIZE, row*BASE_SIZE);
		bounds = new Rectangle(BASE_SIZE, BASE_SIZE);
		bounds.setLocation(location);
		this.game = game;
	}

	public abstract void collided();

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
	
	public void draw(Graphics g){//This is just for now for test later needs to be changed to gui
		g.setColor(this.color);
        g.fillOval((int)(location.getX()), (int)(location.getY()),BASE_SIZE, BASE_SIZE);
	}


	public void setGame(Game game) {
		this.game = game;
	}

}
