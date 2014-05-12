package elements;

public class Player extends Entity {
	private String playerName;
	private final int SHIP_SPEED = 10;

	public Player(Game game, String playerName, int row, int column) {
		super(game, row, column);
		this.playerName = playerName;
	}

	@Override
	public void collided() {
		game.notifyPlayerDeath();
	}

	public void fire() {
		// TODO wait for bullet implementation
	}

	public void stopFire() {
		// TODO wait for bullet implementation

	}

}
