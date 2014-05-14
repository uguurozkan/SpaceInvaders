package elements;

public class Player extends Entity {
	private String playerName;
	private final int SHIP_SPEED = 10;

	public Player(String playerName, int row, int column) {
		super(row, column);
		this.playerName = playerName;
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
