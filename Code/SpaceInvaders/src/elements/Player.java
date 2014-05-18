package elements;

public class Player extends Entity {
	private final int SHIP_SPEED = 10;

	public Player(int row, int column) {
		super(row, column);
	}

	@Override
	public boolean collided() {
		return true;
	}

	public void fire() {
		// TODO wait for bullet implementation
	}

	public void stopFire() {
		// TODO wait for bullet implementation
	}

	@Override
	public String getImagePath() {
		return "Assets/ship1.png";
	}

}
