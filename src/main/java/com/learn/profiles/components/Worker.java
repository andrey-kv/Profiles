package com.learn.profiles.components;

import org.springframework.beans.factory.annotation.Autowired;

public class Worker implements Person {

    private final String name;

    @Autowired
    private Group group;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Group getGroup() {
        return group;
    }
}
