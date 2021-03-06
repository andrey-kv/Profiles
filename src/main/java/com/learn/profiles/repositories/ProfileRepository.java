package com.learn.profiles.repositories;

import com.learn.profiles.models.Profile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProfileRepository extends MongoRepository<Profile, String>{
    Profile findBy_id(ObjectId id);
    List<Profile> findByLocation(String location);
}
