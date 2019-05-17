package com.learn.profiles.services;

import com.learn.profiles.annotations.Engeneer;
import com.learn.profiles.components.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class BeanChecker {

    private static final Logger log = LoggerFactory.getLogger(BeanChecker.class);

    private Person firstPerson;

    @Autowired
    public BeanChecker(Person firstPerson) {
        log.info("========= BeanChecker constructor =========");
        this.firstPerson = firstPerson;
    }

    @Autowired
    @Qualifier("worker")
    private Person secondPerson;

    @Autowired
    @Engeneer
    private Person thirdPerson;

    @EventListener(ApplicationReadyEvent.class)
    private void doSomeActions() {
        log.info("========= Testing beans =========");
        log.info(firstPerson.getName());
        log.info(secondPerson.getName());
        log.info(thirdPerson.getName());

        log.info("Group of firstPerson = " + firstPerson.getGroup().toString());
        log.info("Group of secondPerson = " + secondPerson.getGroup().toString());
        log.info("Group of thirdPerson = " + thirdPerson.getGroup().toString());

        log.info("Head of Group = " + thirdPerson.getGroup().getHeadOfGroup().getName());
    }

}
