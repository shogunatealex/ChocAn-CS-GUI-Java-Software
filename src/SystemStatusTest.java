import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class SystemStatusTest {

	SystemStatus newSystem = new SystemStatus();

	@Before
	public void setUp() {
		SystemStatus newSystem = new SystemStatus();
	}

	@Test
	public void testGetStatus() {
		assertTrue("Get Status", newSystem.checkMode()); // system is in
															// interactive
	}

	@Test
	public void testToggleStatus() {
		newSystem.setInteractiveMode(false);
		assertFalse("Get Status", newSystem.checkMode()); // system is not
															// interactive
	}
}