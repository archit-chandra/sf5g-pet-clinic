package com.example.didemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.didemo.examplebeans.FakeDataSource;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println("=======>>>> User    : " + fakeDataSource.getUser());
        System.out.println("=======>>>> Password: " + fakeDataSource.getPassword());
        System.out.println("=======>>>> Url     : " + fakeDataSource.getUrl());
    }

}
