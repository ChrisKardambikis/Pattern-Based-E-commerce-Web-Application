package Team5.onlinebookingsystem;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {
    private long id;
    private String flightNumber;
    private long availableSeats;
    private String from;
    private String to;
    private String departureTime;
    private String arrivalTime;
    private String date;
    private String price;

    public Flight(long id, String flightNumber, long availableSeats, String from, String to, String departureTime, String arrivalTime, String date, String price) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.availableSeats = availableSeats;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.date = date;
        this.price = price;
    }

    public Flight(String flightNumber, long availableSeats, String from, String to, String departureTime, String arrivalTime, String date, String price) {
        this.flightNumber = flightNumber;
        this.availableSeats = availableSeats;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.date = date;
        this.price = price;
    }

    public Flight(String from, String to, String date) {
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public Flight() {
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNo) {
        this.flightNumber = flightNo;
    }

    public long getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(long availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Id
    public Long getId() {
        return id;
    }
}
