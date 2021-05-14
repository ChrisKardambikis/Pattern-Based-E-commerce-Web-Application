package Team5.onlinebookingsystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TicketDirectorTest {

    @Test
    void makeTicketTest(){
        // Arrange
        String seatClass = "Economy";
        String meal = "Vegan";
        String luggage = "3";
        String priceBought = "2506";
        String insurance = "yes";
        String ageGroup = "Adult";
        long flightID = 101L;
        String bookingRef = "Adult";
        Ticket ticket = Mockito.mock(Ticket.class);

        TicketBuilder ticketBuilder = Mockito.mock(TicketBuilder.class);
        Mockito.when(ticketBuilder.getTicket()).thenReturn(ticket);

        TicketService ticketService = Mockito.mock(TicketService.class);
        Mockito.when(ticketService.buildRandomTicketRef()).thenReturn(bookingRef);
        Mockito.when(ticketService.findByTicketRef(bookingRef)).thenReturn("yes").thenReturn("no");

        // Act
        TicketDirector ticketDirector = new TicketDirector();
        Ticket returnedTicket = ticketDirector.makeTicket(ticketBuilder,ticketService, seatClass, meal, luggage, priceBought,
                insurance, ageGroup, flightID);

        // Assert
        Mockito.verify(ticketBuilder, Mockito.times(1)).addBookingRef(bookingRef);
        Mockito.verify(ticketBuilder, Mockito.times(1)).addSeatClass(seatClass);
        Mockito.verify(ticketBuilder, Mockito.times(1)).addMeal(meal);
        Mockito.verify(ticketBuilder, Mockito.times(1)).addPriceBought(priceBought);
        Mockito.verify(ticketBuilder, Mockito.times(1)).addAgeGroup(ageGroup);
        Mockito.verify(ticketBuilder, Mockito.times(1)).addFlightId(flightID);
        Mockito.verify(ticketBuilder, Mockito.times(1)).addInsurance(insurance);
        Mockito.verify(ticketBuilder, Mockito.times(1)).addLuggage(luggage);

        assertEquals(ticket, returnedTicket);
    }
}
