import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class ProviderDirectoryCollectionTest {
	
	private String filename = "PDC1.txt";
	private ProviderDirectoryCollection p = new ProviderDirectoryCollection(filename);
	private ProviderDirectory PD;
	
	@Before
	public void setUp(){
		ProviderDirectory PD = new ProviderDirectory(123, "Help", 100.00);
	}
	
	@Test
	public void testAddRecord() {
		p.addRecord(PD);
		assertTrue("Number of records in Collection", p.retrieveRecords().size() == 1);
	}

	@Test
	public void testRemoveRecord() {
		p.addRecord(PD);
		p.removeRecord(0);
		assertTrue("Number of records in Collection", p.retrieveRecords().size() == 0);
	}
	

}
