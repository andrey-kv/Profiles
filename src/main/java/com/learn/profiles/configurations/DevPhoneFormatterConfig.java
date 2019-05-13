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
@Profile("dev")
public class DevPhoneFormatterConfig {

    @Autowired
    private UkrPhoneFormatter ukrPhoneFormatter;

    @Autowired
    private BlrPhoneFormatter blrPhoneFormatter;

    @Autowired
    private PolPhoneFormatter polPhoneFormatter;

    @Bean
    @Primary
    public PhoneFormatter ukrFormatter() {
        return  ukrPhoneFormatter;
    }

    @Bean
    public PhoneFormatter blrFormatter() {
        return  blrPhoneFormatter;
    }

    @Bean
    public PhoneFormatter polFormatter() {
        return polPhoneFormatter;
    }
}
