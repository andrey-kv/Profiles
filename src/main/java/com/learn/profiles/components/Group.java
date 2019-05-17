package com.learn.profiles.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Group {

    @Autowired
    private Person headOfGroup;


    public Person getHeadOfGroup() {
        return headOfGroup;
    }
}
