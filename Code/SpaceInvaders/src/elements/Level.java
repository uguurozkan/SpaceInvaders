package elements;
import java.util.ArrayList;


public class Level {
	private Map map;
	private ArrayList<Alien> aliens;

	public Level(Map map, ArrayList<Alien> aliens) {
		this.map = map;
		this.aliens = aliens;
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

}