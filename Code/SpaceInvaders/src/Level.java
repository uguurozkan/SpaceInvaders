import java.util.ArrayList;


public class Level {
	private Map map;
	private ArrayList<Enemy> enemies;

	public Level(Map map, ArrayList<Enemy> enemies) {
		this.map = map;
		this.enemies = enemies;
	}

	public Map getMap() {
		return map;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public String toString() {
		return map.toString();
	}

}