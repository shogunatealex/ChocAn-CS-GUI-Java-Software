import java.util.Iterator;

public class ProviderReport {
    private ProviderRecord record;
	public ProviderReport(ProviderRecord Record) {
    	record = Record;
    }
	public void collectReports() {
		
	}
	public void saveReports() {
		System.out.println("Name:            " + record.getName());
		System.out.println("Provider Number: " + String.format("%09d", record.getProviderNumber()));
		System.out.println("Address:         " + record.getAddress());
		System.out.println("City:            " + record.getCity());
		System.out.println("State:           " + record.getState());
		System.out.println("Zip:             " + record.getZipCode());
		for(int i = 0; i < FirstGUI.SRC.size(); i++) {
			ServiceRecord sRecord = FirstGUI.SRC.getSpecificRecord(i);
	        if(sRecord.getProviderNumber() == record.getProviderNumber()) {
	        	System.out.println("Date:            " + sRecord.getDate());
	        	System.out.println("Time:            " + sRecord.getTime());
	        	System.out.println("Member Name:     " + FirstGUI.MRC.getSpecificRecordByMemberNumber(sRecord.getMemberNumber()).getName());
	        	System.out.println("Member Number:   " + String.format("%09d", sRecord.getMemberNumber()));
	        	System.out.println("Service Code:    " + sRecord.getServiceCode());
	        	//print fee
	        }
		}
        //print total services
		//print total fee
	}
}
