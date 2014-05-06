package elements.tests;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

import elements.Entity;

public abstract class EntityTest {
	protected final static double ERROR_MARGIN = 0.0001;
	public abstract Entity getEntity(int row, int column);

	@Test
	public void testGettersAndSetters() {
		Entity entity = getEntity(1, 2);
		Point p = entity.getLocation();
		assertEquals(1.0 * Entity.BASE_SIZE, p.getX(), ERROR_MARGIN);
		assertEquals(2.0 * Entity.BASE_SIZE, p.getY(), ERROR_MARGIN);
	}
	
	@Test
	public void testMoveHorizontallyToRight() {
		Entity entity = getEntity(2, 2);
		
		Point pBefore = (Point) entity.getLocation().clone();
		entity.moveHorizontally(10);
		Point pAfter = entity.getLocation();
		assertEquals(pBefore.getX() + 10, pAfter.getX(), ERROR_MARGIN);
	}

	@Test
	public void testMoveHorizontallyToLeft() {
		Entity entity = getEntity(2, 2);

		Point pBefore = (Point) entity.getLocation().clone();
		entity.moveHorizontally(-10);
		Point pAfter = entity.getLocation();
		assertEquals(pBefore.getX() - 10, pAfter.getX(), ERROR_MARGIN);
	}

	public void testMoveVerticallyToUp() {
		Entity entity = getEntity(2, 2);

		Point pBefore = (Point) entity.getLocation().clone();
		entity.moveVertically(10);
		Point pAfter = entity.getLocation();
		assertEquals(pBefore.getY() + 10, pAfter.getY(), ERROR_MARGIN);
	}

	@Test
	public void testMoveVerticallyToDown() {
		Entity entity = getEntity(2, 2);

		Point pBefore = (Point) entity.getLocation().clone();
		entity.moveVertically(-10);
		Point pAfter = entity.getLocation();
		assertEquals(pBefore.getY() - 10, pAfter.getY(), ERROR_MARGIN);
	}

}
