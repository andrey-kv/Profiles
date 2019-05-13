package com.learn.profiles.services;

import com.learn.profiles.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ApplicationContext context;

    @Autowired
    @Qualifier("polFormatter")
    PhoneFormatter secondFormatter;


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

            // Using bean class to choose implementation
            PhoneFormatter formatter = context.getBean("blrFormatter", PhoneFormatter.class);
            String number = formatter.format(update.getPhone());

            if (number.equals(update.getPhone())) {
                number = secondFormatter.format(number);
            }
            base.setPhone(number);
        }
        if (update.getLocation() != null) {
            base.setLocation(update.getLocation());
        }
        return base;
    }
}
