package com.example.telegrambot.models;

import lombok.Data;

@Data
public class TrackerEvent {
    private double relativeDrawdown;
    private double absoluteDrawdown;
    private double absoluteProfit;
    private double relativeProfit;
    private long sequenceNumber;
    private String accountId;
    private String trackerId;
    private String startBrokerTime;
    private String endBrokerTime;
    private String period;
    private String brokerTime;
    private String exceededThresholdType;
}
