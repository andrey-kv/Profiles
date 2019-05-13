package com.learn.profiles.services.impementation;

import com.learn.profiles.services.PhoneFormatter;
import org.springframework.stereotype.Component;

@Component
public class BlrPhoneFormatter implements PhoneFormatter {

    @Override
    public String format(String phoneNumber) {
        if (!phoneNumber.startsWith("0") && phoneNumber.length() == 9) {
            phoneNumber = "+375" + phoneNumber;
        }
        return phoneNumber;
    }
}

