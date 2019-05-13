package com.learn.profiles.configurations;

import com.learn.profiles.services.PhoneFormatter;
import com.learn.profiles.services.impementation.BlrPhoneFormatter;
import com.learn.profiles.services.impementation.PolPhoneFormatter;
import com.learn.profiles.services.impementation.UkrPhoneFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestPhoneFormatterConfig {

    @Autowired
    private BlrPhoneFormatter blrPhoneFormatter;

    @Autowired
    private BlrPhoneFormatter polPhoneFormatter;

    @Bean
    @Primary
    public PhoneFormatter polFormatter() {
        return  polPhoneFormatter;
    }

    @Bean(name = "blrFormatter")
    public PhoneFormatter getFormatter() {
        return  blrPhoneFormatter;
    }

    @Bean(name = "polFormatter")
    public PhoneFormatter getPolFormatter() {
        return  polPhoneFormatter;
    }
}
