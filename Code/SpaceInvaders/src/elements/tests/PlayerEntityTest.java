package elements.tests;

import org.junit.Test;

import elements.Entity;
import elements.Game;
import elements.PlayerEntity;

public class PlayerEntityTest extends EntityTest{

	@Override
	public Entity getEntity() {
		return new PlayerEntity(new Game(), "playerName", 0, 0);
	}

}
