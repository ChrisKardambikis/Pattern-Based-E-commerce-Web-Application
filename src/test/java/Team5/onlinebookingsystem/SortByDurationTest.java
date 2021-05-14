package Team5.onlinebookingsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SortByDurationTest {

    @Test
    void getFormattedTimeTest(){
        // Arrange
        String arrivalTimeParameter = "arrival";
        String arrivalTime = "53";
        String expectedArrivalTime = "0053";

        String departureTimeParameter = "departure";
        String departureTime = "3";
        String expectedDepartureTime = "0003";

        Flight flight = mock(Flight.class);
        Mockito.when(flight.getArrivalTime()).thenReturn(arrivalTime);
        Mockito.when(flight.getDepartureTime()).thenReturn(departureTime);

        // Act
        SortByDuration sortByDuration = new SortByDuration();
        String formattedArrivalTime = sortByDuration.getFormattedTime(flight, arrivalTimeParameter);
        String formattedDepartureTime = sortByDuration.getFormattedTime(flight, departureTimeParameter);

        // Assert
        Assertions.assertEquals(expectedArrivalTime, formattedArrivalTime);
        Assertions.assertEquals(expectedDepartureTime, formattedDepartureTime);
    }

    @Test
    // Case1- When both flights depart and arrive on the same day.
    void sortTest_Case1(){
        // -----Arrange-----
        //Flight1's duration = 06:00 hours
        String departureTimeFlight1 = "0030";
        String arrivalTimeFlight1 = "0630";

        //Flight1's duration = 02:00 hours
        String departureTimeFlight2 = "0130";
        String arrivalTimeFlight2 = "0330";

        Flight flight1 = mock(Flight.class);
        Mockito.when(flight1.getArrivalTime()).thenReturn(arrivalTimeFlight1);
        Mockito.when(flight1.getDepartureTime()).thenReturn(departureTimeFlight1);

        Flight flight2 = mock(Flight.class);
        Mockito.when(flight2.getArrivalTime()).thenReturn(arrivalTimeFlight2);
        Mockito.when(flight2.getDepartureTime()).thenReturn(departureTimeFlight2);

        //Order of flights with their duration in unsorted list is:- Flight1 (06:00 hours), Flight2 (02:00 hours)
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);

        //Expected order of flights after sorting the list by duration is:- Flight2 (02:00 hours), Flight1 (06:00 hours)
        List<Flight> expectedList = new ArrayList<>();
        expectedList.add(flight2);
        expectedList.add(flight1);

        // -----Act-----
        SortByDuration sortByDuration = new SortByDuration();
        sortByDuration.sort(flightList);

        // -----Assert-----
        assertEquals(expectedList, flightList);
    }

    @Test
    void sortTest(){
        // -----Arrange-----
        //Flight1's duration = 06:00 hours
        String departureTimeFlight1 = "0030";
        String arrivalTimeFlight1 = "0630";

        //Flight1's duration = 02:00 hours
        String departureTimeFlight2 = "0130";
        String arrivalTimeFlight2 = "0330";

        Flight flight1 = mock(Flight.class);
        Mockito.when(flight1.getArrivalTime()).thenReturn(arrivalTimeFlight1);
        Mockito.when(flight1.getDepartureTime()).thenReturn(departureTimeFlight1);

        Flight flight2 = mock(Flight.class);
        Mockito.when(flight2.getArrivalTime()).thenReturn(arrivalTimeFlight2);
        Mockito.when(flight2.getDepartureTime()).thenReturn(departureTimeFlight2);

        //Order of flights with their duration in unsorted list is:- Flight1 (06:00 hours), Flight2 (02:00 hours)
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);

        //Expected order of flights after sorting the list by duration is:- Flight2 (02:00 hours), Flight1 (06:00 hours)
        List<Flight> expectedList = new ArrayList<>();
        expectedList.add(flight2);
        expectedList.add(flight1);

        // -----Act-----
        SortByDuration sortByDuration = new SortByDuration();
        sortByDuration.sort(flightList);

        // -----Assert-----
        assertEquals(expectedList, flightList);
    }

    @Test
    // Case2- When both flights arrive on the next day after they depart.
    void sortTest_Case2(){
        // -----Arrange-----
        //Flight1's duration = 12:00 hours
        String departureTimeFlight1 = "2330";
        String arrivalTimeFlight1 = "1130";

        //Flight1's duration = 07:00 hours
        String departureTimeFlight2 = "2230";
        String arrivalTimeFlight2 = "0530";

        Flight flight1 = mock(Flight.class);
        Mockito.when(flight1.getArrivalTime()).thenReturn(arrivalTimeFlight1);
        Mockito.when(flight1.getDepartureTime()).thenReturn(departureTimeFlight1);

        Flight flight2 = mock(Flight.class);
        Mockito.when(flight2.getArrivalTime()).thenReturn(arrivalTimeFlight2);
        Mockito.when(flight2.getDepartureTime()).thenReturn(departureTimeFlight2);

        //Order of flights with their duration in unsorted list is:- Flight1 (12:00 hours), Flight2 (07:00 hours)
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);

        //Expected order of flights after sorting the list by duration is:- Flight2 (07:00 hours), Flight1 (12:00 hours)
        List<Flight> expectedList = new ArrayList<>();
        expectedList.add(flight2);
        expectedList.add(flight1);

        // -----Act-----
        SortByDuration sortByDuration = new SortByDuration();
        sortByDuration.sort(flightList);

        // -----Assert-----
        assertEquals(expectedList, flightList);
    }
}
