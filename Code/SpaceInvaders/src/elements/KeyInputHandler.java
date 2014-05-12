package elements;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {
	Controller controller;

	public void keyPressed(KeyEvent e) {
		controller.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		controller.keyReleased(e);
	}

}
