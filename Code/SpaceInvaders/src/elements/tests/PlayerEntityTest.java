package elements.tests;

import org.junit.Test;

import elements.Entity;
import elements.Game;
import elements.Player;

public class PlayerEntityTest extends EntityTest{

	@Override
	public Entity getEntity() {
		return new Player(new Game(), "playerName", 0, 0);
	}

}
