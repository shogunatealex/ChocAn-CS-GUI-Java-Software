import javax.swing.JOptionPane;

//David

public class AccountingController {
	public AccountingController() {
    	
    }
    public void createReports() {
        for(int i = 0; i < FirstGUI.MRC.size(); i++) {
        	MemberRecord Record = FirstGUI.MRC.getSpecificRecord(i);
        	MemberReport mReport = new MemberReport(Record);
        	mReport.saveReports();
        }
        for(int i = 0; i < FirstGUI.PRC.size(); i++) {
            ProviderRecord Record = FirstGUI.PRC.getSpecificRecord(i);
            ProviderReport pReport = new ProviderReport(Record);
            pReport.saveReports();
        }
        EFTReport eReport = new EFTReport();
        eReport.saveReports();
        
        SummaryReport sReport = new SummaryReport();
        sReport.saveReports();
        
    }
    public void createMemberReport(int memberNumber) {
    	MemberRecord Record = FirstGUI.MRC.getSpecificRecordByMemberNumber(memberNumber);
    	MemberReport Report = new MemberReport(Record);
    	Report.saveReports();
    }
    public void createProviderReport(int providerNumber) {
    	ProviderRecord Record = FirstGUI.PRC.getSpecificRecordByProviderNumber(providerNumber);
    	ProviderReport Report = new ProviderReport(Record);
    	Report.saveReports();
    }
    public void createEFTReport() {
    	EFTReport Report = new EFTReport();
    	Report.saveReports();
    }
    public void createSummaryReport() {
        SummaryReport Report = new SummaryReport();
        Report.saveReports();
    }
    
}

