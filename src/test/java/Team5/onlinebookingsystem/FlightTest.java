package Team5.onlinebookingsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    private void AssertFlightObject(Flight flight, Map<String, String> coreAttributes){
        assertEquals(coreAttributes.get("flight_No"),flight.getFlightNumber());
        assertEquals(Long.parseLong(coreAttributes.get("availableSeats")),flight.getAvailableSeats());
        assertEquals(coreAttributes.get("from"),flight.getFrom());
        assertEquals(coreAttributes.get("to"),flight.getTo());
        assertEquals(coreAttributes.get("departureTime"),flight.getDepartureTime());
        assertEquals(coreAttributes.get("arrivalTime"),flight.getArrivalTime());
        assertEquals(coreAttributes.get("date"),flight.getDate());
        assertEquals(coreAttributes.get("price"),flight.getPrice());
    }

    @Test
    void FlightConstructorTest(){
        //Arrange
        String flight_No = "1243";
        long availableSeats = 10l;
        String from = "London";
        String to = "Mumbai";
        String departureTime = "01:00";
        String arrivalTime = "12:00";
        String date = "01/01/2022";
        String price = "1200";
        Long id = 2000L;

        Map<String, String> coreAttributes = new HashMap<String, String>()
        {{
            put("flight_No", flight_No);put("from", from);put("to", to);put("availableSeats", String.valueOf(availableSeats));
            put("departureTime", departureTime);put("arrivalTime", arrivalTime);put("date", date);put("price", price);
        }};

        //Act
        Flight flight1 = new Flight(flight_No, availableSeats, from, to, departureTime, arrivalTime, date, price);
        Flight flight2 = new Flight(id, flight_No, availableSeats, from, to, departureTime, arrivalTime, date, price);

        //Assert
        AssertFlightObject(flight1, coreAttributes);

        AssertFlightObject(flight2, coreAttributes);
        assertEquals(id, flight2.getId());
    }

    @Test
    void FlightOverloadConstructorTest() {
        //Arrange
        String from = "Manchester";
        String to = "London";
        String date = "20/02/2022";

        //Act
        Flight flight = new Flight(from, to, date);

        //Assert
        assertEquals(from, flight.getFrom());
        assertEquals(to, flight.getTo());
        assertEquals(date, flight.getDate());
    }


    @Test
    @DisplayName("Price get and set Test")
    void PriceTest(){
        //Arrange
        String expectedPrice = "1000";

        //Act
        Flight flight = new Flight();
        flight.setPrice(expectedPrice);
        String actualPrice  = flight.getPrice();

        //Assert
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void FlightNumberTest(){
        //Arrange
        String expectedFlightNumber = "10001";

        //Act
        Flight flight = new Flight();
        flight.setFlightNumber(expectedFlightNumber);
        String actualFlightNumber  = flight.getFlightNumber();

        //Assert
        assertEquals(expectedFlightNumber, actualFlightNumber);
    }

    @Test
    void AvailableSeatsTest(){
        //Arrange
        long expectedSeats = 10l;

        //Act
        Flight flight = new Flight();
        flight.setAvailableSeats(expectedSeats);
        long actualSeat  = flight.getAvailableSeats();

        //Assert
        assertEquals(expectedSeats, actualSeat);
    }

    @Test
    void FromTest(){
        //Arrange
        String expectedFrom = "London";

        //Act
        Flight flight = new Flight();
        flight.setFrom(expectedFrom);
        String actualFrom  = flight.getFrom();

        //Assert
        assertEquals(expectedFrom, actualFrom);
    }

    @Test
    void ToTest(){
        //Arrange
        String expectedTo = "Rome";

        //Act
        Flight flight = new Flight();
        flight.setTo(expectedTo);
        String actualTo  = flight.getTo();

        //Assert
        assertEquals(expectedTo, actualTo);
    }

    @Test
    void DepartureTimeTest(){
        //Arrange
        String expectedTime = "00:00";

        //Act
        Flight flight = new Flight();
        flight.setDepartureTime(expectedTime);
        String actualTime  = flight.getDepartureTime();

        //Assert
        assertEquals(expectedTime, actualTime);
    }

    @Test
    void ArrivalTimeTest(){
        //Arrange
        String expectedTime = "23:00";

        //Act
        Flight flight = new Flight();
        flight.setArrivalTime(expectedTime);
        String actualTime  = flight.getArrivalTime();

        //Assert
        assertEquals(expectedTime, actualTime);
    }

    @Test
    void DateTest(){
        //Arrange
        String expectedDate = "31/12/2021";

        //Act
        Flight flight = new Flight();
        flight.setDate(expectedDate);
        String actualDate  = flight.getDate();

        //Assert
        assertEquals(expectedDate, actualDate);
    }

    @Test
    void IdTest(){
        //Arrange
        Long expectedId = +1111L;

        //Act
        Flight flight = new Flight();
        flight.setId(expectedId);
        Long actualId  = flight.getId();

        //Assert
        assertEquals(expectedId, actualId);
    }

}
