package Team5.onlinebookingsystem;
import java.util.Comparator;
import java.util.List;

public class SortByDuration implements SortingStrategy {



    @Override
    public void sort(List<Flight> flightList) {
        Comparator<Flight> compareByDuration = (f1, f2) -> {
            int f1DT;
            int f1AT;
            int f2DT;
            int f2AT;
            int f1Duration;
            int f2Duration;


            /**
            calculate minute time values for flight f1
            minute time for HH:MM = (HH)*60 + (MM)
            */
            f1DT= (Integer.parseInt(getFormattedTime(f1,"departure").substring(0,2))*60)
                    +(Integer.parseInt(getFormattedTime(f1,"departure").substring(2,4)));

            f1AT= (Integer.parseInt(getFormattedTime(f1,"arrival").substring(0,2))*60)
                    +(Integer.parseInt(getFormattedTime(f1,"arrival").substring(2,4)));

            /**
            calculate minute time values for flight f2
            minute time for HH:MM = (HH)*60 + (MM)
            */
            f2DT= (Integer.parseInt(getFormattedTime(f2,"departure").substring(0,2))*60)
                    +(Integer.parseInt(getFormattedTime(f2,"departure").substring(2,4)));

            f2AT= (Integer.parseInt(getFormattedTime(f2,"arrival").substring(0,2))*60)
                    +(Integer.parseInt(getFormattedTime(f2,"arrival").substring(2,4)));

            //Flight f1's duration when its arrival is on the next day of its departure
            if (f1AT<f1DT){
                //Duration = duration on departing day + duration on day of arrival
                //Duration = (24*60 - f1DT) + (f1AT - 0*60)
                f1Duration = (1440 - f1DT) + (f1AT);
            }
            //Flight f1's duration when its arrival and departure are on the same day
            else{
                f1Duration = f1AT-f1DT;
            }

            //Flight f2's duration when its arrival is on the next day of its departure
            if (f2AT<f2DT){
                //Duration = duration on departing day + duration on day of arrival
                //Duration = (24*60 - f1DT) + (f1AT - 0*60)
                f2Duration = (1440 - f2DT) + (f2AT);
            }
            //Flight f2's duration when its arrival and departure are on the same day
            else{
                f2Duration = f2AT-f2DT;
            }
            return f1Duration-f2Duration;
        };
        flightList.sort(compareByDuration);
    }

    /**
    Since some of the time values that are fetched from the database are of the format eg. 347 for 0347,
    we need to format these first, to properly sort by duration.
    */
    String getFormattedTime(Flight flight, String timeParameter){
        StringBuilder time = new StringBuilder();
        if(timeParameter.equals("arrival")){
            time = new StringBuilder(flight.getArrivalTime());
        }
        else if(timeParameter.equals("departure")){
            time = new StringBuilder(flight.getDepartureTime());
        }

        int zerosNeeded = 4-time.length();
        for(int i =0; i<zerosNeeded; i++){
            time.insert(0, "0");
        }
        return time.toString();
    }
}
