package Team5.onlinebookingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;


@Service
@Transactional
public class TicketService {

        @Autowired
        protected TicketRepository ticketRepository;

        public List<Ticket> listAll() {
            return ticketRepository.findAll();
        }

        public void save(Ticket ticket) {
            ticketRepository.save(ticket);
        }

        public Ticket get(long id) {
            return ticketRepository.findById(id).get();
        }

        public void delete(long id) {
            ticketRepository.deleteById(id);
        }

        public String findByTicketRef(String ref){
            Ticket ticket =  ticketRepository.findByTicketRef(ref);
            if (ticket == null) {
                return "no";
            }
            return "yes";
        }

        public Ticket getTicketInformationByRef(String ref){
            return ticketRepository.findByTicketRef(ref);
        }


        public String buildRandomTicketRef(){
            Random rand = new Random();
            StringBuilder randBookingReference = new StringBuilder();
            for(int i=0;i<10;i++){
                randBookingReference.append(rand.nextInt(10));
            }
            return randBookingReference.toString();
        }

}
