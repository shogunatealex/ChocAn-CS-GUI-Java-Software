import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author Alex Anderson Extends RecordCollection. Holds collection of member
 *         records.
 *
 */
public class MemberRecordCollection extends RecordCollection {

	private ArrayList<MemberRecord> MemberArray = new ArrayList<MemberRecord>();
	private File fileName;

	public ArrayList<MemberRecord> retrieveRecords() {
		return MemberArray;
	}

	/*
	 * Initialize collection with contents of FileName.
	 */
	public MemberRecordCollection(String FileName) {

		fileName = new File(FileName);
		collectRecords();
		// select file to input, read it in

	}// End MemberRecordCollection
	/*
	 * (non-Javadoc) Read in member records from a file.
	 */

	public void collectRecords() {
		try {
			MemberArray.clear();
			ObjectInputStream input = null;
			try {
				input = new ObjectInputStream(new FileInputStream(fileName.getAbsoluteFile()));
			} // end catch
			catch (FileNotFoundException e2) {
				fileName.createNewFile();
				input = new ObjectInputStream(new FileInputStream(fileName.getAbsoluteFile()));
			} // end catch
			try {
				while (input != null) {
					// add it to the jlist
					MemberRecord temp = (MemberRecord) input.readObject();
					MemberArray.add(temp);

				} // end while
			} // end try

			catch (ClassNotFoundException e1) {

			} // end catch
		} catch (IOException e) {
		} // end catch
	}

	/*
	 * Add a member record, given a member record.
	 */
	public void addRecord(MemberRecord MR) {
		MemberArray.add(MR);
		saveRecords();
		collectRecords();
	}// end addRecord
	/*
	 * Add a member record, given the information of a member.
	 */

	public void addRecord(String name, int number, int zipcode, boolean active, String address, String city,
			String state) {
		MemberRecord temp = new MemberRecord(name, number, zipcode, active, address, city, state);
		MemberArray.add(temp);
		saveRecords();

	}// end addRecord
	/*
	 * (non-Javadoc) Remove selected member record.
	 */

	public void removeRecord(int index) {
		MemberArray.remove(index);
		saveRecords();
	}// end removeRecord
	/*
	 * @return validation of member number.
	 */

	public boolean isCardValid(int memNumber) {
		for (MemberRecord record : MemberArray) {
			if (record.getMemberNumber() == memNumber) {
				return true;
			} // end if
		} // end for
		return false;

	}// end isCardValid
	/*
	 * @return status of member, either active or suspended.
	 */

	public boolean isCardSuspended(MemberRecord MR) {
		if (MR.isActive()) {
			return false;
		} // if
		else {
			return true;
		} // end else
	}// end isCardSuspended
	/*
	 * Edit selected member record.
	 */

	public void editRecord(int index, String name, int number, int zipcode, boolean active, String address, String city,
			String state) {
		MemberRecord temp = new MemberRecord(name, number, zipcode, active, address, city, state);
		MemberArray.remove(index);
		MemberArray.add(index, temp);
		saveRecords();
	}

	/*
	 * @return member record
	 */
	public MemberRecord getSpecificRecord(int index) {
		return MemberArray.get(index);
	}

	/*
	 * (non-Javadoc) Save collection of member records to a file.
	 */
	public void saveRecords() {
		try {
			fileName.delete();
			fileName.createNewFile();
		} // end try
		catch (IOException e1) {

		} // end catch
		ObjectOutputStream writer = null;
		// writes to file
		try {
			writer = new ObjectOutputStream(new FileOutputStream(fileName.getAbsoluteFile()));
			for (int i = 0; i < MemberArray.size(); i++) {
				// formats string so it works correctly
				writer.writeObject(MemberArray.get(i));
			} // end for

		} catch (IOException ex) {
		} // end catch
		finally {

			try {
				writer.close();
			} catch (Exception ex) {
				/* ignore */}
		} // end finally...finally
	}// end saveRecords
	/*
	 * Toggle status of member.
	 */

	public void toggleUserStatus(int index) {
		MemberRecord temp = MemberArray.get(index);
		temp.setActive(!temp.isActive());
	}// end toggleUserStatus
	
	public void createReport(){
	
	}
	
}// end MemberRecordCollection
