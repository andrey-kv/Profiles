package com.learn.profiles.controllers;

import com.learn.profiles.models.Profile;
import com.learn.profiles.repositories.ProfileRepository;
import com.learn.profiles.services.PhoneFormatter;
import com.learn.profiles.services.ProfileService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private static final Logger log = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private ProfileRepository repository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private PhoneFormatter phoneFormatter;

    @GetMapping
    public List<Profile> getAllProfiles() {
        List<Profile> result = repository.findAll();
        log.info("Got all: Found " + result.size() + " record(s)");
        return result;
    }

    @GetMapping(value = "/{id}")
    public Profile getProfileById(@PathVariable("id") ObjectId id) {
        Profile profile = repository.findBy_id(id);
        log.info("Got: " + profile.toString());
        return profile;
    }

    @PutMapping(value = "/{id}")
    public void modifyProfileById(@PathVariable("id") ObjectId id, @Valid @RequestBody Profile profile) {
        Profile result = repository.findBy_id(id);
        repository.save(profileService.update(result, profile));
    }

    @PostMapping
    public Profile createProfile(@Valid @RequestBody Profile profile) {
        log.info("Posted: " + profile.toString());
        profile.set_id(ObjectId.get());

        if (profile.getPhone() != null && !profile.getPhone().isEmpty()) {
            profile.setPhone(phoneFormatter.format(profile.getPhone()));
        }

        repository.save(profile);
        return profile;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProfile(@PathVariable ObjectId id) {
        Profile profile = repository.findBy_id(id);
        log.info("Deleted: " + profile.toString());
        repository.delete(profile);
    }

}
