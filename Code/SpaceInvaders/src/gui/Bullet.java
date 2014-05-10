package gui;

import java.awt.Color;

import javax.swing.JPanel;

public class Bullet extends JPanel implements Runnable {
	
	private static final int BULLET_WIDTH = 5;
	private static final int BULLET_HEIGHT = 5;
	private static final double SPEED = 0.00001;
	public static final boolean DOWN = false;
	public static final boolean UP = true;
	
	private boolean isReached;
	private boolean direction;
	
	public Bullet(int xPos, int yPos, boolean direction) {
 		setBackground(Color.red);
		setBounds(xPos, yPos, BULLET_WIDTH, BULLET_HEIGHT);
		isReached = false;
		this.direction = direction;
	}

	@Override
	public void run() {
		double speed = SPEED;
		if (direction == UP)
			speed *= -1;
		double yPos = getY();
		while (!isReached) {
			yPos += speed;
			setBounds(getX(), (int) yPos, BULLET_WIDTH, BULLET_HEIGHT);
			if (getY() == 0)
				break;
		}
	}

}
