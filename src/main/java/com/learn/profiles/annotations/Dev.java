package com.learn.profiles.annotations;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Profile("dev")
public @interface Dev {
}
