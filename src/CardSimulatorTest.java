import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class CardSimulatorTest {
	
	private int numberEntered;
	CardSimulator test = new CardSimulator();
	
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void testNegativeID() {
		numberEntered = -100000;
		assertFalse("Cannot have a negative ID Number", FirstGUI.MRC.isCardValid(numberEntered));
	}

	@Test	//needs to be fixed, returning false should be returning true
	public void testIsValid() {
		numberEntered = 12345;
		assertTrue("Number is in Member Record Collection", FirstGUI.MRC.isCardValid(numberEntered));
	}
/*
	@Test
	public void testisCancelled() {
		test.
		assertTrue("Action is cancelled", test.isCancelled() == true);
	}
*/
	
}
