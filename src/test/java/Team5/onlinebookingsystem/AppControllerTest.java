package Team5.onlinebookingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AppControllerTest {

    @Mock
    FlightService flightServiceMock;
    @Mock
    TicketService ticketService;
    @Mock
    CustomerService customerService;
    @Mock
    BookingService bookingService;

    @InjectMocks
    AppController appController;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void showSearchPageTest_ValidCase(){
        //Arrange
        Model model = Mockito.mock(Model.class);
        AppController controller = new AppController();
        String expectedResult = "SearchPage";

        //Act
        String page = controller.showSearchPage(model);

        //Assert
        verify(model, times(1)).addAttribute(any(String.class), any(Flight.class) );
        assertEquals(expectedResult, page);
    }

    @Test
    void showSearchPageTest_NullModelCase(){
        //Arrange
        AppController controller = new AppController();

        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> {
            controller.showSearchPage(null);
        });
        String actualMessage = exception.getMessage();
        String expectedMessage = "\"model\" is null";

        //Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void searchTest(){
        // Arrange
        Flight flight = mock(Flight.class);
        when(flight.getFrom()).thenReturn("Manchester");
        when(flight.getTo()).thenReturn("London");
        when(flight.getDate()).thenReturn("01/01/2022");
        when(flight.getAvailableSeats()).thenReturn(122L);

        Flight matchedFlightMock = mock(Flight.class);
        when(matchedFlightMock.getFrom()).thenReturn("success");
        List<Flight> flightList = new ArrayList<Flight>();
        flightList.add(matchedFlightMock);

        when(flightServiceMock.find(flight.getFrom(), flight.getTo(),
                flight.getDate(),flight.getAvailableSeats())).thenReturn(flightList);

        // Act
        ModelAndView mav = appController.search(flight);

        // Assert
        verify(flightServiceMock, times(1)).find(flight.getFrom(), flight.getTo(),
                flight.getDate(),flight.getAvailableSeats());
        assertEquals("Manchester", ((Flight)(mav.getModelMap().get("flightInfo"))).getFrom());
    }

    @Test
    void sortTest()
    {
        // Arrange
        String sortingMethod = "Sort by Price Ascending";

        Flight flight1 = mock(Flight.class);
        when(flight1.getFrom()).thenReturn("Manchester");
        when(flight1.getTo()).thenReturn("London");
        when(flight1.getDate()).thenReturn("01/01/2022");
        when(flight1.getAvailableSeats()).thenReturn(12L);
        Flight flight2 = mock(Flight.class);

        List<Flight> flightList =new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);

        List<Flight> sortedFlightList =new ArrayList<>();
        flightList.add(flight2);
        flightList.add(flight1);

        when(flightServiceMock.find(any(String.class), any(String.class), any(String.class),
                any(Long.class))).thenReturn(flightList);
        when(flightServiceMock.sort(any(SortingStrategy.class), any(List.class))).thenReturn(sortedFlightList);

        // Act
        ModelAndView mav = appController.sort(flight1, sortingMethod);

        // Assert
        verify(flightServiceMock, times(1)).find(any(String.class), any(String.class), any(String.class),
                any(Long.class));

        assertEquals(sortedFlightList, mav.getModelMap().get("matchedFlights"));
        assertEquals(flight1, mav.getModelMap().get("flightInfo"));
    }

    @Test
    void setOriginTest(){
        // Arrange
        String origin = "Origin=New+York";
        String expectedOrigin = "New York";
        String term = "New";

        // Act
        appController.setOrigin(origin);

        // Assert
        appController.townDestinationAirportNames(term);
        Mockito.verify(flightServiceMock, times(1)).fetchDestinationAirports(term,
                expectedOrigin);
    }

    @Test
    void townOriginAirportNamesTest(){
        // Arrange
        String term = "New";

        // Act
        appController.townOriginAirportNames(term);

        // Assert
        Mockito.verify(flightServiceMock, times(1)).fetchOriginAirports(term);
    }

    @Test
    void townDestinationAirportNamesTest(){
        // Arrange
        String origin = "Origin=Cape+Town";
        String actualOrigin = "Cape Town";
        String term = "Cape";
        appController.setOrigin(origin);

        // Act
        appController.townDestinationAirportNames(term);

        // Assert
        Mockito.verify(flightServiceMock, times(1)).fetchDestinationAirports(term, actualOrigin);
    }

    @Test
    public void selectedFlightIdTest(){
        // Arrange
        String id = "1237";
        Flight flight = mock(Flight.class);
        String expectedResult = "BuildTicket";

        Model model = mock(Model.class);
        when(flightServiceMock.fetchById(Long.parseLong(id))).thenReturn(flight);

        // Act
        String result = appController.selectedFlightId(id, model);

        //Assert
        verify(model, times(1)).addAttribute(any(String.class), any(List.class));
        verify(model, times(1)).addAttribute("flight", flight);
        verify(model, times(1)).addAttribute(any(String.class), any(String.class));
        assertEquals(expectedResult, result);
    }

    @Test
    void getBookingSearchPageTest()
    {
        // Arrange
        Model model = Mockito.mock(Model.class);

        // Act
        appController.getBookingSearchPage(model);

        // Assert
        Mockito.verify(model, times(1)).addAttribute(any(String.class), any(Ticket.class));
        Mockito.verify(model, times(1)).addAttribute(any(String.class), any(Flight.class));
    }

    @Test
    void showBookingSearchPageTest()
    {
        // Arrange
        Model model = Mockito.mock(Model.class);
        String bookingRef = "3287933454";
        String email = "emailme@gmail.com";
        Map<String, Boolean> validationData = new HashMap<>();
        validationData.put("wrongBookingRef", true);
        validationData.put("wrongEmail", true);

        Mockito.when(ticketService.getTicketInformationByRef(bookingRef)).thenReturn(mock(Ticket.class));
        Mockito.when(customerService.findByEmail(email)).thenReturn(mock(Customer.class));
        Mockito.when(flightServiceMock.validation(any(Ticket.class), any(Customer.class), any(boolean.class),
                any(boolean.class))).thenReturn(validationData);

        // Act
        appController.showBookingSearchPage(model, bookingRef, email);

        // Assert
        Mockito.verify(model, times(1)).addAttribute("bookingRef",bookingRef);
        Mockito.verify(model, times(1)).addAttribute("email",email);
    }

}
