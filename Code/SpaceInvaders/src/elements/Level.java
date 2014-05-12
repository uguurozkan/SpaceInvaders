package elements;
import java.awt.Graphics;
import java.util.ArrayList;


public class Level {
	private Map map;
	private ArrayList<Alien> aliens;
	private int dir;
	private int counter;
	private static final int MAX_TIME=5;

	public Level(Map map, ArrayList<Alien> aliens) {
		this.map = map;
		this.aliens = aliens;
		this.dir=0;
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
			if(dir==0){
				move(1,0);
				dir=1;
			}
			else if(dir==1){
				move(0,1);
				dir=2;
			}
			else if(dir==2){
				move(-1,0);
				dir=3;
			}
			else if(dir==3){
				move(0,1);
				dir=0;
			}
			counter=0;
		}
		else{
			counter++;
		}

	}

	private void move(int x, int y) {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).setLocation(aliens.get(i).getLocation().getX()+x*Alien.BASE_SIZE, aliens.get(i).getLocation().getY()+y*Alien.BASE_SIZE);
		}

	}

	public void draw(Graphics g) {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

	}

}