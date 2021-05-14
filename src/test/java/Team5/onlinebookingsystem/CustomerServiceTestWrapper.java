package Team5.onlinebookingsystem;

public class CustomerServiceTestWrapper extends CustomerService{

    public void setCustomerRepository(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
}
