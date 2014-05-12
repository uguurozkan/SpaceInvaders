package elements;

import gui.GameFrame;

import java.awt.event.KeyEvent;

public class Controller {
	private Game game;
	private GameFrame gameFrame;

	public Controller() {
		this.game = new Game();
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			game.goLeft();

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			game.goRight();

		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			game.fire();

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			game.stopGoingLeft();

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			game.stopGoingRight();

		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			game.stopFire();
	}

	public void refresh() {
		game.moveEntities();
		gameFrame.refresh();
	}

	private void moveEntities() {
		// TODO Send the move message to every entity in the level.
	}
}
