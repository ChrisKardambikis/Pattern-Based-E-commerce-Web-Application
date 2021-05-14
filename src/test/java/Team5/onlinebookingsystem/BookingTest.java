package Team5.onlinebookingsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BookingTest {


    @Test
    // Case- public Booking(String customerEmail, String bookingRef, long id)
    void ConstructorTest_1(){
        // Arrange
        String customerEmail = "sendemail@gmail.com";
        String bookingRef = "BREF2354";
        long id = 587L;

        // Act
        Booking booking = new Booking(customerEmail, bookingRef, id);

        // Assert
        assertEquals(customerEmail, booking.getCustomerEmail());
        assertEquals(bookingRef, booking.getBookingRef());
        assertEquals(id, booking.getId());

    }

    @Test
    // Case- public Booking(String customerEmail, String bookingRef)
    void ConstructorTest_2(){
        // Arrange
        String customerEmail = "sendnewemail@gmail.com";
        String bookingRef = "BREF444";

        // Act
        Booking booking = new Booking(customerEmail, bookingRef);

        // Assert
        assertEquals(customerEmail, booking.getCustomerEmail());
        assertEquals(bookingRef, booking.getBookingRef());

    }

    @Test
    void customerEmailTest(){
        // Arrange
        String expectedEmail = "iambatman@email.com";
        Booking booking = new Booking();

        // Act
        booking.setCustomerEmail(expectedEmail);
        String actualEmail = booking.getCustomerEmail();

        // Assert
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    void bookingRefTest(){
        // Arrange
        String expectedBookingRef = "BREF007";
        Booking booking = new Booking();

        // Act
        booking.setBookingRef(expectedBookingRef);
        String actualBookingRef = booking.getBookingRef();

        // Assert
        assertEquals(expectedBookingRef, actualBookingRef);
    }

    @Test
    void IdTest(){
        // Arrange
        long expectedId = 333L;
        Booking booking = new Booking();

        // Act
        booking.setId(expectedId);
        long actualId = booking.getId();

        // Assert
        assertEquals(expectedId, actualId);
    }

}
