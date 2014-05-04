package elements.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import elements.Entity;

public abstract class EntityTest {
	public abstract Entity getEntity();

	@Test
	public void testGettersAndSetters() {
		Entity entity = getEntity();
		entity.setXPos(0);
		entity.setYPos(0);
		assertEquals(0, entity.getXPos());
		assertEquals(0, entity.getYPos());
	}

	public void testMove() {
		Entity entity = getEntity();
		int x = entity.getXPos();
		entity.move(10);
		assertEquals(x + 10, entity.getXPos());
	}

}
