package com.example.springcoreadvance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springcoreadvance.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
