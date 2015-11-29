import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;


public class SummaryReport {
    public SummaryReport() {
    }
	

	public void saveReports(String date) {
		int totalServices = 0;
		int totalProviders = 0;
		double totalFee = 0;
		String filename = "Summary" + date + ".txt";
		try {
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
		    for(int i = 0; i < ChocAnSystem.PRC.size(); i++) {
			    double providerFee = 0;
			    int providerServices = 0;
			    ProviderRecord pRecord = ChocAnSystem.PRC.getSpecificRecord(i);
		        for(int j = 0; j < ChocAnSystem.SRC.size(); j++) {
			        ServiceRecord sRecord = ChocAnSystem.SRC.getSpecificRecord(j);
	                if(sRecord.getProviderNumber() == pRecord.getProviderNumber()) {
	        	        providerFee += ChocAnSystem.PDC.getSpecificRecordByServiceNumber(sRecord.getServiceCode()).get_Cost();
	                    providerServices += 1;
	                }
		        }
		            writer.println("Provider name:     " + pRecord.getName());
		            writer.println("Provider number:   " + String.format("%09d",pRecord.getProviderNumber()));
		            writer.println("Provider services: " + providerServices);
                    writer.println("Total fee:         " + providerFee);
 
                    totalProviders += 1;
                    totalServices += providerServices;
                    totalFee += providerFee;
	        }
		    writer.println("Total providers:   " + totalProviders);
		    writer.println("Total services:    " + totalServices);
		    writer.println("Total fee:         " + String.format("%.2f",totalFee));
		    writer.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
