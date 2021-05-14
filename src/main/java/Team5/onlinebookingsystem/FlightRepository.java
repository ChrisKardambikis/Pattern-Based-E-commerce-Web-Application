package Team5.onlinebookingsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

//    // Query to get all connecting flights by id
    @Query("select a from Flight a Where a.id = ?1")
    List<Flight> getFlightById(long id);

    // Query to get all connecting flights
    @Query("select a from Flight a Where a.availableSeats >= ?3 and a.from LIKE ?1 and a.date LIKE ?2 " )
    List<Flight> getAllConnectingFlights(String from, String date, long tickets);

    // Query to get all connecting flights with any/all dates
    @Query("select a from Flight a Where a.availableSeats >= ?2 and a.from LIKE ?1")
    List<Flight> getAllConnectingFlightsAllDates(String from, long tickets);

    // Query to get all flights with any/all dates
    @Query("select a from Flight a Where a.availableSeats >= ?3 and a.from LIKE ?1 and a.to LIKE ?2")
    List<Flight> getFlightsAllDates(String from, String to, long tickets);

    //    Query to return all flights where from starts with the keyword
    @Query("select a from Flight a Where a.from LIKE ?1%")
    List<Flight> findByOrigin(String keyword);

    //    Query to return all flights where to starts with the keyword
    @Query("select a from Flight a Where a.to LIKE ?1% and a.from LIKE ?2")
    List<Flight> findByDestination(String keyword, String origin);

    // Query to updated seats by id
    @Modifying
    @Query("update Flight a set a.availableSeats=?1 where a.id=?2")
    void updateSeats(long seats, long id);

}
