package elements;
import java.awt.Graphics;
import java.util.ArrayList;


public class Level {
	private Map map;
	private ArrayList<Alien> aliens;
	
	private int counter;
	private static final int MAX_TIME=5;

	public Level(Map map, ArrayList<Alien> aliens) {
		this.map = map;
		this.aliens = aliens;
		counter=0;
	}

	public Map getMap() {
		return map;
	}

	public ArrayList<Alien> getAliens() {
		return aliens;
	}

	public void setGameForEntities(Game game) {
		for (Alien alien : aliens) {
			alien.setGame(game);
		}
	}

	public void removeAlien(Alien alien) {
		aliens.remove(alien);
	}

	public String toString() {
		return map.toString();
	}

	public void moveAliens() {
		// TODO Auto-generated method stub
		//for all aliens move horizont then down then horizontback then down
		if(counter>=MAX_TIME){
			for (int i = 0; i < aliens.size(); i++) {
				aliens.get(i).move();
			}
			counter=0;
		}
		else{
			counter++;
		}

	}

	

	public void draw(Graphics g) {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

	}

}