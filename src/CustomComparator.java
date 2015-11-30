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
		return r1.getDate().compareTo(r2.getDate());
	}
}