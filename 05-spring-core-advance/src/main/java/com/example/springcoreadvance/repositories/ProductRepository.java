package com.example.springcoreadvance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springcoreadvance.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
