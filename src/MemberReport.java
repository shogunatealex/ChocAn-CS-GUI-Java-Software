
public class MemberReport {
    private MemberRecord record;
	public MemberReport(MemberRecord Record) {
    	record = Record;
    }
	public void collectReports() {
		
	}
	public void saveReports() {
		System.out.println("Name:          " + record.getName());
		System.out.println("Member Number: " + String.format("%09d", record.getMemberNumber()));
		System.out.println("Address:       " + record.getAddress());
		System.out.println("City:          " + record.getCity());
		System.out.println("State:         " + record.getState());
		System.out.println("Zip:           " + record.getZipCode());
		for(int i = 0; i < FirstGUI.SRC.size(); i++) {
			ServiceRecord sRecord = FirstGUI.SRC.getSpecificRecord(i);
	        if(sRecord.getMemberNumber() == record.getMemberNumber()) {
	        	System.out.println("Date:          " + sRecord.getDate());
	        	System.out.println("Provider Name: " + FirstGUI.PRC.getSpecificRecordByProviderNumber(sRecord.getProviderNumber()).getName());
	        	System.out.println("Service Name:  " + sRecord.getServiceCode());	        			
	        }
		}
	}
}
