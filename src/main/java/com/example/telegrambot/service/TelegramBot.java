package com.example.telegrambot.service;

import com.example.telegrambot.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    final BotConfig config;

    public TelegramBot(BotConfig config) {
        this.config = config;
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            System.out.println(update.getMessage().getText());
            comandRecieved(chatId, update.getMessage().getChat().getUserName());
        }
    }
    private void comandRecieved(long chatId, String name) {
        if (name.equals("assiyazhm")) {
            sendMessage(chatId, "Привет Солнышко, я тебя люблю!");
        } else if (name.equals("abylaikossay")) {
            sendMessage(chatId, "Приветсвтую, мой король!");
        } else {
            sendMessage(chatId, "Hello," + name + ". How are you?");
        }


    }

//    private void getDataFromMetaApi() throws IOException, InterruptedException {
//        String apiUrl = "https://risk-management-api-v1.new-york.agiliumtrade.ai";
//        String accountId = "6a29cf6c-ee73-4e71-963b-c9c5fd949055";
//        String apiToken = "eyJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiJhMDkxZWU3NDcwZGYyMGQ3NDIxY2Y3MDAwODA2OTdkMyIsInBlcm1pc3Npb25zIjpbXSwiYWNjZXNzUnVsZXMiOlt7Im1ldGhvZHMiOlsicmlzay1tYW5hZ2VtZW50LWFwaTpyZXN0OnB1YmxpYzoqOioiXSwicm9sZXMiOlsicmVhZGVyIiwid3JpdGVyIl0sInJlc291cmNlcyI6WyIqOiRVU0VSX0lEJDo2YTI5Y2Y2Yy1lZTczLTRlNzEtOTYzYi1jOWM1ZmQ5NDkwNTUiXX1dLCJ0b2tlbklkIjoiMjAyMTAyMTMiLCJpbXBlcnNvbmF0ZWQiOmZhbHNlLCJyZWFsVXNlcklkIjoiYTA5MWVlNzQ3MGRmMjBkNzQyMWNmNzAwMDgwNjk3ZDMiLCJpYXQiOjE2ODUwMzAyOTh9.bZGHNa_Dr2G6x3_bPe0_dh6kQLfIP2R04-RmSamNBecoo2aeBIKiOngquVwQouRfqfkqVCf55QzOIMgAFcfftQ4RDLurKu2gktfA3eWrplwlgSFK3HOTfXCqROSFhWveHvS0s0AUbzQb0Tuqu5SHY8F-HdUnUzmMPo85ru7I1ibvCV42nejIxO1qKP3bqVNdkFQMqHyvZk7cAqjIyPVfAdcXBUCMeOGMvNeqRbyJ0enw0S52WE1sk-nARKmdyoRPVIURSinQY2VrZN0-K0R9WwR8AdIcMM211HgibRb4h4EMJjVUlah85uIv0wWqvzVqZo48dQ1Z0ByIBP88GlJ6U0nP__QiPJWUZqHRyzxCT6N27BYmUaTTu5k_F73EmldFQD5eqkQs2bFYcgaVMXTwpQb89K7FRhpSWTdSRPp_5JLyvT_ry-B2POIagDpgXNx_BdoU7EosaY6ziigLTzjP-ItzSc4lyjW7BMiV0Rgr28GwWHIg82UxiKrt-w-mNn-_-G8yTneixG3jK1CKijC3qtejB8nl_BWUijnd37gO4bcu1LK6brtMF3Q6s-DU3bie1UHbLHEhgIs61mmOEudXsnQAFiT5V88KATICJJLvowqtBTuM3vztx3qN5kl3aPWZY5v1B5TJ8NXczOA5kM7zCZM40GMNro7E-PTnGBz6OeU";
//
//        HttpClient client = HttpClient.newHttpClient();
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(apiUrl + "/users/current/accounts/" + accountId + "/trackers"))
//                .header("auth-token", apiToken)
//                .build();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        if (response.statusCode() == 200) {
//            String responseData = response.body();
//            System.out.println(responseData);
//
//        } else {
//            System.out.println("Error: " + response.statusCode());
//        }
//    }
    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try {
            execute(message);
        } catch (TelegramApiException e) {

        }

    }
}
