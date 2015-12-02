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
		numberEntered = 123456789;
		ChocAnSystem.MRC.addRecord("john", 123456789, 12345, true, "somewhere", "test", "test");
		assertTrue("Number is in Member Record Collection", ChocAnSystem.MRC.isCardValid(numberEntered));
		ChocAnSystem.MRC.removeRecord(ChocAnSystem.MRC.size() - 1);
	}
	
	@Test
	public void testIsCardSuspended(){
		numberEntered = 123456789;
		ChocAnSystem.MRC.addRecord("john", 123456789, 12345, false, "somewhere", "test", "test");
		assertTrue("Member is supsended",ChocAnSystem.MRC.isCardSuspended(numberEntered));
		ChocAnSystem.MRC.removeRecord(ChocAnSystem.MRC.size() - 1);
		
		
	}
	
	
}
