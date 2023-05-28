package com.example.telegrambot.controller;

import com.example.telegrambot.models.TrackerEvent;
import com.example.telegrambot.service.MetaApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final MetaApiService metaApiService;

    @Autowired
    public ApiController(MetaApiService metaApiService) {
        this.metaApiService = metaApiService;
    }

    @GetMapping("/relative-drawdown")
    public TrackerEvent getRelativeDrawdownData() {
        return metaApiService.fetchRelativeDrawdownData();
    }
}
