package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Barrier extends JLabel {
	private final static int LIFE = 2;
	private final static int HEIGHT = 32;
	private final static int WIDTH = 44;

	private int collisionAmount;

	public Barrier(int x, int y) {
		setLocation(x, y);
		collisionAmount = 0;
		setSize(WIDTH, HEIGHT);
		chooseForm(collisionAmount);
	}

	public void chooseForm(int x) {
		setIcon(new ImageIcon("Assets/Barriers/Barrier" + x + ".png"));
		repaint();
		revalidate();
	}

	public boolean isColliding(int x, int y) {
		if (contains(x, y) && collisionAmount < LIFE) 
			return true;
		else
			return false;
	

	}

	public void collide() {
		collisionAmount++;
		if (collisionAmount < LIFE)
			chooseForm(collisionAmount);
		else {
			chooseForm(collisionAmount);
			ActionListener boom = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setIcon(null);
					repaint();
					revalidate();

				}
			};
			Timer t = new Timer(100, boom);
			t.setRepeats(false);
			t.start();
		}
	}

}
