package com.learn.profiles.configurations;

import com.learn.profiles.annotations.Engeneer;
import com.learn.profiles.components.Person;
import com.learn.profiles.components.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PersonConfig {

    @Bean(name = "worker")
    @Scope("prototype")
    public Person getWorker() {
        return new Worker("Worker");
    }

    @Bean
    @Engeneer
    public Person getEngeneer() {
        return new Worker("Engeneer");
    }
}
