package Team5.onlinebookingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortByDepartureTimeTest {

    List<Flight> inputList = new ArrayList<Flight>();
    List<Flight> ascendingList = new ArrayList<Flight>();
    List<Flight> descendingList = new ArrayList<Flight>();

    @BeforeEach
    public void setup(){
        // Creating flight objects and stubbing their getDepartureTime() methods
        Flight flightObject1 = Mockito.mock(Flight.class);
        Mockito.when(flightObject1.getDepartureTime()).thenReturn("2000");
        Flight flightObject2 = Mockito.mock(Flight.class);
        Mockito.when(flightObject2.getDepartureTime()).thenReturn("2200");
        Flight flightObject3 = Mockito.mock(Flight.class);
        Mockito.when(flightObject3.getDepartureTime()).thenReturn("1100");

        // List of flights with random departure times order
        inputList.add(flightObject1);
        inputList.add(flightObject2);
        inputList.add(flightObject3);

        // Adding flights to the list in ascending order of departure times
        ascendingList.add(flightObject3);
        ascendingList.add(flightObject1);
        ascendingList.add(flightObject2);

        // Adding flights to the list in descending order of departure times
        descendingList.add(flightObject2);
        descendingList.add(flightObject1);
        descendingList.add(flightObject3);
    }

    @Test
    public void ascendingSortTest(){
        // Arrange
        SortingStrategyFactory factory = SortingStrategyFactory.getInstance();
        SortingStrategy strategy = factory.getStrategy("Sort by Departure Time Ascending");

        // Act
        strategy.sort(inputList);

        // Assert
        assertEquals(ascendingList, inputList);
    }

    @Test
    public void descendingSortTest(){
        // Arrange
        SortingStrategyFactory factory = SortingStrategyFactory.getInstance();
        SortingStrategy strategy = factory.getStrategy("Sort by Departure Time Descending");

        // Act
        strategy.sort(inputList);

        // Assert
        assertEquals(descendingList, inputList);
    }
}
