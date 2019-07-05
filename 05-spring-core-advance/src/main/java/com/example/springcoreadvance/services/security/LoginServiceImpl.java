package com.example.springcoreadvance.services.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.springcoreadvance.domain.User;
import com.example.springcoreadvance.services.UserService;

@Service
public class LoginServiceImpl implements LoginService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Scheduled(fixedRate = 60000)
    @Override
    public void resetFailedLogins() {
        System.out.println("Checking for locked accounts");

        List<User> userList = (List<User>) userService.listAll();

        userList.forEach(user -> {
            if (!user.getEnabled() && user.getFailedLoginAttempts() > 0) {
                System.out.println("Resetting failed attempts for user: " + user.getUsername());
                user.setFailedLoginAttempts(0);
                user.setEnabled(true);
                userService.saveOrUpdate(user);
            }
        });

    }
}
