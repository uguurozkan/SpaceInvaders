package elements;

import gui.GameFrame;
import gui.MenuPanel;

public class Game {
	Level level;

	public static void main(String[] args) {
		new GameFrame();
	}

	public void removeAlien(Alien alien) {
		level.removeAlien(alien);
	}

	public void notifyPlayerDeath() {
	}
}
