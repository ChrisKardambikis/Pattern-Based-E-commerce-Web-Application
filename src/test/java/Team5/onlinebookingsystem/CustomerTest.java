package Team5.onlinebookingsystem;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private void AssertCustomerObject(Customer customer, Map<String, String> coreAttributes){
        assertEquals(coreAttributes.get("customerEmail"),customer.getCustomerEmail());
        assertEquals(coreAttributes.get("fullName"),customer.getFullName());
        assertEquals(coreAttributes.get("address1"),customer.getAddress1());
        assertEquals(coreAttributes.get("address2"),customer.getAddress2());
        assertEquals(coreAttributes.get("city"),customer.getCity());
        assertEquals(coreAttributes.get("county"),customer.getCounty());
        assertEquals(coreAttributes.get("postalCode"),customer.getPostalCode());
    }

    @Test
    void FlightConstructorTest(){
        //Arrange
        String customerEmail = "happycustomer@customers.com";
        String fullName = "Lando Sainz";
        String address1 = "#007";
        String address2 = "Bond Street";
        String city = "London";
        String county = "London";
        String postalCode = "L139WJ";

        Map<String, String> coreAttributes = new HashMap<String, String>()
        {{
            put("customerEmail", customerEmail);put("fullName", fullName);put("address1", address1);put("address2", address2);
            put("city", city);put("county", county);put("postalCode", postalCode);
        }};

        //Act
        Customer customer = new Customer(customerEmail, fullName, address1, address2, city, county, postalCode);

        //Assert
        AssertCustomerObject(customer, coreAttributes);
    }

    @Test
    void customerEmailTest(){
        //Arrange
        String expectedCustomerEmail = "customer@flightbooking.com";

        //Act
        Customer customer = new Customer();
        customer.setCustomerEmail(expectedCustomerEmail);
        String actualCustomerEmail  = customer.getCustomerEmail();

        //Assert
        assertEquals(expectedCustomerEmail, actualCustomerEmail);
    }

    @Test
    void fullNameTest(){
        //Arrange
        String expectedFullName = "Roger Tsitsipas";

        //Act
        Customer customer = new Customer();
        customer.setFullName(expectedFullName);
        String actualFullName  = customer.getFullName();

        //Assert
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void address1Test(){
        //Arrange
        String expectedAddress1 = "#001";

        //Act
        Customer customer = new Customer();
        customer.setAddress1(expectedAddress1);
        String actualAddress1  = customer.getAddress1();

        //Assert
        assertEquals(expectedAddress1, actualAddress1);
    }

    @Test
    void address2Test(){
        //Arrange
        String expectedAddress2 = "Oxford Road";

        //Act
        Customer customer = new Customer();
        customer.setAddress2(expectedAddress2);
        String actualAddress2  = customer.getAddress2();

        //Assert
        assertEquals(expectedAddress2, actualAddress2);
    }

    @Test
    void cityTest(){
        //Arrange
        String expectedCity = "Miami";

        //Act
        Customer customer = new Customer();
        customer.setCity(expectedCity);
        String actualCity  = customer.getCity();

        //Assert
        assertEquals(expectedCity, actualCity);
    }

    @Test
    void countyTest(){
        //Arrange
        String expectedCounty = "Some County";

        //Act
        Customer customer = new Customer();
        customer.setCounty(expectedCounty);
        String actualCounty  = customer.getCounty();

        //Assert
        assertEquals(expectedCounty, actualCounty);
    }

    @Test
    void postalCodeTest(){
        //Arrange
        String expectedPostalCode = "MV1234";

        //Act
        Customer customer = new Customer();
        customer.setPostalCode(expectedPostalCode);
        String actualPostalCode  = customer.getPostalCode();

        //Assert
        assertEquals(expectedPostalCode, actualPostalCode);
    }
}
