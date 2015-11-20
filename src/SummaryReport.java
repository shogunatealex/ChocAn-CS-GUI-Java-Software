

public class SummaryReport {
    public SummaryReport() {
    }
	
    public void collectReports() {	
	}
	public void saveReports() {
		int totalServices = 0;
		int totalProviders = 0;
		double totalFee = 0;
		for(int i = 0; i < FirstGUI.PRC.size(); i++) {
			double providerFee = 0;
			int providerServices = 0;
			ProviderRecord pRecord = FirstGUI.PRC.getSpecificRecord(i);
		    for(int j = 0; j < FirstGUI.SRC.size(); j++) {
			    ServiceRecord sRecord = FirstGUI.SRC.getSpecificRecord(j);
	            if(sRecord.getProviderNumber() == pRecord.getProviderNumber()) {
	        	    providerFee += FirstGUI.PDC.getSpecificRecordByServiceNumber(sRecord.getServiceCode()).get_Cost();
	                providerServices += 1;
	            }
		    }
		        System.out.println("Provider name:     " + pRecord.getName());
		        System.out.println("Provider number:   " + String.format("%09d",pRecord.getProviderNumber()));
		        System.out.println("Provider services: " + providerServices);
                System.out.println("Total fee:         " + providerFee);
 
                totalProviders += 1;
                totalServices += providerServices;
                totalFee += providerFee;
	    }
		System.out.println("Total providers:   " + totalProviders);
		System.out.println("Total services:    " + totalServices);
		System.out.println("Total fee:         " + String.format("%.2f",totalFee));
	}
}
