package com.example.didemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.didemo.services.GreetingService;

@Controller
public class PropertyInjectedController {

    @Autowired
    @Qualifier("propertyGreetingService")
    public GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
