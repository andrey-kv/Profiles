package com.learn.profiles.controllers;

import com.learn.profiles.models.Profile;
import com.learn.profiles.services.ProfileService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private static final Logger log = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private ProfileService profileService;

   @GetMapping
    public List<Profile> getAllProfiles() {
        List<Profile> result = profileService.getAll();
        log.info("Got all: Found " + result.size() + " record(s)");
        return result;
    }

    @GetMapping(value = "/{id}")
    public Profile getProfileById(@PathVariable("id") ObjectId id) {
        Profile profile = profileService.getById(id);
        log.info("Got: " + profile.toString());
        return profile;
    }

    @PutMapping(value = "/{id}")
    public void modifyProfileById(@PathVariable("id") ObjectId id, @Valid @RequestBody Profile profile) {
        profileService.modify(id, profile);
    }

    @PostMapping
    public Profile createProfile(@Valid @RequestBody Profile profile) {
        log.info("Posted: " + profile.toString());
        return profileService.create(profile);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProfile(@PathVariable ObjectId id) {
        Profile profile = profileService.delete(id);
        log.info("Deleted: " + profile.toString());
    }

}
