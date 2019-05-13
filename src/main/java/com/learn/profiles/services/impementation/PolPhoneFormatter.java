package com.learn.profiles.services.impementation;

import com.learn.profiles.services.PhoneFormatter;
import org.springframework.stereotype.Component;

@Component
public class PolPhoneFormatter implements PhoneFormatter {

    @Override
    public String format(String phoneNumber) {
        if (phoneNumber.startsWith("0")) {
            phoneNumber = "+48" + phoneNumber;
        }
        return phoneNumber;
    }
}