package elements;

public class Controller {
	

	public Controller() {
		
	}
	
	public Player getPlayer(){
		return new Player("palyer", 30,14 );
	}
	public Level getLevel(){
		return LevelLoader.loadLevel(0);
	}
}
