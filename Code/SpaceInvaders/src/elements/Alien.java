package elements;

public class Alien extends Entity {
	private int counter = 0;
	private int limit = 150;
	private int dir = 1;

	public Alien(int row, int column) {
		super(row, column);
		setSpeed(1);
		health = 1;
	}

	@Override
	public String getImagePath() {
		return "Assets/Invaders/Invader1.png";
	}

	public void move() {
		if (counter == limit || counter == -limit) {
			dir *= -1;
		}
		counter += dir;
		if (dir == -1) {
			goLeft();
		} else {
			goRight();
		}
		super.move();
	}

}
