package com.example.springcoreadvance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springcoreadvance.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
