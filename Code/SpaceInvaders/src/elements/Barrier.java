package elements;

public class Barrier extends Entity {

	public Barrier(int column,int row) {
		super(column, row);
		setSpeed(0);
		health = 2;
	}

	@Override
	public String getImagePath() {
		return "Assets/Barriers/Barrier0.png";
	}

}
