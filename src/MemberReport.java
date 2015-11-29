import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class MemberReport {
    private MemberRecord record;
	public MemberReport(MemberRecord Record) {
    	record = Record;
    }

	public void saveReports(String date) {
		String filename = record.getName();
		filename = filename + date;
		filename = filename + ".txt";
		filename = filename.replaceAll("\\s","");
		try {
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
		    writer.println("Name:          " + record.getName());
		    writer.println("Member Number: " + String.format("%09d", record.getMemberNumber()));
		    writer.println("Address:       " + record.getAddress());
		    writer.println("City:          " + record.getCity());
		    writer.println("State:         " + record.getState());
		    writer.println("Zip:           " + record.getZipCode());
		    for(int i = 0; i < ChocAnSystem.SRC.size(); i++) {
			    ServiceRecord sRecord = ChocAnSystem.SRC.getSpecificRecord(i);
	            if(sRecord.getMemberNumber() == record.getMemberNumber()) {
	        	    writer.println("Date:          " + sRecord.getDate());
	        	    writer.println("Provider Name: " + ChocAnSystem.PRC.getSpecificRecordByProviderNumber(sRecord.getProviderNumber()).getName());
	        	    writer.println("Service Name:  " + ChocAnSystem.PDC.getSpecificRecordByServiceNumber(sRecord.getServiceCode()).get_Service());	        			
	            }
	        }
		    writer.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
