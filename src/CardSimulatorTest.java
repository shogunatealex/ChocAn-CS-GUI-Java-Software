import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class CardSimulatorTest {
	
	private int numberEntered;
	
	@Before
	public void setUp(){
		CardSimulator test = new CardSimulator();	
	}
	
	@Test
	public void testNegativeID() {
		numberEntered = -100000;
		assertFalse("Cannot have a negative ID Number", ChocAnSystem.MRC.isCardValid(numberEntered));
	}

	@Test
	public void testIsValid() {
		numberEntered = 1;
		assertTrue("Number is in Member Record Collection", ChocAnSystem.MRC.isCardValid(numberEntered));
	}
	
}
