package com.example.didemo.controllers;

import com.example.didemo.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
