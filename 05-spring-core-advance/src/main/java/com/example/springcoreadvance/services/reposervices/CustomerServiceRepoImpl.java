package com.example.springcoreadvance.services.reposervices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springcoreadvance.commands.CustomerForm;
import com.example.springcoreadvance.converters.CustomerFormToCustomer;
import com.example.springcoreadvance.domain.Customer;
import com.example.springcoreadvance.repositories.CustomerRepository;
import com.example.springcoreadvance.repositories.UserRepository;
import com.example.springcoreadvance.services.CustomerService;

@Service
@Profile({"springdatajpa", "jpadao"})
public class CustomerServiceRepoImpl implements CustomerService {

    private UserRepository userRepository;
    private CustomerRepository customerRepository;
    private CustomerFormToCustomer customerFormToCustomer;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setCustomerFormToCustomer(CustomerFormToCustomer customerFormToCustomer) {
        this.customerFormToCustomer = customerFormToCustomer;
    }

    @Override
    public List<?> listAll() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer getById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return customerRepository.save(domainObject);
    }

    @Override
    public Customer saveOrUpdateCustomerForm(CustomerForm customerForm) {
        Customer newCustomer = customerFormToCustomer.convert(customerForm);

        if (newCustomer != null && newCustomer.getUser().getId() != null) {
            Customer existingCustomer = getById(newCustomer.getId());
            newCustomer.getUser().setEnabled(existingCustomer.getUser().getEnabled());
        }

        return saveOrUpdate(newCustomer);
    }

    @Override
    @Transactional
    // NOTES: @Transactional
    //  1. If not used, then each repository calls will be handled in different transactions
    //  2. Now, both below calls to userRepository, customerRepository will be in single transaction
    public void delete(Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            userRepository.delete(customer.getUser());
            customerRepository.delete(customer);
        }
    }
}
