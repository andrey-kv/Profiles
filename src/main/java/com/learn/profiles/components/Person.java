package com.learn.profiles.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private Group group;

    @Autowired
    public void setGroup(Group group) {
        this.group = group;
    }
}
