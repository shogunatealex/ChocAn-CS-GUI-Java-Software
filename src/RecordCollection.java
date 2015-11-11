import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class RecordCollection {
	public abstract void collectRecords();
	

	
	public abstract void removeRecord(int index);

	public abstract void saveRecords();

	
}
