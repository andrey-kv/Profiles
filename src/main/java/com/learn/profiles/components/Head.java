package com.learn.profiles.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope("prototype")
public class Head implements Person {

    @Autowired
    private Group group;

    @Autowired
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String getName() {
        return "Head";
    }

    @Override
    public Group getGroup() {
        return group;
    }
}
