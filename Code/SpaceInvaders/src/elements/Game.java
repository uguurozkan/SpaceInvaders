package elements;

import gui.GameWindow;
import gui.MenuPanel;

public class Game {
	Level level;
	public static void main(String[] args) {
		GameWindow window = new GameWindow();
	}

	public void removeAlien(Alien alien) {
		level.removeAlien(alien);
	}
	
	public void notifyPlayerDeath() {
	}
}
