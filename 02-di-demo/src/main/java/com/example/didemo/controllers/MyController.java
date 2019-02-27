package com.example.didemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.didemo.services.GreetingService;

@Controller
public class MyController {

    private GreetingService greetingService;

    @Autowired
    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void hello() {
        System.out.println("hello!!");
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
