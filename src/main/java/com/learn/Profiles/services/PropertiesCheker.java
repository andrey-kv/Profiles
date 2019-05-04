package com.learn.Profiles.services;

import com.learn.Profiles.properties.AppData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class PropertiesCheker {

    private static final Logger log = LoggerFactory.getLogger(PropertiesCheker.class);

    @Autowired
    private AppData appData;

    @EventListener(ApplicationReadyEvent.class)
    private void read() {
        log.info("Read custom application properties:");
        log.info("FirstName = " + appData.getFirstName());
        log.info("SecondName = " + appData.getSecondName());
    }
}
