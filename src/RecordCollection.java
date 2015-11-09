import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class RecordCollection {
	public abstract void collectRecords();
	
	public abstract void addRecord(String name, int number, int zipcode, boolean active, String address, String city,  String state);

	
	public abstract void removeRecord(int index);

	public abstract void editRecord(int index, String name, int number, int zipcode, boolean active, String address, String city,  String state);
	
	public abstract void saveRecords();

	
}
