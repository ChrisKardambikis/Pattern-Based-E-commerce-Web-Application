package Team5.onlinebookingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CustomerServiceTest {

    Map<String, Object> setupObjects;

    @BeforeEach
    public void getSetupObjects(){
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        CustomerServiceTestWrapper customerService = new CustomerServiceTestWrapper();
        customerService.setCustomerRepository(customerRepository);

        Map<String, Object> createdObjects = new HashMap<String, Object>()
        {{
            put("customerRepository", customerRepository);
            put("customerService", customerService);
        }};

        setupObjects = createdObjects;
    }

    @Test
    public void listAllTest(){
        // Arrange
        CustomerRepository customerRepository = (CustomerRepository) setupObjects.get("customerRepository");
        CustomerServiceTestWrapper customerService = (CustomerServiceTestWrapper) setupObjects.get("customerService");

        List<Customer> customerList = new ArrayList<Customer>();
        Customer customer1 = Mockito.mock(Customer.class);
        Customer customer2 = Mockito.mock(Customer.class);
        customerList.add(customer1);
        customerList.add(customer2);

        Mockito.when(customerRepository.findAll()).thenReturn(customerList);

        // Act
        List<Customer> allCustomers = customerService.listAll();

        // Assert
        Mockito.verify(customerRepository, Mockito.times(1)).findAll();
        assertEquals(customerList, allCustomers);

    }

    @Test
    public void saveTest(){
        // Arrange
        Customer customer = Mockito.mock(Customer.class);

        CustomerRepository customerRepository = (CustomerRepository) setupObjects.get("customerRepository");
        CustomerServiceTestWrapper customerService = (CustomerServiceTestWrapper) setupObjects.get("customerService");

        // Act
        customerService.save(customer);

        // Assert
        Mockito.verify(customerRepository, Mockito.times(1)).save(customer);
    }

    @Test
    void getTest() {
        //Arrange
        long customerId = 100l;
        Customer customer = Mockito.mock(Customer.class);

        CustomerRepository customerRepository = (CustomerRepository) setupObjects.get("customerRepository");
        CustomerServiceTestWrapper customerService = (CustomerServiceTestWrapper) setupObjects.get("customerService");

        Mockito.when(customerRepository.findById(customerId)).thenReturn(java.util.Optional.ofNullable(customer));

        // Act
        customerService.get(customerId);

        // Assert
        verify(customerRepository, times(1)).findById(customerId);
    }

    @Test
    void deleteTest() {
        long customerId = 100l;

        CustomerRepository customerRepository = (CustomerRepository) setupObjects.get("customerRepository");
        CustomerServiceTestWrapper customerService = (CustomerServiceTestWrapper) setupObjects.get("customerService");

        Mockito.doNothing().when(customerRepository).deleteById(customerId);

        // Act
        customerService.delete(customerId);

        // Assert
        verify(customerRepository, times(1)).deleteById(customerId);
    }

    @Test
    void findByEmailTest() {
        //Arrange
        String email = "helloworld@email.com";
        Customer expectedCustomer = Mockito.mock(Customer.class);

        CustomerRepository customerRepository = (CustomerRepository) setupObjects.get("customerRepository");
        CustomerServiceTestWrapper customerService = (CustomerServiceTestWrapper) setupObjects.get("customerService");

        Mockito.when(customerRepository.findByEmail(email)).thenReturn(expectedCustomer);

        // Act
        Customer searchResult = customerService.findByEmail(email);

        // Assert
        verify(customerRepository, times(1)).findByEmail(email);
        assertEquals(expectedCustomer, searchResult);
    }

}
