package Team5.onlinebookingsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlightTicketBuilderTest {

    @Test
    void addBookingRefTest(){
        // Arrange
        String expectedBookingRef = "BRefSheep";
        FlightTicketBuilder flightTicketBuilder = new FlightTicketBuilder();

        // Act
        flightTicketBuilder.addBookingRef(expectedBookingRef);
        Ticket ticket = flightTicketBuilder.getTicket();

        // Assert
        assertEquals(expectedBookingRef, ticket.bookingRef);
    }

    @Test
    void addFlightIdTest(){
        // Arrange
        long expectedFlightId = 23234L;
        FlightTicketBuilder flightTicketBuilder = new FlightTicketBuilder();

        // Act
        flightTicketBuilder.addFlightId(expectedFlightId);
        Ticket ticket = flightTicketBuilder.getTicket();

        // Assert
        assertEquals(expectedFlightId, ticket.flightId);
    }

    @Test
    void addSeatClassTest(){
        // Arrange
        String expectedSeatClass = "Economy";
        FlightTicketBuilder flightTicketBuilder = new FlightTicketBuilder();

        // Act
        flightTicketBuilder.addSeatClass(expectedSeatClass);
        Ticket ticket = flightTicketBuilder.getTicket();

        // Assert
        assertEquals(expectedSeatClass, ticket.seatClass);
    }

    @Test
    void addMealTest(){
        // Arrange
        String expectedMeal = "Vegan";
        FlightTicketBuilder flightTicketBuilder = new FlightTicketBuilder();

        // Act
        flightTicketBuilder.addMeal(expectedMeal);
        Ticket ticket = flightTicketBuilder.getTicket();

        // Assert
        assertEquals(expectedMeal, ticket.meal);
    }

    @Test
    void addLuggageTest(){
        // Arrange
        String expectedLuggage = "2";
        FlightTicketBuilder flightTicketBuilder = new FlightTicketBuilder();

        // Act
        flightTicketBuilder.addLuggage(expectedLuggage);
        Ticket ticket = flightTicketBuilder.getTicket();

        // Assert
        assertEquals(expectedLuggage, ticket.luggage);
    }

    @Test
    void addInsuranceTest(){
        // Arrange
        String expectedInsurance = "Yes";
        FlightTicketBuilder flightTicketBuilder = new FlightTicketBuilder();

        // Act
        flightTicketBuilder.addInsurance(expectedInsurance);
        Ticket ticket = flightTicketBuilder.getTicket();

        // Assert
        assertEquals(expectedInsurance, ticket.insurance);
    }

    @Test
    void addAgeGroupTest(){
        // Arrange
        String expectedAgeGroup = "Adult";
        FlightTicketBuilder flightTicketBuilder = new FlightTicketBuilder();

        // Act
        flightTicketBuilder.addAgeGroup(expectedAgeGroup);
        Ticket ticket = flightTicketBuilder.getTicket();

        // Assert
        assertEquals(expectedAgeGroup, ticket.ageGroup);
    }

    @Test
    void addPriceBoughtTest(){
        // Arrange
        String expectedPriceBought = "1500";
        FlightTicketBuilder flightTicketBuilder = new FlightTicketBuilder();

        // Act
        flightTicketBuilder.addPriceBought(expectedPriceBought);
        Ticket ticket = flightTicketBuilder.getTicket();

        // Assert
        assertEquals(expectedPriceBought, ticket.priceBought);
    }

    @Test
    void getTicketTest(){
        // Arrange
        String expectedMeal = "Vegan";
        FlightTicketBuilder flightTicketBuilder = new FlightTicketBuilder();

        // Act
        flightTicketBuilder.addMeal(expectedMeal);
        Object ticket = flightTicketBuilder.getTicket();

        // Assert
        assertNotNull(ticket);
        assertTrue(ticket instanceof Ticket);
        assertEquals(expectedMeal, ((Ticket)ticket).meal);
    }
}
