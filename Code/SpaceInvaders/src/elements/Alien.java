package elements;

import java.awt.Color;



public class Alien extends Entity {
	int dir;

	public Alien(Game game, int row, int column) {
		super(game, row, column);
		this.color=Color.BLUE;
		this.dir=0;
	}

	@Override
	public void collided() {
		game.removeAlien(this);
	}

	@Override
	public void goRight() {
			this.setLocation(this.getLocation().getX()+1*Entity.BASE_SIZE, this.getLocation().getY());
		}

	@Override
	public void goLeft() {
		this.setLocation(this.getLocation().getX()-1*Entity.BASE_SIZE, this.getLocation().getY());
		
	}
	private void goDown() {
		this.setLocation(this.getLocation().getX(), this.getLocation().getY()+1*Entity.BASE_SIZE);
		
	}
	public void move(){
		if(dir==0){
			goRight();
			dir=1;
		}
		else if(dir==1){
			goDown();
			dir=2;
		}
		else if(dir==2){
			goLeft();
			dir=3;
		}
		else if(dir==3){
			goDown();
			dir=0;
		}
	}

	

}
