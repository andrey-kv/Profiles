package com.learn.profiles.components;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanComponent {

    @Bean
    public String beanString() {
        return "BeanString";
    }
}
