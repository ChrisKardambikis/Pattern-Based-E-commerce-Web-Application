package Team5.onlinebookingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MailingServiceTest {
    @Mock
    JavaMailSender mailSender;

    @InjectMocks
    MailingService mailingService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendEmailTest(){
        //  Arrange
        String customerName = "Charles Leclerc";
        String bookingRef = "1236543421";
        Long flightId = 3456L;
        String recipient = "address123@gmail.com";
        String flightOrigin = "Mumbai";
        String flightDepartureTime = "23";
        String flightDestination = "New York";
        String flightArrivalTime = "530";
        String date = "04/04/2021";

        Booking booking = Mockito.mock(Booking.class);
        Mockito.when(booking.getBookingRef()).thenReturn(bookingRef);
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(booking);
        bookingList.add(booking);

        Flight flight = Mockito.mock(Flight.class);
        Mockito.when(flight.getDepartureTime()).thenReturn(flightDepartureTime);
        Mockito.when(flight.getArrivalTime()).thenReturn(flightArrivalTime);
        Mockito.when(flight.getFrom()).thenReturn(flightOrigin);
        Mockito.when(flight.getTo()).thenReturn(flightDestination);
        Mockito.when(flight.getDate()).thenReturn(date);


        Ticket ticket = Mockito.mock(Ticket.class);
        ticket.flightId = flightId;
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);

        FlightService flightService = Mockito.mock(FlightService.class);
        Mockito.when(flightService.get(flightId)).thenReturn(flight);


        Mockito.doNothing().when(mailSender).send(any(SimpleMailMessage.class));

        //Act
        mailingService.sendConfirmationEmail(recipient,bookingList,customerName,flightService, ticketList);
        String message = mailingService.message;

        // Assert
        Mockito.verify(mailSender, times(1)).send(any(SimpleMailMessage.class));

        assertTrue(message.contains("Hi " + customerName));
        assertTrue(message.contains("Origin City: " + flightOrigin));
        assertTrue(message.contains("Destination City: " + flightDestination));
        assertTrue(message.contains("booking reference/s: " + bookingRef));
    }

    @Test
    void sendEmailTest_InvalidEmail(){
        //  Arrange
        String customerName = "Charles Leclerc";
        String bookingRef = "1236543421";
        Long flightId = 3456L;
        String recipient = "address123@gmail";
        String flightOrigin = "Mumbai";
        String flightDepartureTime = "23";
        String flightDestination = "New York";
        String flightArrivalTime = "530";
        String date = "04/04/2021";

        Booking booking = Mockito.mock(Booking.class);
        Mockito.when(booking.getBookingRef()).thenReturn(bookingRef);
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(booking);
        bookingList.add(booking);

        Flight flight = Mockito.mock(Flight.class);
        Mockito.when(flight.getDepartureTime()).thenReturn(flightDepartureTime);
        Mockito.when(flight.getArrivalTime()).thenReturn(flightArrivalTime);
        Mockito.when(flight.getFrom()).thenReturn(flightOrigin);
        Mockito.when(flight.getTo()).thenReturn(flightDestination);
        Mockito.when(flight.getDate()).thenReturn(date);


        Ticket ticket = Mockito.mock(Ticket.class);
        ticket.flightId = flightId;
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);

        FlightService flightService = Mockito.mock(FlightService.class);
        Mockito.when(flightService.get(flightId)).thenReturn(flight);


        Mockito.doNothing().when(mailSender).send(any(SimpleMailMessage.class));

        //Act
        mailingService.sendConfirmationEmail(recipient,bookingList,customerName,flightService, ticketList);

        // Assert
        Mockito.verify(mailSender, times(0)).send(any(SimpleMailMessage.class));
    }
}
