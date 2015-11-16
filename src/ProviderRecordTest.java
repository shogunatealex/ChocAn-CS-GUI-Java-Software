import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class ProviderRecordTest {
	
	private String filename = "ProviderRecords.txt";
	private ProviderRecordCollection prCollection = new 
			ProviderRecordCollection(filename);
	private ProviderRecord PR;
	
	
	@Before
	public void setUp(){
		PR = new ProviderRecord("Haylie Helmold", 60585, 8989, 
					"12351 Falcon Drive", "Plainfield", "Illinois");
		prCollection.addRecord(PR);
	}
	
	@Test
	public void testProvNum() {
		assertTrue("Get Correct Provider Number", PR.getProviderNumber() == 8989);
		assertFalse("Get Correct Provider Number", PR.getProviderNumber() == 9898);
	}

	@Test
	public void testIsProviderTrue() {
		assertTrue("True Provider", 
				prCollection.isProvider(PR.getProviderNumber()));
	}
	@Test
	public void testIsProviderFalse() {
		
	}
}
