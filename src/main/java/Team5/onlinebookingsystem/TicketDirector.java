package Team5.onlinebookingsystem;


public class TicketDirector {


    Ticket makeTicket(TicketBuilder ticketBuilder, TicketService ticketService, String seatClass, String meal, String luggage, String priceBought, String insurance, String ageGroup, long flightID){

        // building new random, non existing(unique) bookingRef
        String bookingRef = ticketService.buildRandomTicketRef();
        while (ticketService.findByTicketRef(bookingRef).equals("yes")) {
            bookingRef = ticketService.buildRandomTicketRef();
        }

        //adding mandatory parameters
        ticketBuilder.addBookingRef(bookingRef);
        ticketBuilder.addSeatClass(seatClass);
        ticketBuilder.addMeal(meal);
        ticketBuilder.addPriceBought(priceBought);
        ticketBuilder.addAgeGroup(ageGroup);
        ticketBuilder.addFlightId(flightID);

        //adding optional parameters
        if (insurance.equals("yes")) {
            ticketBuilder.addInsurance(insurance);
        }
        if (!"".equals(luggage) && !"0".equals(luggage)) {
            ticketBuilder.addLuggage(luggage);
        }

        return ticketBuilder.getTicket();
    }
}
