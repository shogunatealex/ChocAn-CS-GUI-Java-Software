	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.util.ArrayList;

public class ServiceRecordCollection {


	private ArrayList<ServiceRecord> ServiceArray = new ArrayList<ServiceRecord>();
	private File fileName;

		
	public ArrayList<ServiceRecord> retrieveRecords(){
			return ServiceArray;
		}
		
	public ServiceRecordCollection(String FileName) {


	   		fileName = new File(FileName);
	   		collectRecords();
			// select file to input, read it in

		}//End MemberRecordCollection
		public void collectRecords(){
			try{
				ServiceArray.clear();
				ObjectInputStream input = null;
				try {
					input = new ObjectInputStream(new FileInputStream(fileName.getAbsoluteFile()));
				}// end catch 
				catch (FileNotFoundException e2) {
					fileName.createNewFile();
					input = new ObjectInputStream(new FileInputStream(fileName.getAbsoluteFile()));
				}// end catch 
				try {
					while(input != null){
						// add it to the jlist
						ServiceRecord temp = (ServiceRecord)input.readObject();
			    		ServiceArray.add(temp);
				
					}// end while
				}// end try 
		
				catch (ClassNotFoundException e1) {

				}// end catch
			}
			catch (IOException e){
			}// end catch
		}

			
		

		public void addRecord(ServiceRecord SR){
			ServiceArray.add(SR);
			saveRecords();
			collectRecords();
		}// end addRecord
		
		public void addRecord(String date, String time, int providerNumber, int memberNumber, int ServiceCode, String Comments){
			ServiceRecord temp = new ServiceRecord(date, time, providerNumber, memberNumber, ServiceCode, Comments);
			ServiceArray.add(temp);
			saveRecords();
			
		}// end addRecord
		
		public void removeRecord(int index){
			ServiceArray.remove(index);
			saveRecords();
		}// end removeRecord
		
			
		
		
		public void editRecord(int index, String date, String time, int providerNumber, int memberNumber, int ServiceCode, String Comments){
			ServiceRecord temp = new ServiceRecord(date, time, providerNumber, memberNumber, ServiceCode, Comments);
			ServiceArray.remove(index);
			ServiceArray.add(index, temp);
			saveRecords();
		}
		public ServiceRecord getSpecificRecord(int index){
			return ServiceArray.get(index);
		}
		
		
		public void saveRecords(){
			try {
				fileName.delete();
				fileName.createNewFile();
			}// end try 
			catch (IOException e1) {

			}// end catch
			ObjectOutputStream writer = null;
			// writs to file
			try {
			    writer = new ObjectOutputStream(
			          new FileOutputStream(fileName.getAbsoluteFile()));
			    for(int i = 0; i < ServiceArray.size(); i++){
		    		// formats string so it works correctly
			    	writer.writeObject(ServiceArray.get(i));
			    }// end for

			} catch (IOException ex) {
			}// end catch 
			finally {

			   try {writer.close();} catch (Exception ex) {/*ignore*/}
			}// end finally...finally
		}// end saveRecords
		
	}// end MemberRecordCollection

