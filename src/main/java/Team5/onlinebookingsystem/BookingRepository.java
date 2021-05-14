package Team5.onlinebookingsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Query to get all connecting flights with any/all dates
    @Query("select a from Booking a Where a.customerEmail like ?1 and a.bookingRef LIKE ?2")
    Booking validation(String email, String bookingRef);
}
