import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author Alex Anderson Collection of service records. Allows for reading,
 *         saving, adding, editing, and removing service records.
 *
 */
public class ServiceRecordCollection {

	private ArrayList<ServiceRecord> ServiceArray = new ArrayList<ServiceRecord>();
	private File fileName;

	public ArrayList<ServiceRecord> retrieveRecords() {
		return ServiceArray;
	}

	public ServiceRecordCollection(String FileName) {

		fileName = new File(FileName);
		collectRecords();
		// select file to input, read it in

	}// End MemberRecordCollection

	/**
	 * Read service records from a file.
	 */

	public void collectRecords() {
		try {
			ServiceArray.clear();
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
					ServiceRecord temp = (ServiceRecord) input.readObject();
					ServiceArray.add(temp);

				} // end while
			} // end try

			catch (ClassNotFoundException e1) {

			} // end catch
		} catch (IOException e) {
		} // end catch
		this.sorter();
	}
	public void sorter(){
		Collections.sort(this.ServiceArray, new CustomComparator());
	}

	/**
	 * @param SR
	 *            service record Add service record.
	 */
	public void addRecord(ServiceRecord SR) {
		ServiceArray.add(SR);
		saveRecords();
		collectRecords();
	}// end addRecord

	/**
	 * Add service record given information.
	 * 
	 * @param date
	 * @param time
	 * @param providerNumber
	 * @param memberNumber
	 * @param ServiceCode
	 * @param Comments
	 */
	
	public void addRecord(String date, String time, int providerNumber, int memberNumber, int ServiceCode,
			String Comments) {
		ServiceRecord temp = new ServiceRecord(date, time, providerNumber, memberNumber, ServiceCode, Comments);
		ServiceArray.add(temp);
		saveRecords();

	}// end addRecord

	/**
	 * Remove selected service record.
	 */

	public void removeRecord(int index) {
		ServiceArray.remove(index);
		saveRecords();
	}// end removeRecord

	/**
	 * Edit selected service record.
	 */

	public void editRecord(int index, String date, String time, int providerNumber, int memberNumber, int ServiceCode,
			String Comments) {
		ServiceRecord temp = new ServiceRecord(date, time, providerNumber, memberNumber, ServiceCode, Comments);
		ServiceArray.remove(index);
		ServiceArray.add(index, temp);
		saveRecords();
	}

	/**
	 * @return serviceRecord selected
	 */
	public ServiceRecord getSpecificRecord(int index) {
		return ServiceArray.get(index);
	}

	/**
	 * Save service records to a file.
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
			for (int i = 0; i < ServiceArray.size(); i++) {
				// formats string so it works correctly
				writer.writeObject(ServiceArray.get(i));
			} // end for

		} catch (IOException ex) {
		} // end catch
		finally {

			try {
				writer.close();
			} catch (Exception ex) {
				/* ignore */}
		} // end finally...finally
		this.sorter();
	}// end saveRecords

	/**
	 * Create new service record.
	 */
	public void createReport() {
		JFrame window = new JFrame();
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(window);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = chooser.getSelectedFile().getAbsolutePath();

			try {
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
				PrintStream printStream = new PrintStream(output);
				for (ServiceRecord record : this.ServiceArray) {
					printStream.print(record.printLine());
				}
				printStream.close();
				output.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public int size() {
        return ServiceArray.size();
	}
}// end MemberRecordCollection
