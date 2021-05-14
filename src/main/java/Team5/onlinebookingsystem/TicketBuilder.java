package Team5.onlinebookingsystem;

public interface TicketBuilder {
    void addBookingRef(String bookingRef);
    void addFlightId(long flightId);
    void addSeatClass(String seatClass);
    void addMeal(String meal);
    void addLuggage(String luggage);
    void addInsurance(String insurance);
    void addAgeGroup(String ageGroup);
    void addPriceBought(String priceBought);

    Ticket getTicket();
}
