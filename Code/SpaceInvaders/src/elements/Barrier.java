package elements;

public class Barrier extends Entity {

	public Barrier(int column,int row) {
		super(column, row);
	}

	@Override
	public boolean collided() {
		return true;
	}

	@Override
	public String getImagePath() {
		return "Assets/Barriers/Barrier0.png";
	}

}
