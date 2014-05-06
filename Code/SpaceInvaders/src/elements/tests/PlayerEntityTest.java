package elements.tests;

import org.junit.Test;

import elements.Entity;
import elements.Game;
import elements.Player;

public class PlayerEntityTest extends EntityTest{

	@Override
	public Entity getEntity(int row, int column) {
		return new Player(new Game(), "playerName", row, column);
	}

}
