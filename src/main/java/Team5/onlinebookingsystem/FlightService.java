package Team5.onlinebookingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
class FlightService {

    @Autowired
    protected FlightRepository flightRepository;

    private static SortingContext sortingContext;

    public List<Flight> listAll() {
        return flightRepository.findAll();
    }

    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    public Flight get(long id) {
        return flightRepository.findById(id).get();
    }

    public void delete(long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> find(String from, String to, String date, long tickets){
        List<Flight> matchedFlights = new ArrayList<>();
        if(to.equals("anywhere") ){
            List<Flight> allFlights;
            if(date.equals("alldates")){
                allFlights = flightRepository.getAllConnectingFlightsAllDates(from, tickets);
            }else{
                allFlights = flightRepository.getAllConnectingFlights(from, date, tickets);
            }
            matchedFlights.addAll(allFlights);
        }else if(date.equals("alldates")){
            List<Flight> allFlights = flightRepository.getFlightsAllDates(from,to,tickets);
            matchedFlights.addAll(allFlights);
        }else{
            List<Flight> allFlights = listAll();
            for (Flight allFlight : allFlights) {
                if (allFlight.getFrom().equals(from) && allFlight.getTo().equals(to) && allFlight.getDate().equals(date) && allFlight.getAvailableSeats() >= tickets) {
                    matchedFlights.add(allFlight);
                }
            }
        }
        matchedFlights.removeIf(flightEntry -> flightEntry.getDepartureTime().equals("NA"));
        matchedFlights.removeIf(flightEntry -> flightEntry.getPrice().equals("NA"));
        return matchedFlights;
    }

    public List<Flight> sort(SortingStrategy sortingStrategy, List<Flight> flightList) {
        if(sortingContext == null){
            sortingContext = new SortingContext();
        }
        sortingContext.setStrategy(sortingStrategy);
        sortingContext.sortFlights(flightList);
        return flightList;
    }
//    Service for fetching airport-city names -- ck
    public List<String> fetchOriginAirports(String keyword){
        List<Flight> listOfFlightsFromKeyword = flightRepository.findByOrigin(keyword);
        List<String> suggestions = new ArrayList<>();
        for (Flight listOfAirport : listOfFlightsFromKeyword) {
            suggestions.add(listOfAirport.getFrom());
        }
        Set<String> uniqueAirports = new HashSet<>(suggestions);
        return new ArrayList<>(uniqueAirports);
    }

    //    Service for fetching airport-city names -- ck
    public List<String> fetchDestinationAirports(String keyword,String origin){
        List<Flight> listOfMatchedFlights = flightRepository.findByDestination(keyword,origin);
        List<String> suggestions = new ArrayList<>();

        for (Flight listOfAirport : listOfMatchedFlights) {
            suggestions.add(listOfAirport.getTo());
        }
        Set<String> uniqueAirports = new HashSet<>(suggestions);
        return new ArrayList<>(uniqueAirports);
    }

    //    Service for fetching the flight information by ID -- ck
    public Flight fetchById(long id){
        List<Flight> theFlight;
        theFlight = flightRepository.getFlightById(id);
        if (theFlight.isEmpty()) {
            return null;
        }
        return theFlight.get(0);
    }

    public void decreaseCapacity(long id, long decrementValue) {
        Flight flight = get(id);
        long seats = flight.getAvailableSeats()-decrementValue ;
        flightRepository.updateSeats(seats,id);
    }

    public  Map<String, Boolean> validation(Ticket ticketInfo, Customer customerInfo,
                                     boolean wrongBookingRef, boolean wrongEmail){
        Map<String, Boolean> validationData = new HashMap<>();

        if(ticketInfo==null){
            wrongBookingRef=true;
        }
        if(customerInfo==null){
            wrongEmail=true;
        }
        validationData.put("wrongBookingRef", wrongBookingRef);
        validationData.put("wrongEmail", wrongEmail);
        return validationData;
    }
    public Flight getFlightInfoIfTicketExists(Ticket ticketInfo){
        if(ticketInfo==null){
            return null;
        }else{
            return this.fetchById(ticketInfo.flightId);
        }
    }

}
