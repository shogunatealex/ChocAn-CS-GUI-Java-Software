
public class ProviderReport {
    private ProviderRecord record;
	public ProviderReport(ProviderRecord Record) {
    	record = Record;
    }
	public void collectReports() {
		
	}
	public void saveReports() {
		System.out.println("Name:            " + record.getName());
		System.out.println("Provider Number: " + record.getProviderNumber());
		System.out.println("Address:         " + record.getAddress());
		System.out.println("City:            " + record.getCity());
		System.out.println("State:           " + record.getState());
		System.out.println("Zip:             " + record.getZipCode());
	}
}
