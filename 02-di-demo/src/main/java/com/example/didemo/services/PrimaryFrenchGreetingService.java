package com.example.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("fr")
public class PrimaryFrenchGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Bonjour!!";
    }
}
