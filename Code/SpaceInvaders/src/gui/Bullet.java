package gui;

import java.awt.Color;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.xml.ws.handler.MessageContext.Scope;

public class Bullet extends JPanel {

	private static final int BULLET_WIDTH = 5;
	private static final int BULLET_HEIGHT = 5;
	private static final int SPEED = 2;
	public static final boolean DOWN = false;
	public static final boolean UP = true;

	private boolean direction;
	private int second;
	private final static int FREQ = 2;
	BulletType type;

	public Bullet(int xPos, int yPos, boolean direction, BulletType type) {
		setBackground(Color.red);
		setBounds(xPos, yPos, BULLET_WIDTH, BULLET_HEIGHT);
		this.direction = direction;
		this.type = type;
	}

	public boolean isInsidePanel(){
		return getY()>0;
	}
	
	public void move() {
		second++;
		if(second==FREQ){
			double speed = SPEED;
			if (direction == UP)
				speed *= -1;
			setLocation(getX(), (int) (getY() + speed));
			second =0;
			repaint();
			revalidate();
		}
	}

}
