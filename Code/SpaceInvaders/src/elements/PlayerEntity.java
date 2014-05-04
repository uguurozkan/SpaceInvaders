package elements;

public class PlayerEntity extends Entity{
	private Game currentGame;
	private String playerName;

	public PlayerEntity(Game game, String playerName, int xPos, int yPos) {
		this.currentGame = game;
		this.playerName = playerName;
		super.setXPos(xPos);
		super.setYPos(yPos);
	}
	
	@Override
	public void collideWith(Entity other) {
		if(other instanceof AlienEntity){
			currentGame.notifyDeath();
		}
	}

}
