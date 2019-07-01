package com.example.springcoreadvance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springcoreadvance.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String userName);
}
