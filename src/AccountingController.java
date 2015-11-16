import javax.swing.JOptionPane;

//David

public class AccountingController {
	public AccountingController() {
    	
    }
    public void createReports() {
    	System.out.println("Main accounting procedure not yet implemented");
    }
    public void createMemberReport(int memberNumber) {
    	MemberRecord Record = FirstGUI.MRC.getSpecificRecordByMemberNumber(memberNumber);
    	MemberReport Report = new MemberReport(Record);
    	Report.saveReports();
    }
    public void createProviderReport(int providerNumber) {
    	ProviderRecord Record = FirstGUI.PRC.getSpecificRecordByProviderNumber(providerNumber);
    	System.out.println(Record.getName());
    }
    public void createEFTReport() {
    	System.out.println("EFT reports not yet implemented");
    }
    public void createSummaryReport() {
    	System.out.println("Summary reports not yet implemented");
    }
    
}

