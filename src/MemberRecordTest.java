import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class MemberRecordTest {
	
	private String filename = "MemberRecords.txt";
	private MemberRecordCollection test = new MemberRecordCollection(filename);
	private MemberRecord MRtest;
	
	@Before
	public void setUp(){
		MRtest = new MemberRecord("Haylie Helmold", 7276, 60585, true,
				"12351 Falcon Drive", "Plainfield", "Illinois");
	}
	
	@Test
	public void testGetMemNum() {
		assertTrue("Retrieve Member Number", MRtest.getMemberNumber() == 7276);
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
	}
	
	@Test //Need to figure out how to delete the Record
	public void testIsCardValidFalse() {
		test.removeRecord(0);
		System.out.print(test.retrieveRecords().size());
		System.out.print(MRtest.getMemberNumber());
		System.out.print(test.isCardValid(MRtest.getMemberNumber()));
		assertFalse("Member Number should not be Valid", test.isCardValid(MRtest.getMemberNumber()));
	}

}
