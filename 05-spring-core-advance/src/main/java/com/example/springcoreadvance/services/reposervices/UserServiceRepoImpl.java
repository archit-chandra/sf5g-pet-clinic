package com.example.springcoreadvance.services.reposervices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springcoreadvance.domain.User;
import com.example.springcoreadvance.repositories.CustomerRepository;
import com.example.springcoreadvance.repositories.UserRepository;
import com.example.springcoreadvance.services.UserService;

@Service
@Profile({"springdatajpa", "jpadao"})
public class UserServiceRepoImpl implements UserService {

    private UserRepository userRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<?> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); //fun with Java 8
        return users;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return userRepository.save(domainObject);
    }

    @Override
    @Transactional
    // NOTES: @Transactional
    //  1. If not used, then each repository calls will be handled in different transactions
    //  2. Now, both below calls to userRepository, customerRepository will be in single transaction
    public void delete(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            customerRepository.delete(user.getCustomer());
            userRepository.delete(user);
        }
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
}