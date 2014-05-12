package elements;

public class Alien extends Entity {

	public Alien(Game game, int row, int column) {
		super(game, row, column);
	}

	@Override
	public void collided() {
		game.removeAlien(this);
	}

	@Override
	public void goRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goLeft() {
		// TODO Auto-generated method stub
		
	}

}
