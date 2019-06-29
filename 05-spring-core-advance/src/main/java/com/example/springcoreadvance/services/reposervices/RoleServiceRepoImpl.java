package com.example.springcoreadvance.services.reposervices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.springcoreadvance.domain.security.Role;
import com.example.springcoreadvance.repositories.RoleRepsoitory;
import com.example.springcoreadvance.services.RoleService;

@Service
@Profile({"springdatajpa", "jpadao"})
public class RoleServiceRepoImpl implements RoleService {

    private RoleRepsoitory roleRepsoitory;

    @Autowired
    public void setRoleRepsoitory(RoleRepsoitory roleRepsoitory) {
        this.roleRepsoitory = roleRepsoitory;
    }

    @Override
    public List<?> listAll() {
        List<Role> roles = new ArrayList<>();
        roleRepsoitory.findAll().forEach(roles::add); //fun with Java 8
        return roles;
    }

    @Override
    public Role getById(Integer id) {
        return roleRepsoitory.findById(id).orElse(null);
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        return roleRepsoitory.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        roleRepsoitory.deleteById(id);
    }
}
