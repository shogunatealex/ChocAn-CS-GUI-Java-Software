import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;

/**
 * Creates the EFT Report 
 * @author David Glenn
 *
 */
public class EFTReport {
    public EFTReport() {
    }
	
	public void saveReports(String date) {
		String filename = "EFT" + date + ".txt";
		try {
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
		    for(int i = 0; i < ChocAnSystem.PRC.size(); i++) {
			    double fee = 0;
			    ProviderRecord pRecord = ChocAnSystem.PRC.getSpecificRecord(i);
		        for(int j = 0; j < ChocAnSystem.SRC.size(); j++) {
			        ServiceRecord sRecord = ChocAnSystem.SRC.getSpecificRecord(j);
	                if(sRecord.getProviderNumber() == pRecord.getProviderNumber()) {
	        	        fee += ChocAnSystem.PDC.getSpecificRecordByServiceNumber(sRecord.getServiceCode()).get_Cost();
	                }
		        }
		        writer.println("Provider name:   " + pRecord.getName());
		        writer.println("Provider number: " + String.format("%09d",pRecord.getProviderNumber()));
                writer.println("Total fee:       " + fee);
		    }
		    writer.close();
	    }
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
