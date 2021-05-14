package Team5.onlinebookingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailingService {

    @Autowired
    private JavaMailSender mailSender;

    String subject;
    String message;
    
    // As per naming rules by Oracle, constants must follow the convention like "MIN_WIDTH"
    // Email address of thr company's mailbox, from where the confirmations are sent.
    private static final String MAIL_FROM = "boookflights@gmail.com";

    // The set of common instructions and guidelines that are to be sent with each email confirmation.
    private static final String COMMON_MESSAGE = "Some General Instructions to keep in mind:\n" +
                "•       Check-in Time : Check-in desks will close 1 hour before departure.\n" +
                "•       Valid ID proof needed : Carry a valid photo identification proof (Driving Licence, Passport " +
                "or any other Government recognised photo identification)\n" +
                "•       Web Check-in (opens 48 hrs. before departure): Use Booking Reference and full name to check-in.\n" +
                "•       Visa and Passports : If you journey is international, you are required to hold a valid passport" +
                " and visa. Some countries won’t let you in without a valid visa, so double-check any visa requirements " +
                "before you leave.\n" +
                "\n" +
                "Pre-Flight Travel Checklist During Covid:\n" +
                "•       Face mask : All passengers need to wear a face mask in all public spaces throughout " +
                "your journey. \n" +
                "•       Negative COVID-19 Test  :  Passengers are required to provide a negative COVID-19 test result" +
                " before you can board a flight, which cannot be older than 72 hours from the departure time.\n" +
                "•       Health Declaration Form  :  It is a declaration that you do not have any symptoms of COVID-19" +
                " to the best of your knowledge. Passengers are required to fill in and submit this form online and also" +
                " carry a hard copy of the document.\n" +
                "•       Travel Permit : If you are travelling to a state that doesn’t permit non-essential travel due" +
                " to the coronavirus, you will most likely need to get a travel permit from the border control to enter" +
                " the state, regardless of the nature of your travel. Make sure to check the border restrictions of both" +
                " your own state and your destination state.\n" +
                "\n" +
                "We wish you a safe and a comfortable journey.\n" +
                "\n" +
                "Thank you for choosing us,\n" +
                "Team Fly Away";

    public void sendConfirmationEmail(String recipient, List<Booking> bookingList, String customerName,
                                      FlightService flightService, List<Ticket> ticketList) {
        if(!isValid(recipient)){
            return;
        }
        this.composeMailBody(bookingList, customerName, flightService, ticketList);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(MAIL_FROM);
        simpleMailMessage.setTo(recipient);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message + COMMON_MESSAGE);

        mailSender.send(simpleMailMessage);
    }

    private void composeMailBody(List<Booking> bookingList, String customerName, FlightService flightService,
                                 List<Ticket> ticketList){
        StringBuilder bookingReferences = new StringBuilder();

        for(int i =0 ; i< bookingList.size(); i++){
            if(i!= bookingList.size()-1){
                bookingReferences.append(bookingList.get(i).getBookingRef()).append(", ");
            }
            else{
                bookingReferences.append(bookingList.get(i).getBookingRef()).append(".");
            }
        }
        Flight bookedFlight = (flightService.get(ticketList.get(0).flightId));
        String source = bookedFlight.getFrom();
        String destination = bookedFlight.getTo();
        String dateOfJourney = bookedFlight.getDate();
        String passengers = String.valueOf(ticketList.size());

        subject = "Confirmation of your flight booking from " + source +" to " + destination;
        message = "Hi " + customerName + ",\n\nWe are glad to inform you that your booking of " + passengers +
                " flight tickets from " + source + " to " + destination + " on " + dateOfJourney + " has been successfully " +
                "confirmed with booking reference/s: " + bookingReferences + "\n\n" +
                "Your booking details are:" +
                "\n•\tDate of Journey: " + dateOfJourney +
                "\n•\tNumber of Passengers: " + passengers +
                "\n•\tFlight Number: " + bookedFlight.getFlightNumber() +
                "\n•\tOrigin City: " + bookedFlight.getFrom() +
                "\n•\tDeparture Time: " + formatTime(bookedFlight.getDepartureTime()) +
                "\n•\tDestination City: " + bookedFlight.getTo() +
                "\n•\tArrival Time: " + formatTime(bookedFlight.getArrivalTime()) +
                "\n\n";
    }

    /*
    Since some of the time values that are fetched from the database are of the format eg. 347 for 03:47,
    32 for 00:32, to properly display the times in the email, we need to format these first.
    */
    private String formatTime(String time){
        StringBuilder formattedTime = new StringBuilder(time);

        int zerosNeeded = 4-time.length();
        for(int i =0; i<zerosNeeded; i++){
            formattedTime.insert(0, "0");
        }
        formattedTime.insert(2, ":");
        return formattedTime.toString();
    }

    private boolean isValid(String email) {
        // Regular expression for validating email
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
