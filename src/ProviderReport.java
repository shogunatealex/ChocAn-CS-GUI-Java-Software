import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Create Provider Report
 * 
 * @author David Glenn
 *
 */
public class ProviderReport {
	private ProviderRecord record;
	private double fee;
	private int services;

	public ProviderReport(ProviderRecord Record) {
		record = Record;
		fee = 0;
		services = 0;
	}

	public void saveReports(String date) {
		String filename = record.getName();
		filename = filename + date;
		filename = filename + ".txt";
		filename = filename.replaceAll("\\s", "");
		try {
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			writer.println("Name:            " + record.getName());
			writer.println("Provider Number: " + String.format("%09d", record.getProviderNumber()));
			writer.println("Address:         " + record.getAddress());
			writer.println("City:            " + record.getCity());
			writer.println("State:           " + record.getState());
			writer.println("Zip:             " + record.getZipCode());
			for (int i = 0; i < ChocAnSystem.SRC.size(); i++) {
				ServiceRecord sRecord = ChocAnSystem.SRC.getSpecificRecord(i);
				if (sRecord.getProviderNumber() == record.getProviderNumber()) {
					writer.println("Date:            " + sRecord.getDate());
					writer.println("Time:            " + sRecord.getTime());
					writer.println("Member Name:     "
							+ ChocAnSystem.MRC.getSpecificRecordByMemberNumber(sRecord.getMemberNumber()).getName());
					writer.println("Member Number:   " + String.format("%09d", sRecord.getMemberNumber()));
					writer.println("Service Code:    " + String.format("%06d", sRecord.getServiceCode()));
					writer.println("Service Fee:     "
							+ ChocAnSystem.PDC.getSpecificRecordByServiceNumber(sRecord.getServiceCode()).get_Cost());
					fee += ChocAnSystem.PDC.getSpecificRecordByServiceNumber(sRecord.getServiceCode()).get_Cost();
					services += 1;
				}
			}
			writer.println("Total services: " + services);
			writer.println("Total fee:      " + fee);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
