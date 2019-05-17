package com.learn.profiles.components;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// @TestExecutionListeners({ TestPreperationExecutionListener.class })
// @Transactional
@ActiveProfiles(profiles = "dev")
@ContextConfiguration
public class GroupTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void groupCreation() {

//        Group group1 = context.getBean(Group.class);
//
//        Person admin = context.getBean(Person.class);
//        admin.setName("Jon");
//        admin.setGroup(group1);
//        group1.setAdmin(admin);
//
//        Group group2 = context.getBean(Group.class);
//
//        Person head = context.getBean(Person.class);
//        head.setName("Tirion");
//        head.setGroup(group2);
//
//        Assert.assertEquals(group1, group2);
//        Assert.assertEquals("Tirion", group1.getHeadOfGroup());
//        Assert.assertEquals("Jon", group2.getAdmin());
    }
}