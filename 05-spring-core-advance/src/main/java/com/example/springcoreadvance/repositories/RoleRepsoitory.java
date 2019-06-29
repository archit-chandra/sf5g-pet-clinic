package com.example.springcoreadvance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.springcoreadvance.domain.security.Role;

public interface RoleRepsoitory extends CrudRepository<Role, Integer> {
}
