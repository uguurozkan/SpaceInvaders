package elements;

import java.awt.Graphics;
import java.util.ArrayList;

import gui.GameFrame;
import gui.MenuPanel;

public class Game {
	Level level;
	public Player player;
	
	public Game(){
		char[][] forMap=new char[30][30];//just for test
		Map map=new Map(forMap);//just for test
		this.level=new Level(map,generateAliens());
		
		
	}
	
	public ArrayList<Alien> generateAliens(){//for test only 
		ArrayList<Alien> aliens=new ArrayList<Alien>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				Alien alien=new Alien(this, i, j);
				aliens.add(alien);
			}
		}
		return aliens;
	}

	public void removeAlien(Alien alien) {
		level.removeAlien(alien);
	}

	public void notifyPlayerDeath() {
	}

	public void moveEntities() {
		level.moveAliens();
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
	
	public Level getLevel() {
		return level;
	}

	public void draw(Graphics g) {
		//player draw();
		level.draw(g);
		
	}	
}
