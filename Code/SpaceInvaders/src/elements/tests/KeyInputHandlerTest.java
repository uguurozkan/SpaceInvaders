package elements.tests;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;

import javax.swing.JFrame;

import org.junit.Test;

import static org.junit.Assert.*;
import elements.Game;
import elements.KeyInputHandler;
import elements.PlayerEntity;

public class KeyInputHandlerTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testLeftKey() throws AWTException {
		KeyInputHandler kih = new KeyInputHandler();

		kih.KeyPressed(new KeyEvent(new JFrame(), KeyEvent.KEY_PRESSED, System
				.currentTimeMillis(), 0, KeyEvent.VK_LEFT));
		assertTrue(kih.leftPressed);
		
		kih.KeyReleased(new KeyEvent(new JFrame(), KeyEvent.KEY_RELEASED, System
				.currentTimeMillis(), 0, KeyEvent.VK_LEFT));
		assertFalse(kih.leftPressed);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testRightKey() throws AWTException {
		KeyInputHandler kih = new KeyInputHandler();
		
		kih.KeyPressed(new KeyEvent(new JFrame(), KeyEvent.KEY_PRESSED, System
				.currentTimeMillis(), 0, KeyEvent.VK_RIGHT));
		assertTrue(kih.rightPressed);
		
		kih.KeyReleased(new KeyEvent(new JFrame(), KeyEvent.KEY_RELEASED, System
				.currentTimeMillis(), 0, KeyEvent.VK_RIGHT));
		assertFalse(kih.rightPressed);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSpaceKey() throws AWTException {
		KeyInputHandler kih = new KeyInputHandler();
		
		kih.KeyPressed(new KeyEvent(new JFrame(), KeyEvent.KEY_PRESSED, System
				.currentTimeMillis(), 0, KeyEvent.VK_SPACE));
		assertTrue(kih.spacePressed);
		
		kih.KeyReleased(new KeyEvent(new JFrame(), KeyEvent.KEY_RELEASED, System
				.currentTimeMillis(), 0, KeyEvent.VK_SPACE));
		assertFalse(kih.spacePressed);
	}
}
