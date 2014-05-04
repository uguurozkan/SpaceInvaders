package elements;
import java.util.ArrayList;


public class Level {
	private Map map;
	private ArrayList<AlienEntity> alienEntities;

	public Level(Map map, ArrayList<AlienEntity> alienEntities) {
		this.map = map;
		this.alienEntities = alienEntities;
	}

	public Map getMap() {
		return map;
	}

	public ArrayList<AlienEntity> getEnemies() {
		return alienEntities;
	}

	public String toString() {
		return map.toString();
	}

}