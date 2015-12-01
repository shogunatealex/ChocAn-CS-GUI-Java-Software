import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class ProviderRecordTest {

	private String filename = "ProviderRecords2.txt";
	private ProviderRecordCollection prCollection;
	private ProviderRecord PR;

	@Before
	public void setUp() {
		prCollection = new ProviderRecordCollection(filename);
		PR = new ProviderRecord("Haylie Helmold", 1, 60585, "12351 Falcon Drive", "Plainfield", "Illinois");
		prCollection.addRecord(PR);
	}

	@Test
	public void testProvNum() {
		assertTrue("Provier number should be correct", PR.getProviderNumber() == 1);
		assertFalse("Provider Number should be incorrect", PR.getProviderNumber() == 2);
	}

	@Test
	public void testIsProviderTrue() {
		assertTrue("True Provider", prCollection.isProvider(PR.getProviderNumber()));
	}
	
	@After
	public void endTest(){
		prCollection.removeRecord(0);
	}
}
