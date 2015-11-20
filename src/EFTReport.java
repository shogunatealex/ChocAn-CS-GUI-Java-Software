
public class EFTReport {
    public EFTReport() {
    }
	
    public void collectReports() {	
	}
	public void saveReports() {
		for(int i = 0; i < FirstGUI.PRC.size(); i++) {
			double fee = 0;
			ProviderRecord pRecord = FirstGUI.PRC.getSpecificRecord(i);
		    for(int j = 0; j < FirstGUI.SRC.size(); j++) {
			    ServiceRecord sRecord = FirstGUI.SRC.getSpecificRecord(j);
	            if(sRecord.getProviderNumber() == pRecord.getProviderNumber()) {
	        	    fee += FirstGUI.PDC.getSpecificRecordByServiceNumber(sRecord.getServiceCode()).get_Cost();
	            }
		    }
		    System.out.println("Provider name:   " + pRecord.getName());
		    System.out.println("Provider number: " + String.format("%09d",pRecord.getProviderNumber()));
            System.out.println("Total fee:       " + fee);
	    }
	}
}
