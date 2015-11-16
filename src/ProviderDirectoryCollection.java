import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;;

//Trevor
/**
 * @author Trevor Gentner Collection of Provider records. Allowing for reading,
 *         saving, adding, editing, and removing provider provider record.
 * @return ProviderDirectoryCollection collection of provider records
 */
public class ProviderDirectoryCollection {

	private ArrayList<ProviderDirectory> pArray = new ArrayList<ProviderDirectory>();
	private File fileName;

	public ArrayList<ProviderDirectory> retrieveRecords() {
		return pArray;
	}

	public ProviderDirectoryCollection(String FileName) {

		fileName = new File(FileName);
		collectRecords();

	}

	/*
	 * Read in provider records from file.
	 */
	public void collectRecords() {
		try {
			pArray.clear();
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
					ProviderDirectory temp = (ProviderDirectory) input.readObject();
					pArray.add(temp);

				} // end while
			} // end try

			catch (ClassNotFoundException e1) {

			} // end catch
		} catch (IOException e) {
		} // end catch
	}

	/*
	 * Add provider record, given provider record.
	 */
	public void addRecord(ProviderDirectory PD) {
		pArray.add(PD);
		saveRecords();
		collectRecords();
	}// end removeRecord
	/*
	 * Add provider record, given information of a provider.
	 */

	public void addRecord(int sNumbers, String Services, double costs) {
		ProviderDirectory temp = new ProviderDirectory(sNumbers, Services, costs);
		pArray.add(temp);
		saveRecords();
		collectRecords();
	}

	/*
	 * Remove selected provider record.
	 */
	public void removeRecord(int index) {
		pArray.remove(index);
		saveRecords();
	}// end removeRecord
	/*
	 * Edit selected provider record.
	 */

	public void editRecord(int index, int sNumbers, String Services, double costs) {
		ProviderDirectory temp = new ProviderDirectory(sNumbers, Services, costs);
		pArray.remove(index);
		pArray.add(index, temp);
	}

	/*
	 * @return providerRecord selected provider record.
	 */
	public ProviderDirectory getSpecificRecord(int index) {
		return pArray.get(index);
	}

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
			writer = new ObjectOutputStream(new FileOutputStream(fileName.getAbsolutePath()));
			for (int i = 0; i < pArray.size(); i++) {
				// formats string so it works correctly
				writer.writeObject(pArray.get(i));
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

}
