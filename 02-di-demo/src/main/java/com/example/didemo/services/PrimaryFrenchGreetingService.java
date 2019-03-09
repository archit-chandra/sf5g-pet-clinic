package com.example.didemo.services;

import com.example.didemo.dao.GreetingRepository;

public class PrimaryFrenchGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimaryFrenchGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getFrenchGreeting();
    }
}
