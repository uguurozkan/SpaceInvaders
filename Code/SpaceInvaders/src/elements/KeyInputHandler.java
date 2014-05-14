package elements;

import gui.GamePanel;
import gui.PlayerView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {
	Controller controller;
	PlayerView playerView;
	
	private GamePanel gamePanel;
	private boolean rightPressed = false;
	private boolean leftPressed = false;
	
	public KeyInputHandler(PlayerView playerView, GamePanel gamePanel) {
		this.playerView = playerView;
		this.gamePanel = gamePanel;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			playerView.setLocation(playerView.getX() - 5, playerView.getY());
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			playerView.setLocation(playerView.getX() + 5, playerView.getY());
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			gamePanel.fireBullet(playerView.getX() + playerView.getWidth() / 2, playerView.getY() - 5);
		
		playerView.repaint();
		playerView.revalidate();
	}

}
