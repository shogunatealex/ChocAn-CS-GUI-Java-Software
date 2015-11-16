package org.conner.demo.chocan.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class CardSimulatorTest {
	
	private int numberEntered;
	CardSimulator test = new CardSimulator();
	
	@Before
	public void setUp(){
		numberEntered = 100000;
		test.cardNum.getText();
		
	}
	
	@Test
	public void testIsCancelled() {
		fail("Not yet implemented");
	}

	@Test
	public void testCardSimulator() {
		fail("Not yet implemented");
	}

	@Test
	public void testActionPerformed() {
		fail("Not yet implemented");
	}

}
