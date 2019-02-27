package com.example.didemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    // 1.
    public LifeCycleDemoBean() {
        System.out.println("==========>>>> I am in the LifeCycleBean constructor");
    }

    // 2.
    @Override
    public void setBeanName(String beanName) {
        System.out.println("==========>>>> My Bean name is: " + beanName);
    }

    // 3.
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("==========>>>> Bean Factory has been set");
    }

    // 4.
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("==========>>>> Application Context has been set");
    }

    // 7.
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("==========>>>> The LifeCycleBean has been its property set");
    }

    // 6.
    @PostConstruct
    public void postConstruct() {
        System.out.println("==========>>>> The post construct annotated method has been called");
    }

    // 9.
    @PreDestroy
    public void preDestroy() {
        System.out.println("==========>>>> The pre destroy annotated method has been called");
    }

    // 10.
    @Override
    public void destroy() throws Exception {
        System.out.println("==========>>>> LifeCycleBean has been destroyed");
    }

    // 5.
    public void beforeInit() {
        System.out.println("==========>>>> Before Init - called by Bean Post Processor");
    }

    // 8.
    public void afterInit() {
        System.out.println("==========>>>> After Init - called by Bean Post Processor");
    }
}
