package com.learn.Profiles.services;

import com.learn.Profiles.models.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

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
            base.setPhone(update.getPhone());
        }
        if (update.getLocation() != null) {
            base.setLocation(update.getLocation());
        }
        return base;
    }
}
