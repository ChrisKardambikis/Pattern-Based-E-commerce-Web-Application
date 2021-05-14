package Team5.onlinebookingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TicketServiceTest {

    Map<String, Object> setupObjects;

    @BeforeEach
    void getSetupObjects(){
        TicketRepository ticketRepository = Mockito.mock(TicketRepository.class);
        TicketServiceTestWrapper ticketService = new TicketServiceTestWrapper();
        ticketService.setTicketRepository(ticketRepository);

        setupObjects = new HashMap<String, Object>()
        {{
            put("ticketRepository", ticketRepository);
            put("ticketService", ticketService);
        }};
    }

    @Test
    void listAllTest(){
        // Arrange
        TicketRepository ticketRepository = (TicketRepository) setupObjects.get("ticketRepository");
        TicketServiceTestWrapper ticketService = (TicketServiceTestWrapper) setupObjects.get("ticketService");

        List<Ticket> ticketList = new ArrayList<>();
        Ticket ticket1 = Mockito.mock(Ticket.class);
        Ticket ticket2 = Mockito.mock(Ticket.class);
        ticketList.add(ticket1);
        ticketList.add(ticket2);

        Mockito.when(ticketRepository.findAll()).thenReturn(ticketList);

        // Act
        List<Ticket> allTickets = ticketService.listAll();

        // Assert
        Mockito.verify(ticketRepository, Mockito.times(1)).findAll();
        assertEquals(ticketList, allTickets);
    }

    @Test
    void saveTest(){
        // Arrange
        Ticket ticket = Mockito.mock(Ticket.class);

        TicketRepository ticketRepository = (TicketRepository) setupObjects.get("ticketRepository");
        TicketServiceTestWrapper ticketService = (TicketServiceTestWrapper) setupObjects.get("ticketService");

        // Act
        ticketService.save(ticket);

        // Assert
        Mockito.verify(ticketRepository, Mockito.times(1)).save(ticket);
    }

    @Test
    void getTest() {
        //Arrange
        long ticketId = 100L;
        Ticket ticket = Mockito.mock(Ticket.class);

        TicketRepository ticketRepository = (TicketRepository) setupObjects.get("ticketRepository");
        TicketServiceTestWrapper ticketService = (TicketServiceTestWrapper) setupObjects.get("ticketService");

        Mockito.when(ticketRepository.findById(ticketId)).thenReturn(java.util.Optional.ofNullable(ticket));

        // Act
        Ticket returnedTicket = ticketService.get(ticketId);

        // Assert
        verify(ticketRepository, times(1)).findById(ticketId);
        assertEquals(ticket, returnedTicket);
    }

    @Test
    void deleteTest() {
        long ticketId = 2345L;

        TicketRepository customerRepository = (TicketRepository) setupObjects.get("ticketRepository");
        TicketServiceTestWrapper ticketService = (TicketServiceTestWrapper) setupObjects.get("ticketService");

        Mockito.doNothing().when(customerRepository).deleteById(ticketId);

        // Act
        ticketService.delete(ticketId);

        // Assert
        verify(customerRepository, times(1)).deleteById(ticketId);
    }

    @Test
    // Case- match found
    void findByTicketTest_Case1() {
        //Arrange
        String expectedResult = "yes";
        String bookingRef = "BREF3290566732";
        Ticket ticket = Mockito.mock(Ticket.class);

        TicketRepository ticketRepository = (TicketRepository) setupObjects.get("ticketRepository");
        TicketServiceTestWrapper ticketService = (TicketServiceTestWrapper) setupObjects.get("ticketService");

        Mockito.when(ticketRepository.findByTicketRef(bookingRef)).thenReturn(ticket);

        // Act
        String searchResult = ticketService.findByTicketRef(bookingRef);

        // Assert
        verify(ticketRepository, times(1)).findByTicketRef(bookingRef);
        assertEquals(expectedResult, searchResult);
    }

    @Test
        // Case- no match found
    void findByTicketRefTest_Case2() {
        //Arrange
        String expectedResult = "no";
        String bookingRef = "BREF3290566732";

        TicketRepository ticketRepository = (TicketRepository) setupObjects.get("ticketRepository");
        TicketServiceTestWrapper ticketService = (TicketServiceTestWrapper) setupObjects.get("ticketService");

        Mockito.when(ticketRepository.findByTicketRef(bookingRef)).thenReturn(null);

        // Act
        String searchResult = ticketService.findByTicketRef(bookingRef);

        // Assert
        verify(ticketRepository, times(1)).findByTicketRef(bookingRef);
        assertEquals(expectedResult, searchResult);
    }

    @Test
    void getTicketInformationByRefTest(){
        // Arrange
        String bookingRef = "BREF548734853";
        Ticket ticket = Mockito.mock(Ticket.class);

        TicketRepository ticketRepository = (TicketRepository) setupObjects.get("ticketRepository");
        TicketServiceTestWrapper ticketService = (TicketServiceTestWrapper) setupObjects.get("ticketService");

        Mockito.when(ticketRepository.findByTicketRef(bookingRef)).thenReturn(ticket);

        // Act
        Ticket returnedTicket = ticketService.getTicketInformationByRef(bookingRef);

        // Assert
        verify(ticketRepository, times(1)).findByTicketRef(bookingRef);
        assertEquals(ticket, returnedTicket);
    }

    @Test
    void buildRandomTicketRefTest(){
        // Arrange
        TicketServiceTestWrapper ticketService = (TicketServiceTestWrapper) setupObjects.get("ticketService");

        // Act
        String bookingReference1 = ticketService.buildRandomTicketRef();
        String bookingReference2 = ticketService.buildRandomTicketRef();

        // Assert
        assertNotEquals(bookingReference1, bookingReference2);
    }
}
