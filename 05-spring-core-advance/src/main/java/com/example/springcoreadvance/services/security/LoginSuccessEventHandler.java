package com.example.springcoreadvance.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.springcoreadvance.domain.User;
import com.example.springcoreadvance.services.UserService;

@Component
public class LoginSuccessEventHandler implements ApplicationListener<LoginSuccessEvent> {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        Authentication authentication = (Authentication) event.getSource();
        System.out.println("LoginEvent Failure for: " + authentication.getPrincipal());
        updateUserAccount(authentication);
    }

    private void updateUserAccount(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByUserName(userDetails.getUsername());

        if (user != null) { //user found
            user.setFailedLoginAttempts(0);

            System.out.println("Good login, resetting failed attempts");
            userService.saveOrUpdate(user);
        }
    }
}
