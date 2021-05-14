package Team5.onlinebookingsystem;

public class TicketServiceTestWrapper extends TicketService {

    public void setTicketRepository (TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }
}
