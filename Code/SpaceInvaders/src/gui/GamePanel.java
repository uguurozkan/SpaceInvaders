package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private final int WIDTH = 900;
	private final int HEIGHT = 550;

	private StatusPanel statusPanel;
	private PlayerView playerView;

	public GamePanel(Rectangle frameBounds) {
		setLayout(null);
		setBounds(frameBounds);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
	}
	
	public void strayBullet() {
		Bullet strayBullet = new Bullet(getWidth() / 2, getHeight() - 5, Bullet.UP);
		add(strayBullet);
		new Thread(strayBullet).start();
	}

}
