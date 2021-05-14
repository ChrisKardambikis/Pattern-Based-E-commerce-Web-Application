package Team5.onlinebookingsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Query to get all connecting flights with any/all dates
    @Query("select a from Customer a Where a.customerEmail like ?1 ")
    Customer findByEmail(String email);

}
