package com.example.telegrambot.controller;

import com.example.telegrambot.models.TrackerEvent;
import com.example.telegrambot.service.RiskManagementService;
import com.example.telegrambot.service.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrackerEventPoller {

    private final RiskManagementService riskManagementService;
    private final TelegramBot telegramBot;

    @Autowired
    public TrackerEventPoller(RiskManagementService riskManagementService, TelegramBot telegramBot) {
        this.riskManagementService = riskManagementService;
        this.telegramBot = telegramBot;
    }

    public void startPolling() {
        while (true) {
            List<TrackerEvent> eventList = riskManagementService.getTrackerEvents();
            if (eventList.size() > 0) {
                eventList.forEach(trackerEvent -> {
                    if (trackerEvent.getRelativeDrawdown() < 3.0) {
                        telegramBot.sendMessage(211178284, "Relative Drawdown" + trackerEvent.getRelativeDrawdown());
                    }
                });
            } else {
                telegramBot.sendMessage(211178284, "Пулинг запрос успешно получен");
            }
        }
    }
}
