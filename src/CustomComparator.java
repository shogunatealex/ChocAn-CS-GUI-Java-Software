import java.util.Comparator;

/**
 * Orders service records by date.
 *
 * @author Trevor Gentner
 * 
 */
public class CustomComparator implements Comparator<ServiceRecord> {
	@Override
	public int compare(ServiceRecord r1, ServiceRecord r2) {
		String[] word1 = new String[3];
		String[] word2 = new String[3];
		word1= r1.getDate().split("-");
		word2 = r2.getDate().split("-");

		if (word1[1].compareTo(word2[2]) == 0) {
			if (word1[1].compareTo(word2[1]) == 0) {
				return  0 - word1[0].compareTo(word2[0]);
			} else {
				return 0 - word1[1].compareTo(word2[1]);
			}
		} else {
			return 0- word1[2].compareTo(word2[2]);
		}
	}
}