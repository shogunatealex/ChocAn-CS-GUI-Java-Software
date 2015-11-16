
public class MemberReport {
    private MemberRecord record;
	public MemberReport(MemberRecord Record) {
    	record = Record;
    }
	public void collectReports() {
		
	}
	public void saveReports() {
		System.out.println("Name:          " + record.getName());
		System.out.println("Member Number: " + record.getMemberNumber());
		System.out.println("Address:       " + record.getAddress());
		System.out.println("City:          " + record.getCity());
		System.out.println("State:         " + record.getState());
		System.out.println("Zip:           " + record.getZipCode());
	}
}
