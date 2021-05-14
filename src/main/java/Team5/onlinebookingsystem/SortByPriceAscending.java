package Team5.onlinebookingsystem;

import java.util.Comparator;
import java.util.List;

public class SortByPriceAscending implements SortingStrategy{

    @Override
    public void sort(List<Flight> flightList) {
        Comparator<Flight> compareByPrice = (Flight f1, Flight f2) -> Float.compare(Float.parseFloat(f1.getPrice()),Float.parseFloat(f2.getPrice()));
        flightList.sort(compareByPrice);
    }
}
