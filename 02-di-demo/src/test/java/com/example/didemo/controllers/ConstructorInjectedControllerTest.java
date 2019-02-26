package com.example.didemo.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.didemo.services.GreetingServiceImpl;

public class ConstructorInjectedControllerTest {

    private ConstructorInjectedController constructorInjectedController;

    @Before
    public void setup() throws Exception {
        // when using constructor injection, we can't create instance without giving proper dependency
        // therefore, preferable
        this.constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(GreetingServiceImpl.HELLO_GURUS, constructorInjectedController.sayHello());
    }
}