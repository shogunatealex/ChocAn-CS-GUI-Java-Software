import java.util.Comparator;

public class CustomComparator implements Comparator<ServiceRecord> {
    @Override
    public int compare(ServiceRecord r1, ServiceRecord r2) {
        return r1.getDate().compareTo(r2.getDate());
    }
}