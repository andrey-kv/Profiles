package com.learn.profiles.models;

import com.learn.profiles.services.Location;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Profile {

    @Id
    public ObjectId _id;

    public String firstName;
    public String secondName;
    public String email;
    public String phone;
    public Location location;

    public Profile(ObjectId _id, String firstName, String secondName, String email, String phone, Location location) {
        this._id = _id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phone = phone;
        this.location = location;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "_id=" + _id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location.toString() + '\'' +
                '}';
    }


}
