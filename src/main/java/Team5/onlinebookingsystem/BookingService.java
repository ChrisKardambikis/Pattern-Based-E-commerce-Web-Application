package Team5.onlinebookingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingService {

    @Autowired
    protected BookingRepository bookingRepository;

    public List<Booking> listAll() {
        return bookingRepository.findAll();
    }

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    public Booking get(long id) {
        return bookingRepository.findById(id).get();
    }

    public void delete(long id) {
        bookingRepository.deleteById(id);
    }

    public boolean validate(String email,String bookingRef){
        Booking book = bookingRepository.validation(email, bookingRef);
        return (book != null);
    }
}
