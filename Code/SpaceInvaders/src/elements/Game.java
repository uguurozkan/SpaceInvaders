package elements;

import gui.GameFrame;
import gui.MenuPanel;

public class Game {
	Level level;

	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		MenuPanel menuPanel = new MenuPanel();
		frame.setMenuPanel(menuPanel.getMenuPanel());
	}

	public void removeAlien(Alien alien) {
		level.removeAlien(alien);
	}

	public void notifyPlayerDeath() {
	}
}
