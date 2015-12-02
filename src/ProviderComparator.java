
import java.util.Comparator;

/**
 * Orders service records by date.
 * 
 * @author Trevor Gentner
 */
public class ProviderComparator implements Comparator<ProviderDirectory> {
	@Override
	public int compare(ProviderDirectory r1, ProviderDirectory r2) {
		
		return r1.get_Service().toLowerCase().compareTo(r2.get_Service().toLowerCase());
	}
}