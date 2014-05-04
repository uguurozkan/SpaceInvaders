package elements;

public abstract class Entity {

	public abstract void collideWith(Entity other);

	protected int xPos, yPos;

	public void setXPos(int x) {
		this.xPos = x;
	}

	public void setYPos(int y) {
		this.yPos = y;
	}

	public int getXPos() {
		return this.xPos;
	}

	public int getYPos() {
		return this.yPos;
	}

	public void move(int delta) {
		this.xPos += delta;
	}

}
