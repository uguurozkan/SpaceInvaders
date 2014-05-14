package elements;



public class Alien extends Entity {
	int dir;

	public Alien(int row, int column) {
		super(row, column);
		this.dir=0;
	}

	@Override
	public boolean collided() {
		return true;
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

	@Override
	public String getImagePath() {
		return "Assets/Invaders/Invader1.png";
	}

	

}
