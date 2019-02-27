package com.example.didemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.didemo.controllers.ConstructorInjectedController;
import com.example.didemo.controllers.MyController;
import com.example.didemo.controllers.PropertyInjectedController;
import com.example.didemo.controllers.SetterInjectedController;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
        MyController controller = (MyController) ctx.getBean("myController");
        controller.hello();
        System.out.println("==========================================");
        System.out.println(ctx.getBean(MyController.class).sayHello());
        System.out.println("==========================================");
        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
    }

}
