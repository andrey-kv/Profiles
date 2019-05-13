package com.learn.profiles.services;

import com.learn.profiles.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ApplicationContext context;

    public Profile update(Profile base, Profile update) {
        if (update.getFirstName() != null) {
            base.setFirstName(update.getFirstName());
        }
        if (update.getSecondName() != null) {
            base.setSecondName(update.getSecondName());
        }
        if (update.getEmail() != null) {
            base.setEmail(update.getEmail());
        }
        if (update.getPhone() != null) {

            PhoneFormatter formatter = context.getBean(PhoneFormatter.class);
            base.setPhone(formatter.format(update.getPhone()));
        }
        if (update.getLocation() != null) {
            base.setLocation(update.getLocation());
        }
        return base;
    }
}
