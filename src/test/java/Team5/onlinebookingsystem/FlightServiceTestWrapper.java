package Team5.onlinebookingsystem;

public class FlightServiceTestWrapper extends FlightService{

    public void SetRepository(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

}
