package com.learn.profiles.components;

import com.learn.profiles.annotations.Engeneer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Group {

    @Autowired
    private Person headOfGroup;

    @Autowired
    @Engeneer
    private Person engineer;


    public Person getHeadOfGroup() {
        return headOfGroup;
    }

    @Lookup
    public Person getWorker() {
        return engineer;
    }
}
