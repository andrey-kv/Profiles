package com.learn.profiles.services;

import com.learn.profiles.models.Profile;
import com.learn.profiles.repositories.ProfileRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class ProfileService {

    @Autowired
    @Qualifier("blrFormatter")
    PhoneFormatter formatter;

    @Autowired
    @Qualifier("polFormatter")
    PhoneFormatter secondFormatter;

    @Autowired
    PhoneFormatter phoneFormatter;

    @Autowired
    private ProfileRepository repository;

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

    public void modify(ObjectId id, Profile profile) {
        Profile result = repository.findBy_id(id);
        repository.save(update(result, profile));
    }


    public Profile create(Profile profile) {
        profile.set_id(ObjectId.get());

        if (profile.getPhone() != null && !profile.getPhone().isEmpty()) {
            profile.setPhone(phoneFormatter.format(profile.getPhone()));
        }

        repository.save(profile);
        return profile;
    }

    public List<Profile> getAll() {
        return repository.findAll();
    }

    public Profile getById(ObjectId id) {
        return repository.findBy_id(id);
    }

    public Profile delete(ObjectId id) {
        Profile profile = repository.findBy_id(id);
        repository.delete(profile);
        return profile;
    }
}
