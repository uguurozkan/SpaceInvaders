package gui;

import java.awt.Color;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Bullet extends JPanel {
	
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
	
	public TimerTask getAnimation() {
		return new TimerTask() {
			@Override
			public void run() {
				double speed = SPEED;
				if (direction == UP)
					speed *= -1;
				if (getY() > -6)
					setBounds(getX(), (int) (getY() + speed), BULLET_WIDTH, BULLET_HEIGHT);
			}
		};
	}

}
