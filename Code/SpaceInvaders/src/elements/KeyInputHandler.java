package elements;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {
	private int shipSpeed = 10;
	private Player player;
	public boolean leftPressed, rightPressed, spacePressed;

	public void KeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			leftPressed = true;

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			rightPressed = true;

		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			spacePressed = true;

	}

	public void KeyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			leftPressed = false;

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			rightPressed = false;

		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			spacePressed = false;

	}

	public void dummyMethod() {
		if (leftPressed && !rightPressed)
			player.moveHorizontally(shipSpeed);
		else if (rightPressed && !leftPressed)
			player.moveHorizontally(-shipSpeed);

		if (spacePressed)
			player.fire();

	}

}
