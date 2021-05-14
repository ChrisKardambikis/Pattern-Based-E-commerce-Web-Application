package Team5.onlinebookingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    protected CustomerRepository customerRepository;


    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer get(long id) {
        return customerRepository.findById(id).get();
    }

    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    public Customer findByEmail(String email){
        return customerRepository.findByEmail(email);
    }

}
