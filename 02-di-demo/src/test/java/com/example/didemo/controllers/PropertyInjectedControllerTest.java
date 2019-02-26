package com.example.didemo.controllers;

import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.didemo.services.GreetingServiceImpl;

public class PropertyInjectedControllerTest {

    private PropertyInjectedController propertyInjectedController;

    @Before
    public void setup() throws Exception {
        this.propertyInjectedController = new PropertyInjectedController();
        // can't access greetingService. Therefore, not preferable at all
        this.propertyInjectedController.greetingService = new GreetingServiceImpl();
    }

    @Test
    public void testGreeting() {
        assertEquals(GreetingServiceImpl.HELLO_GURUS, propertyInjectedController.sayHello());
    }
}