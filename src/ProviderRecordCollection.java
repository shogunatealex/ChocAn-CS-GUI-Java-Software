import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author Alex Anderson Collection of provider records. Allows for reading,
 *         saving, adding, editing, and removing provider records.
 *
 */
public class ProviderRecordCollection extends RecordCollection {

	private ArrayList<ProviderRecord> ProviderArray = new ArrayList<ProviderRecord>();
	private File fileName;

	/*
	 * @return ProviderRecordCollection
	 */
	public ArrayList<ProviderRecord> retrieveRecords() {
		return ProviderArray;
	}

	/*
	 * Initialize collection with file.
	 */
	public ProviderRecordCollection(String FileName) {

		fileName = new File(FileName);
		collectRecords();
		// select file to input, read it in

	}// End MemberRecordCollection
	/*
	 * (non-Javadoc) Reads provider records from a file.
	 */

	public void collectRecords() {
		try {
			ProviderArray.clear();
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
					ProviderRecord temp = (ProviderRecord) input.readObject();
					ProviderArray.add(temp);

				} // end while
			} // end try

			catch (ClassNotFoundException e1) {

			} // end catch
		} catch (IOException e) {
		} // end catch
	}

	/*
	 * @param PR provider record Adds a provider record.
	 */
	public void addRecord(ProviderRecord PR) {
		ProviderArray.add(PR);
		saveRecords();
		collectRecords();
	}// end addRecord
	/*
	 * Adds a provider record, given the information of a provider.
	 */

	public void addRecord(String name, int number, int zipcode, String address, String city, String state) {
		ProviderRecord temp = new ProviderRecord(name, number, zipcode, address, city, state);
		ProviderArray.add(temp);
		saveRecords();

	}// end addRecord
	/*
	 * (non-Javadoc) Remove selected provider record.
	 */

	public void removeRecord(int index) {
		ProviderArray.remove(index);
		saveRecords();
	}// end removeRecord
	/*
	 * @param provNumber provider number
	 * 
	 * @return valid if valid provider number, otherwise false.
	 */

	public boolean isProvider(int provNumber) {
		for (ProviderRecord record : ProviderArray) {
			if (record.getProviderNumber() == provNumber) {
				return true;
			} // end if
		} // end for
		return false;

	}// end isCardValid
	/*
	 * Edit selected provider record.
	 */

	public void editRecord(int index, String name, int number, int zipcode, String address, String city, String state) {
		ProviderRecord temp = new ProviderRecord(name, number, zipcode, address, city, state);
		ProviderArray.remove(index);
		ProviderArray.add(index, temp);
		saveRecords();
	}

	/*
	 * @return selected provider record.
	 */
	public ProviderRecord getSpecificRecord(int index) {
		return ProviderArray.get(index);
	}

	/*
	 * (non-Javadoc) Save provider records to a file.
	 */
	public void saveRecords() {
		try {
			fileName.delete();
			fileName.createNewFile();
		} // end try
		catch (IOException e1) {

		} // end catch
		ObjectOutputStream writer = null;
		// writs to file
		try {
			writer = new ObjectOutputStream(new FileOutputStream(fileName.getAbsoluteFile()));
			for (int i = 0; i < ProviderArray.size(); i++) {
				// formats string so it works correctly
				writer.writeObject(ProviderArray.get(i));
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

}// end ProviderRecordCollection
