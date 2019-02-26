package com.example.didemo.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.didemo.services.GreetingServiceImpl;

public class SetterInjectedControllerTest {

    private SetterInjectedController setterInjectedController;

    @Before
    public void setup() throws Exception {
        this.setterInjectedController = new SetterInjectedController();
        // when using setter injection, one can miss below line
        // hence, causing NullPointerException when call setterInjectedController.sayHello() in the test
        this.setterInjectedController.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.HELLO_GURUS, setterInjectedController.sayHello());
    }
}