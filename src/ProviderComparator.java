
import java.util.Comparator;

/**
 * @author Trevor Gentner
 * Orders service records by date.
 *
 */
public class ProviderComparator implements Comparator<ProviderDirectory> {
    @Override
    public int compare(ProviderDirectory r1, ProviderDirectory r2) {
        return r1.get_Service().compareTo(r2.get_Service());
    }
}