package Team5.onlinebookingsystem;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {
    @Id
    public String bookingRef;
    public long flightId;
    public String seatClass;
    public String meal;
    public String priceBought;
    public String luggage;
    public String insurance;
    public String ageGroup;

   @Override
    public String toString(){
       return "Ticket=" + "   bookinkRef:" + bookingRef +"    flightID" + flightId + "     sClass" + seatClass +"    meal"+ meal  +"   priceBought" +priceBought +"   luggage" + luggage+ "   insurace" + insurance+"   age"  +ageGroup;
   }
}
