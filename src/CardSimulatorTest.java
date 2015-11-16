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
		numberEntered = 000012345;
		boolean x = FirstGUI.MRC.isCardValid(numberEntered);
		System.out.print(x);
		assertTrue("Number is in Member Record Collection", x);
	}

	@Test
	public void testisCancelled() {
		test.
		assertTrue("Action is cancelled", test.isCancelled() == true);
	}

}
