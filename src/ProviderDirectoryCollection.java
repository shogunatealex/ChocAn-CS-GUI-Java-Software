import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;;

public class ProviderDirectoryCollection {

	private ArrayList<ProviderDirectory> pArray = new ArrayList<ProviderDirectory>();

	public ProviderDirectoryCollection(String FileName) throws FileNotFoundException {

		int sNumber =0 ;
		String Service= "";
		double cost=0;
		
		Scanner fileScanner = new Scanner(new FileInputStream(FileName));

		while (fileScanner.hasNextLine()) {
			sNumber = fileScanner.nextInt();
			Service = fileScanner.next();
			cost = (double) fileScanner.nextLong();
			pArray.add(new ProviderDirectory(sNumber,Service,cost));
		}

	}
}
