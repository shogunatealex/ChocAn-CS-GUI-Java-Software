import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

//David

public class AccountingController {
	private String date;
	
	public AccountingController() {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
	    StringBuilder removeTheSlashes = new StringBuilder(dateOnly.format(cal.getTime()));
	    removeTheSlashes.deleteCharAt(5);
	    removeTheSlashes.deleteCharAt(2);
	    date = removeTheSlashes.toString();
    }
    public void createReports() {
        for(int i = 0; i < FirstGUI.MRC.size(); i++) {
        	MemberRecord Record = FirstGUI.MRC.getSpecificRecord(i);
        	MemberReport mReport = new MemberReport(Record);
        	mReport.saveReports(date);
        }
        for(int i = 0; i < FirstGUI.PRC.size(); i++) {
            ProviderRecord Record = FirstGUI.PRC.getSpecificRecord(i);
            ProviderReport pReport = new ProviderReport(Record);
            pReport.saveReports(date);
        }
        EFTReport eReport = new EFTReport();
        eReport.saveReports(date);
        
        SummaryReport sReport = new SummaryReport();
        sReport.saveReports(date);
        
    }
    public void createMemberReport(int memberNumber) {
    	MemberRecord Record = FirstGUI.MRC.getSpecificRecordByMemberNumber(memberNumber);
    	MemberReport Report = new MemberReport(Record);
    	Report.saveReports(date);
    }
    public void createProviderReport(int providerNumber) {
    	ProviderRecord Record = FirstGUI.PRC.getSpecificRecordByProviderNumber(providerNumber);
    	ProviderReport Report = new ProviderReport(Record);
    	Report.saveReports(date);
    }
    public void createEFTReport() {
    	EFTReport Report = new EFTReport();
    	Report.saveReports(date);
    }
    public void createSummaryReport() {
        SummaryReport Report = new SummaryReport();
        Report.saveReports(date);
    }
    
}

