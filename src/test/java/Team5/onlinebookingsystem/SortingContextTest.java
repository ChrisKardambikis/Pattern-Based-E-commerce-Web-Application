package Team5.onlinebookingsystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SortingContextTest {

    public static SortingStrategy[] data(){
        SortingStrategy strategy = Mockito.mock(SortingStrategy.class);
        return new SortingStrategy[]{strategy, null};
    }

    @ParameterizedTest
    @MethodSource(value =  "data")
    void sortingStrategyParameterisedTest(SortingStrategy data){
        //Arrange
        SortingContext context = new SortingContext();

        //Act
        context.setStrategy(data);
        SortingStrategy actualStrategy = context.getStrategy();

        //Assert
        assertEquals(data, actualStrategy);
    }

    @Test
    void sortingStrategyStrategyTest(){
        //Arrange
        SortingStrategy strategy = Mockito.mock(SortingStrategy.class);
        SortingContext context = new SortingContext();

        //Act
        context.setStrategy(strategy);
        SortingStrategy actualStrategy = context.getStrategy();

        //Assert
        assertEquals(strategy, actualStrategy);
    }

    @Test
    void sortingStrategyTest_NullCase(){
        //Arrange
        SortingContext context = new SortingContext();

        //Act
        context.setStrategy(null);
        SortingStrategy actualStrategy = context.getStrategy();

        //Assert
        assertEquals(null, actualStrategy);
    }

    @Test
    void sortFlightsTest(){
        // Arrange
        List<Flight> flightListList = new ArrayList<Flight>();
        Flight flightObject1 = Mockito.mock(Flight.class);
        flightListList.add(flightObject1);

        SortingStrategy strategy = Mockito.mock(SortingStrategy.class);
        SortingContext context = new SortingContext();
        context.setStrategy(strategy);

        Mockito.doNothing().when(strategy).sort(flightListList);

        // Act
        context.sortFlights(flightListList);

        // Assert
        verify(strategy, times(1)).sort(any( List.class));
    }
}
