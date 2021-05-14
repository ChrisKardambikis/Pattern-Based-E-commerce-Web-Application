package Team5.onlinebookingsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
    private String customerEmail;
    private String bookingRef;
    private long id;

    public Booking(String customerEmail, String bookingRef, long id) {
        this.customerEmail = customerEmail;
        this.bookingRef = bookingRef;
        this.id = id;
    }

    public Booking(String customerEmail, String bookingRef) {
        this.customerEmail = customerEmail;
        this.bookingRef = bookingRef;
    }

    public Booking() {

    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
