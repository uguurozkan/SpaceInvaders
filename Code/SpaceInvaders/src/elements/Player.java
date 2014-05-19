package elements;

public class Player extends Entity {

	public Player(int row, int column) {
		super(row, column);
		setSpeed(1);
		health = 3;
	}

	@Override
	public String getImagePath() {
		return "Assets/ship1.png";
	}

}
