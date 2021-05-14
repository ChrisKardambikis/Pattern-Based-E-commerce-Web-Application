package Team5.onlinebookingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SortByPriceTest {

    List<Flight> unsortedList = new ArrayList<Flight>();
    List<Flight> descendingList = new ArrayList<Flight>();
    List<Flight> ascendingList = new ArrayList<Flight>();

    @BeforeEach
    void setUp() throws Exception {
        Flight flightObject1 = Mockito.mock(Flight.class);
        when(flightObject1.getPrice()).thenReturn("1300");

        Flight flightObject2 = Mockito.mock(Flight.class);
        when(flightObject2.getPrice()).thenReturn("4000");

        Flight flightObject3 = Mockito.mock(Flight.class);
        when(flightObject3.getPrice()).thenReturn("900");

        Flight flightObject4 = Mockito.mock(Flight.class);
        when(flightObject4.getPrice()).thenReturn("50000");

        // Populating the unsorted list
        unsortedList.add(flightObject1);
        unsortedList.add(flightObject2);
        unsortedList.add(flightObject3);
        unsortedList.add(flightObject4);

        // Adding elements to have a list sorted in descending order
        descendingList.add(flightObject4);
        descendingList.add(flightObject2);
        descendingList.add(flightObject1);
        descendingList.add(flightObject3);

        // Adding elements to have a list sorted in ascending order
        ascendingList.add(flightObject3);
        ascendingList.add(flightObject1);
        ascendingList.add(flightObject2);
        ascendingList.add(flightObject4);
    }

    @Test
    void descendingSortTest(){
        //Arrange
        SortByPriceDescending sortDescending = new SortByPriceDescending();

        //Act
        sortDescending.sort(unsortedList);

        //Assert
        assertEquals(descendingList, unsortedList);
    }

    @Test
    void ascendingSortTest(){
        //Arrange
        SortByPriceAscending sortAscending = new SortByPriceAscending();

        //Act
        sortAscending.sort(unsortedList);

        //Assert
        assertEquals(ascendingList, unsortedList);
    }

}
