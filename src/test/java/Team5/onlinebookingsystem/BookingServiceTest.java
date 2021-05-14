package Team5.onlinebookingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BookingServiceTest {

    Map<String, Object> setupObjects;

    @BeforeEach
    public void getSetupObjects(){
        BookingRepository bookingRepository = Mockito.mock(BookingRepository.class);
        BookingServiceTestWrapper bookingService = new BookingServiceTestWrapper();
        bookingService.setBookingRepository(bookingRepository);

        Map<String, Object> createdObjects = new HashMap<String, Object>()
        {{
            put("bookingRepository", bookingRepository);
            put("bookingService", bookingService);
        }};

        setupObjects = createdObjects;
    }

    @Test
    public void listAllTest(){
        // Arrange
        BookingRepository bookingRepository = (BookingRepository) setupObjects.get("bookingRepository");
        BookingServiceTestWrapper bookingService = (BookingServiceTestWrapper) setupObjects.get("bookingService");

        List<Booking> expectedBookingsList = new ArrayList<Booking>();
        Booking booking1 = Mockito.mock(Booking.class);
        Booking booking2 = Mockito.mock(Booking.class);
        expectedBookingsList.add(booking1);
        expectedBookingsList.add(booking2);

        Mockito.when(bookingRepository.findAll()).thenReturn(expectedBookingsList);

        // Act
        List<Booking> allBookings = bookingService.listAll();

        // Assert
        Mockito.verify(bookingRepository, Mockito.times(1)).findAll();
        assertEquals(expectedBookingsList, allBookings);

    }

    @Test
    public void saveTest(){
        // Arrange
        Booking booking = Mockito.mock(Booking.class);

        BookingRepository bookingRepository = (BookingRepository) setupObjects.get("bookingRepository");
        BookingServiceTestWrapper bookingService = (BookingServiceTestWrapper) setupObjects.get("bookingService");

        // Act
        bookingService.save(booking);

        // Assert
        Mockito.verify(bookingRepository, Mockito.times(1)).save(booking);
    }

    @Test
    void getTest() {
        //Arrange
        long bookingId = 100l;
        Booking expectedBooking = Mockito.mock(Booking.class);

        BookingRepository bookingRepository = (BookingRepository) setupObjects.get("bookingRepository");
        BookingServiceTestWrapper bookingService = (BookingServiceTestWrapper) setupObjects.get("bookingService");

        Mockito.when(bookingRepository.findById(bookingId)).thenReturn(java.util.Optional.ofNullable(expectedBooking));

        // Act
        Booking actualBooking = bookingService.get(bookingId);

        // Assert
        verify(bookingRepository, times(1)).findById(bookingId);
        assertEquals(expectedBooking, actualBooking);
    }

    @Test
    void deleteTest() {
        long bookingId = 101l;

        BookingRepository bookingRepository = (BookingRepository) setupObjects.get("bookingRepository");
        BookingServiceTestWrapper bookingService = (BookingServiceTestWrapper) setupObjects.get("bookingService");

        Mockito.doNothing().when(bookingRepository).deleteById(bookingId);

        // Act
        bookingService.delete(bookingId);

        // Assert
        verify(bookingRepository, times(1)).deleteById(bookingId);
    }

    @Test
    void validateTest_positiveCase() {
        String enteredEmail = "email@gmail.com";
        String enteredBookingRef = "BREF1267";
        Booking booking = Mockito.mock(Booking.class);
        boolean expectedValidation = true;

        BookingRepository bookingRepository = (BookingRepository) setupObjects.get("bookingRepository");
        BookingServiceTestWrapper bookingService = (BookingServiceTestWrapper) setupObjects.get("bookingService");

        Mockito.when(bookingRepository.validation(enteredEmail, enteredBookingRef)).thenReturn(booking);

        // Act
        boolean validationResult = bookingService.validate(enteredEmail, enteredBookingRef);

        // Assert
        Mockito.verify(bookingRepository, times(1)).validation(enteredEmail, enteredBookingRef);
        assertEquals(expectedValidation, validationResult);
    }

    @Test
    void validateTest_negativeCase() {
        String enteredEmail = "email@gmail.com";
        String enteredBookingRef = "BREF1267";
        boolean expectedValidation = false;

        BookingRepository bookingRepository = (BookingRepository) setupObjects.get("bookingRepository");
        BookingServiceTestWrapper bookingService = (BookingServiceTestWrapper) setupObjects.get("bookingService");

        Mockito.when(bookingRepository.validation(enteredEmail, enteredBookingRef)).thenReturn(null);

        // Act
        boolean validationResult = bookingService.validate(enteredEmail, enteredBookingRef);

        // Assert
        Mockito.verify(bookingRepository, times(1)).validation(enteredEmail, enteredBookingRef);
        assertEquals(expectedValidation, validationResult);
    }

}
