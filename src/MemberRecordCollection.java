import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberRecordCollection extends RecordCollection{

	private ArrayList<MemberRecord> MemberArray = new ArrayList<MemberRecord>();
	private File fileName;

	public void main(String args[]) throws FileNotFoundException{
		MemberRecordCollection MRC = new MemberRecordCollection("Testing.txt");
		for (int i = 0; i < 20; i++)
		{
			MemberRecord temp = new MemberRecord("Alex Anderson", i, 19962, true, "Whereever I want", "Magnolia", "Delaware");
			MRC.addRecord(temp);
		}
		for (MemberRecord record: MRC.retrieveRecords()){
			System.out.println(record.getMemberNumber());
		}

		
	}
	
	public ArrayList<MemberRecord> retrieveRecords(){
		return MemberArray;
	}
	
	public MemberRecordCollection(String FileName) throws FileNotFoundException {


   		fileName = new File(FileName);
		// select file to input, read it in

	}//End MemberRecordCollection
	public void collectRecords(){
		try{
			MemberArray.clear();
			ObjectInputStream input = null;
			try {
				input = new ObjectInputStream(new FileInputStream(fileName.getAbsoluteFile()));
			}// end catch 
			catch (FileNotFoundException e2) {
				fileName.createNewFile();
			}// end catch 
			try {
				while(input != null){
					// add it to the jlist
					MemberRecord temp = (MemberRecord)input.readObject();
		    		MemberArray.add(temp);
			
				}// end while
			}// end try 
	
			catch (ClassNotFoundException e1) {
			}// end catch
		}
		catch (IOException e){
			
		}
	}

		
	

	public void addRecord(MemberRecord MR){
		MemberArray.add(MR);
		saveRecords();
	}// end addRecord
	
	public void addRecord(String name, int number, int zipcode, boolean active, String address, String city,  String state){
		MemberRecord temp = new MemberRecord(name, number, zipcode, active, address, city, state);
		MemberArray.add(temp);
		saveRecords();
		
	}// end addRecord
	
	public void removeRecord(int index){
		MemberArray.remove(index);
		saveRecords();
	}// end removeRecord
	
	public boolean isCardValid(int memNumber){
		for (MemberRecord record: MemberArray){
			if (record.getMemberNumber() == memNumber){
				return true;
			}// end if
		}// end for
		return false;
		
		
	}// end isCardValid
	
	public boolean isCardSuspended(MemberRecord MR){
		if (MR.isActive()){
			return false;
		}// if
		else{
			return true;
		}// end else
	}// end isCardSuspended
	
	public void editRecord(int index, String name, int number, int zipcode, boolean active, String address, String city,  String state){
		MemberRecord temp = new MemberRecord(name, number, zipcode, active, address, city, state);
		MemberArray.remove(index);
		MemberArray.add(index, temp);
		saveRecords();
	}
	
	public void saveRecords(){
		try {
			fileName.delete();
			fileName.createNewFile();
		}// end try 
		catch (IOException e1) {
			e1.printStackTrace();
		}// end catch
		ObjectOutputStream writer = null;
		// writs to file
		try {
		    writer = new ObjectOutputStream(
		          new FileOutputStream(fileName.getAbsoluteFile()));
		    for(int i = 0; i < MemberArray.size(); i++){
	    		// formats string so it works correctly
		    	writer.writeObject(MemberArray.get(i));
		    }// end for

		} catch (IOException ex) {
		  System.out.println("Supplied file was not found, please check that file " + fileName.getAbsolutePath() + " has been created");
		}// end catch 
		finally {

		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}// end finally...finally
	}// end saveRecords
	
	public void toggleUserStatus(int index){
		MemberRecord temp = MemberArray.get(index);
		temp.setActive(!temp.isActive());
	}// end toggleUserStatus
	
}// end MemberRecordCollection

