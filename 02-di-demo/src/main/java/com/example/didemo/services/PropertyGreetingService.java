package com.example.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class PropertyGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "I am injected by the PropertyGreetingService";
    }
}
