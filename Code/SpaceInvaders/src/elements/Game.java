package elements;

import gui.GameFrame;
import gui.MenuPanel;

public class Game {
	Level level;
	Player player;

	

	public void removeAlien(Alien alien) {
		level.removeAlien(alien);
	}

	public void notifyPlayerDeath() {
	}

	public void moveEntities() {
		player.move();
	}
	
	public void goLeft() {
		player.goLeft();
	}

	public void goRight() {
		player.goRight();
	}

	public void fire() {
		player.fire();
	}

	public void stopGoingLeft() {
		player.stop();
	}

	public void stopGoingRight() {
		player.stop();
	}

	public void stopFire() {
		player.stopFire();
	}	
}
