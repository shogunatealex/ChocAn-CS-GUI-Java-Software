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
		for (int i = 0; i < ChocAnSystem.MRC.size(); i++) {
			MemberRecord Record = ChocAnSystem.MRC.getSpecificRecord(i);
			MemberReport mReport = new MemberReport(Record);
			mReport.saveReports(date);
		}
		for (int i = 0; i < ChocAnSystem.PRC.size(); i++) {
			ProviderRecord Record = ChocAnSystem.PRC.getSpecificRecord(i);
			ProviderReport pReport = new ProviderReport(Record);
			pReport.saveReports(date);
		}
		EFTReport eReport = new EFTReport();
		eReport.saveReports(date);

		SummaryReport sReport = new SummaryReport();
		sReport.saveReports(date);

	}

	/**
	 * Create Member Report
	 * 
	 * @param memberNumber
	 */
	public void createMemberReport(int memberNumber) {
		MemberRecord Record = ChocAnSystem.MRC.getSpecificRecordByMemberNumber(memberNumber);
		MemberReport Report = new MemberReport(Record);
		Report.saveReports(date);
	}

	/**
	 * Create Provider Report
	 * 
	 * @param providerNumber
	 */
	public void createProviderReport(int providerNumber) {
		ProviderRecord Record = ChocAnSystem.PRC.getSpecificRecordByProviderNumber(providerNumber);
		ProviderReport Report = new ProviderReport(Record);
		Report.saveReports(date);
	}

	/**
	 * Create EFT Report
	 */
	public void createEFTReport() {
		EFTReport Report = new EFTReport();
		Report.saveReports(date);
	}

	/**
	 * Create Summary Report
	 */
	public void createSummaryReport() {
		SummaryReport Report = new SummaryReport();
		Report.saveReports(date);
	}

}
