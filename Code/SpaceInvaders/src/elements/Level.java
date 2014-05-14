package elements;

import java.util.ArrayList;

public class Level {
	private ArrayList<Alien> aliens;
	private ArrayList<Barrier> barriers;


	public Level() {

	}
	
	public ArrayList<Alien> getAliens() {
		return aliens;
	}

	public void removeAlien(Alien alien) {
		aliens.remove(alien);
	}

	

	public void setAlliens(ArrayList<Alien> alienEntities) {
		this.aliens = alienEntities;
	}

	public void setBarriers(ArrayList<Barrier> barrierEntities) {
		this.barriers = barrierEntities;
	}
	public ArrayList<Barrier> getBarriers(){
		return barriers;
	}

}