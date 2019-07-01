package com.example.springcoreadvance.services.mapservices;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.springcoreadvance.domain.DomainObject;
import com.example.springcoreadvance.domain.User;
import com.example.springcoreadvance.services.UserService;

@Service
@Profile("map")
public class UserServiceMapImpl extends AbstractMapService implements UserService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public User getById(Integer id) {
        return (User) super.getById(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return (User) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    public User findByUserName(String userName) {

        Optional returnUser = domainMap.values().stream().filter(new Predicate<DomainObject>() {
            @Override
            public boolean test(DomainObject domainObject) {
                User user = (User) domainObject;
                return user.getUsername().equalsIgnoreCase(userName);
            }
        }).findFirst();

        return (User) returnUser.get();
    }
}
