package com.learn.profiles.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Group {

    private Person headOfGroup;

    @Autowired
    public void setHeadOfGroup(Person headOfGroup) {
        this.headOfGroup = headOfGroup;
    }
}
