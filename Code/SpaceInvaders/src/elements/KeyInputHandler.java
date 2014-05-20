package elements;

import gui.GamePanel;
import gui.PlayerView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {
	PlayerView playerView;

	public KeyInputHandler(PlayerView playerView) {
		this.playerView = playerView;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			playerView.goLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			playerView.goRight();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			playerView.fire();
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			playerView.stopLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			playerView.stopRight();
		}
	}

}
