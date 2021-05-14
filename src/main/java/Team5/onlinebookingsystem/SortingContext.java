package Team5.onlinebookingsystem;

import java.util.List;

public class SortingContext {

    private SortingStrategy strategy;

    public SortingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortFlights (List<Flight> flightList){
        strategy.sort(flightList);
    }
}
