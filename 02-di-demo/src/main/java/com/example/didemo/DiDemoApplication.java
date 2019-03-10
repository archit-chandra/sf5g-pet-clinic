package com.example.didemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.didemo.examplebeans.FakeDataSource;
import com.example.didemo.examplebeans.FakeJmsBroker;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println("=======>>>> User    : " + fakeDataSource.getUser());
        System.out.println("=======>>>> Password: " + fakeDataSource.getPassword());
        System.out.println("=======>>>> Url     : " + fakeDataSource.getUrl());

        FakeJmsBroker jmsBroker = ctx.getBean(FakeJmsBroker.class);
        System.out.println("=======>>>> JMS User    : " + jmsBroker.getUsername());
        System.out.println("=======>>>> JMS Password: " + jmsBroker.getPassword());
        System.out.println("=======>>>> JMS Url     : " + jmsBroker.getUrl());
    }

}
