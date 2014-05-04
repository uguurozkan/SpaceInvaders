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

	public void testMoveHorizontallyToRight() {
		Entity entity = getEntity();
		int x = entity.getXPos();
		entity.moveHorizontally(10);
		assertEquals(x + 10, entity.getXPos());
	}
	
	public void testMoveHorizontallyToLeft() {
		Entity entity = getEntity();
		int x = entity.getXPos();
		entity.moveHorizontally(-10);
		assertEquals(x - 10, entity.getXPos());
	}
	
	public void testMoveVerticallyToUp(){
		Entity entity = getEntity();
		int y = entity.getYPos();
		entity.moveVertically(10);
		assertEquals(y + 10, entity.getYPos());
	}
	
	public void testMoveVerticallyToDown(){
		Entity entity = getEntity();
		int y = entity.getYPos();
		entity.moveVertically(-10);
		assertEquals(y - 10, entity.getYPos());
	}
	

}
