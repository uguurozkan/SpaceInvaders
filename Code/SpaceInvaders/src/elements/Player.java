package elements;

public class Player extends Entity {
	private String playerName;

	public Player(Game game, String playerName, int row, int column) {
		super(game, row, column);
		this.game = game;
		this.playerName = playerName;
	}

	@Override
	public void collided() {
		game.notifyPlayerDeath();
	}

	public void fire() {
		// TODO Auto-generated method stub

	}

}
