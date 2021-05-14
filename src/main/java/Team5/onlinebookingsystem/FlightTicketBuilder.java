package Team5.onlinebookingsystem;

public class FlightTicketBuilder implements TicketBuilder {

    private final Ticket ticket = new Ticket();

    @Override
    public void addBookingRef(String bookingRef) {
        ticket.bookingRef= bookingRef;
    }

    @Override
    public void addFlightId(long flightId) {
        ticket.flightId=flightId;
    }

    @Override
    public void addSeatClass(String seatClass) {
        ticket.seatClass=seatClass;
    }

    @Override
    public void addMeal(String meal) {
        ticket.meal=meal;
    }

    @Override
    public void addLuggage(String luggage) {
        ticket.luggage=luggage;
    }

    @Override
    public void addInsurance(String insurance) {
        ticket.insurance=insurance;
    }

    @Override
    public void addAgeGroup(String ageGroup) {
        ticket.ageGroup=ageGroup;
    }

    @Override
    public void addPriceBought(String priceBought){ ticket.priceBought=priceBought;}

    @Override
    public Ticket getTicket(){
        return ticket;
    }
}
