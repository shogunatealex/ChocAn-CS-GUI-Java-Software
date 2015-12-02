import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

/**
 * Creates the various reports.
 * 
 * @author David Glenn
 *
 */
public class AccountingController {
	private String date;

	public AccountingController() {
		//gets date to be used
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
		StringBuilder removeTheSlashes = new StringBuilder(dateOnly.format(cal.getTime()));
		removeTheSlashes.deleteCharAt(5);
		removeTheSlashes.deleteCharAt(2);
		date = removeTheSlashes.toString();
	}

	/**
	 * Create all four reports
	 */
	public void createReports() {
		//removes ability to edit while running
		ChocAnSystem.status.setInteractiveMode(false);
		// member report
		for (int i = 0; i < ChocAnSystem.MRC.size(); i++) {
			MemberRecord Record = ChocAnSystem.MRC.getSpecificRecord(i);
			MemberReport mReport = new MemberReport(Record);
			mReport.saveReports(date);
		}
		// provider report
		for (int i = 0; i < ChocAnSystem.PRC.size(); i++) {
			ProviderRecord Record = ChocAnSystem.PRC.getSpecificRecord(i);
			ProviderReport pReport = new ProviderReport(Record);
			pReport.saveReports(date);
		}
		// eft reprort
		EFTReport eReport = new EFTReport();
		eReport.saveReports(date);

		// summary report
		SummaryReport sReport = new SummaryReport();
		sReport.saveReports(date);
		//reenables editing
		ChocAnSystem.status.setInteractiveMode(true);
	}

	/**
	 * Create Member Report
	 * 
	 * @param memberNumber
	 */
	public void createMemberReport(int memberNumber) {
		//creates report
		ChocAnSystem.status.setInteractiveMode(false);		
		MemberRecord Record = ChocAnSystem.MRC.getSpecificRecordByMemberNumber(memberNumber);
		MemberReport Report = new MemberReport(Record);
		Report.saveReports(date);
		ChocAnSystem.status.setInteractiveMode(true);
	}

	/**
	 * Create Provider Report
	 * 
	 * @param providerNumber
	 */
	public void createProviderReport(int providerNumber) {
		//creates provider report
		ChocAnSystem.status.setInteractiveMode(false);
		ProviderRecord Record = ChocAnSystem.PRC.getSpecificRecordByProviderNumber(providerNumber);
		ProviderReport Report = new ProviderReport(Record);
		Report.saveReports(date);
		ChocAnSystem.status.setInteractiveMode(true);
	}

	/**
	 * Create EFT Report
	 */
	public void createEFTReport() {
		// creates eft report
		ChocAnSystem.status.setInteractiveMode(false);
		EFTReport Report = new EFTReport();
		Report.saveReports(date);
		ChocAnSystem.status.setInteractiveMode(true);
	}

	/**
	 * Create Summary Report
	 */
	public void createSummaryReport() {
		// creates summary report
		ChocAnSystem.status.setInteractiveMode(false);
		SummaryReport Report = new SummaryReport();
		Report.saveReports(date);
		ChocAnSystem.status.setInteractiveMode(true);
	}

}
