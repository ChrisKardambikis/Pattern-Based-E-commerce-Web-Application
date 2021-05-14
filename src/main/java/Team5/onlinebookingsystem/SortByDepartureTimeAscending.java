package Team5.onlinebookingsystem;
import java.util.Comparator;
import java.util.List;

public class SortByDepartureTimeAscending implements SortingStrategy {

    @Override
    public void sort(List<Flight> flightList) {
        Comparator<Flight> compareByDepartureTime = (Flight f1, Flight f2) -> Float.compare(Float.parseFloat(f1.getDepartureTime()), Float.parseFloat(f2.getDepartureTime()));
        flightList.sort(compareByDepartureTime);
    }
}
