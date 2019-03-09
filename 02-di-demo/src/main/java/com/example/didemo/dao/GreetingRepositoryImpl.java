package com.example.didemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getEnglishGreeting() {
        return "Hello!!";
    }

    @Override
    public String getSpanishGreeting() {
        return "Hola!!";
    }

    @Override
    public String getFrenchGreeting() {
        return "Bonjour!!";
    }
}
