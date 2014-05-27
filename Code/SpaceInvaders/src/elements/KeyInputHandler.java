package elements;

import gui.MusicPlayer;
import gui.PlayerView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {
	PlayerView playerView;

	public KeyInputHandler(PlayerView playerView) {
		this.playerView = playerView;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			playerView.goLeft();

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			playerView.goRight();

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			MusicPlayer.getInstance().playBulletSound();
			playerView.fire();
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			playerView.stopLeft();

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			playerView.stopRight();

	}

}
