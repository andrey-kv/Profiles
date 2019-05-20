package com.learn.profiles.configurations;

import com.learn.profiles.annotations.Dev;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

    @Bean(name = "profileInfo")
    @Dev
    public String devProfileInfo() {
        return "Dev profile";
    }

    @Bean(name = "profileInfo")
    @Profile("test")
    public String testProfileInfo() {
        return "Test profile";
    }
}
