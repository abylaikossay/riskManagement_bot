package com.example.telegrambot.controller;

import com.example.telegrambot.models.TrackerEvent;
import com.example.telegrambot.service.RiskManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrackerEventPoller {

    private final RiskManagementService riskManagementService;

    @Autowired
    public TrackerEventPoller(RiskManagementService riskManagementService) {
        this.riskManagementService = riskManagementService;
    }

    public void startPolling() {
        while (true) {
            List<TrackerEvent> event = riskManagementService.getTrackerEvents();
            // Process the received event
            System.out.println(event);
        }
    }
}
