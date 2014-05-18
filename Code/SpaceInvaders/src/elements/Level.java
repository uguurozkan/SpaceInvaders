package elements;

import java.util.ArrayList;

public class Level {
	private ArrayList<Alien> aliens;
	private ArrayList<Barrier> barriers;


	public Level() {
		aliens = new ArrayList<Alien>();
		barriers = new ArrayList<Barrier>();
	}
	
	public ArrayList<Alien> getAliens() {
		return aliens;
	}
	
	public ArrayList<Barrier> getBarriers(){
		return barriers;
	}

	public void removeAlien(Alien alien) {
		aliens.remove(alien);
	}

	public void addAllien(Alien alien) {
		aliens.add(alien);
	}

	public void addBarrier(Barrier barrier) {
		barriers.add(barrier);
	}
}