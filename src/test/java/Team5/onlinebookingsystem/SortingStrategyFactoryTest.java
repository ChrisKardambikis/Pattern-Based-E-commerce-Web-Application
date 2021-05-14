package Team5.onlinebookingsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SortingStrategyFactoryTest {

    @Test
    public void getInstanceTest(){
        // Act
        SortingStrategyFactory factory1 = SortingStrategyFactory.getInstance();
        SortingStrategyFactory factory2 = SortingStrategyFactory.getInstance();

        // Assert
        // both factories should be he same instance(singleton)
        // and the factory should be an instance of "SortingStrategyFactory"
        int factory1HashCode = factory1.hashCode();
        int factory2HashCode = factory2.hashCode();

        assertEquals(factory1HashCode, factory2HashCode);
        assertTrue(factory1 instanceof SortingStrategyFactory);
    }

    @Test
    public void getStrategyTest_SortByPriceAscending(){
        // Arrange
        SortingStrategyFactory factory = SortingStrategyFactory.getInstance();

        // Act
        SortingStrategy strategy1 = factory.getStrategy("Sort by Price Ascending");
        SortingStrategy strategy2 = factory.getStrategy("Sort by Price Ascending");

        // Assert
        int strategy1HashCode = strategy1.hashCode();
        int strategy2HashCode = strategy2.hashCode();
        assertEquals(strategy1HashCode, strategy2HashCode);
        assertTrue(strategy1 instanceof SortByPriceAscending);
    }

    @Test
    public void getStrategyTest_SortByPriceDescending(){
        // Arrange
        SortingStrategyFactory factory = SortingStrategyFactory.getInstance();

        // Act
        SortingStrategy strategy1 = factory.getStrategy("Sort by Price Descending");
        SortingStrategy strategy2 = factory.getStrategy("Sort by Price Descending");

        // Assert
        int strategy1HashCode = strategy1.hashCode();
        int strategy2HashCode = strategy2.hashCode();
        assertEquals(strategy1HashCode, strategy2HashCode);
        assertTrue(strategy1 instanceof SortByPriceDescending);
    }

    @Test
    public void getStrategyTest_SortByDepartureTimeAscending(){
        // Arrange
        SortingStrategyFactory factory = SortingStrategyFactory.getInstance();

        // Act
        SortingStrategy strategy1 = factory.getStrategy("Sort by Departure Time Ascending");
        SortingStrategy strategy2 = factory.getStrategy("Sort by Departure Time Ascending");

        // Assert
        int strategy1HashCode = strategy1.hashCode();
        int strategy2HashCode = strategy2.hashCode();
        assertEquals(strategy1HashCode, strategy2HashCode);
        assertTrue(strategy1 instanceof SortByDepartureTimeAscending);
    }

    @Test
    public void getStrategyTest_SortByDepartureTimeDescending(){
        // Arrange
        SortingStrategyFactory factory = SortingStrategyFactory.getInstance();

        // Act
        SortingStrategy strategy1 = factory.getStrategy("Sort by Departure Time Descending");
        SortingStrategy strategy2 = factory.getStrategy("Sort by Departure Time Descending");

        // Assert
        int strategy1HashCode = strategy1.hashCode();
        int strategy2HashCode = strategy2.hashCode();
        assertEquals(strategy1HashCode, strategy2HashCode);
        assertTrue(strategy1 instanceof SortByDepartureTimeDescending);
    }

    @Test
    public void getStrategyTest_SortByDuration(){
        // Arrange
        SortingStrategyFactory factory = SortingStrategyFactory.getInstance();

        // Act
        SortingStrategy strategy1 = factory.getStrategy("Sort by Duration");
        SortingStrategy strategy2 = factory.getStrategy("Sort by Duration");

        // Assert
        int strategy1HashCode = strategy1.hashCode();
        int strategy2HashCode = strategy2.hashCode();
        assertEquals(strategy1HashCode, strategy2HashCode);
        assertTrue(strategy1 instanceof SortByDuration);
    }

    @Test
    public void getStrategyTest_InvalidType(){
        // Arrange
        SortingStrategyFactory factory = SortingStrategyFactory.getInstance();

        // Act
        SortingStrategy strategy = factory.getStrategy("Sort by SOmething else");

        // Assert
        assertNull(strategy);
    }
}
