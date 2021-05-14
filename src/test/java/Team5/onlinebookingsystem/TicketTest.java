package Team5.onlinebookingsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    public void toStringTest(){
        // Arrange
        String bookingRef = "BREF1245";
        long flightId = 108L;
        String seatClass = "Economy Class";
        String meal = "Vegan";
        String priceBought = "12";
        String luggage = "0";
        String insurance = "No";
        String ageGroup = "Adult";

        String expectedToString = "Ticket=" + "   bookinkRef:" + bookingRef +"    flightID" + flightId + "     sClass" + seatClass +"    meal"+ meal  +"   priceBought" +priceBought +"   luggage" + luggage+ "   insurace" + insurance+"   age"  +ageGroup;

        Ticket ticket = new Ticket();
        ticket.bookingRef = bookingRef;
        ticket.flightId = flightId;
        ticket.seatClass = seatClass;
        ticket.meal = meal;
        ticket.priceBought = priceBought;
        ticket.luggage = luggage;
        ticket.insurance = insurance;
        ticket.ageGroup = ageGroup;

        // Act
        String actualToString = ticket.toString();

        // Assert
        assertEquals(expectedToString, actualToString);
    }

}
