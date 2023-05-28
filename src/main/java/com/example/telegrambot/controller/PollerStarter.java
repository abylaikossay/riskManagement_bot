package com.example.telegrambot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PollerStarter implements ApplicationRunner {

    private final TrackerEventPoller trackerEventPoller;

    @Autowired
    public PollerStarter(TrackerEventPoller trackerEventPoller) {
        this.trackerEventPoller = trackerEventPoller;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        trackerEventPoller.startPolling();
    }
}
