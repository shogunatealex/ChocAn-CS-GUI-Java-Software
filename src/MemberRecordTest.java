import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class MemberRecordTest {
	
	private String filename = "MemberRecords2.txt";
	private MemberRecordCollection test;
	private MemberRecord MRtest;
	
	@Before
	public void setUp(){
		test = new MemberRecordCollection(filename);
		MRtest = new MemberRecord("Haylie Helmold", 123, 60585, true, "12351 Falcon Drive", "Plainfield", "Illinois");
		//test.addRecord(MRtest);
	}
	
	@Test
	public void testIsCardValidFalse() {
		test.addRecord(MRtest);
		test.removeRecord(0);
		assertFalse("Member Number should not be Valid", test.isCardValid(MRtest.getMemberNumber()));
	}
	
	@Test
	public void testGetMemNum() {
		assertTrue("Retrieve Member Number", MRtest.getMemberNumber() == 123);
	}
	
	@Test
	public void testActive() {
		MRtest.setActive(true);
		assertTrue("Member should be Active", MRtest.isActive());
	}
	
	@Test
	public void testInActive() {
		MRtest.setActive(false);
		assertFalse("Member should be inActive", MRtest.isActive());
	}
	
	@Test
	public void testSuspension() {
		MRtest.setActive(false);
		assertTrue("Member should be Suspended", test.isCardSuspended(MRtest));
	}
	
	@Test
	public void testIsCardValidTrue() {
		test.addRecord(MRtest);
		assertTrue("Member Number should be Valid", test.isCardValid(MRtest.getMemberNumber()));
		test.removeRecord(0);
	}
}
