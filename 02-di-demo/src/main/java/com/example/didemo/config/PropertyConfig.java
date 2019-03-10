package com.example.didemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.example.didemo.examplebeans.FakeDataSource;
import com.example.didemo.examplebeans.FakeJmsBroker;

@Configuration
//@PropertySource("classpath:datasource.properties")
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Autowired
    private Environment env;

    @Value("${guru.username}")
    private String user;

    @Value("${guru.password}")
    private String password;

    @Value("${guru.url}")
    private String url;

    @Value("${guru.jms.username}")
    private String jmsUsername;

    @Value("${guru.jms.password}")
    private String jmsPassword;

    @Value("${guru.jms.url}")
    private String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        //fakeDataSource.setUser(env.getProperty("USERNAME"));
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker jmsBroker = new FakeJmsBroker();
        jmsBroker.setUsername(jmsUsername);
        jmsBroker.setPassword(jmsPassword);
        jmsBroker.setUrl(jmsUrl);
        return jmsBroker;
    }

    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
