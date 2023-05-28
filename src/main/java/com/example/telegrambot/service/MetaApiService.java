package com.example.telegrambot.service;

import com.example.telegrambot.models.TrackerEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MetaApiService {
    private final WebClient webClient;

    public MetaApiService() {
        this.webClient = WebClient.create();
    }

    public TrackerEvent fetchRelativeDrawdownData() {
        String apiUrl = "https://risk-management-api-v1.new-york.agiliumtrade.ai/users/current/tracker-events/stream";
        String accountId = "6a29cf6c-ee73-4e71-963b-c9c5fd949055";
        String apiToken = "eyJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiJhMDkxZWU3NDcwZGYyMGQ3NDIxY2Y3MDAwODA2OTdkMyIsInBlcm1pc3Npb25zIjpbXSwiYWNjZXNzUnVsZXMiOlt7Im1ldGhvZHMiOlsicmlzay1tYW5hZ2VtZW50LWFwaTpyZXN0OnB1YmxpYzoqOioiXSwicm9sZXMiOlsicmVhZGVyIiwid3JpdGVyIl0sInJlc291cmNlcyI6WyIqOiRVU0VSX0lEJDo2YTI5Y2Y2Yy1lZTczLTRlNzEtOTYzYi1jOWM1ZmQ5NDkwNTUiXX1dLCJ0b2tlbklkIjoiMjAyMTAyMTMiLCJpbXBlcnNvbmF0ZWQiOmZhbHNlLCJyZWFsVXNlcklkIjoiYTA5MWVlNzQ3MGRmMjBkNzQyMWNmNzAwMDgwNjk3ZDMiLCJpYXQiOjE2ODUwMzAyOTh9.bZGHNa_Dr2G6x3_bPe0_dh6kQLfIP2R04-RmSamNBecoo2aeBIKiOngquVwQouRfqfkqVCf55QzOIMgAFcfftQ4RDLurKu2gktfA3eWrplwlgSFK3HOTfXCqROSFhWveHvS0s0AUbzQb0Tuqu5SHY8F-HdUnUzmMPo85ru7I1ibvCV42nejIxO1qKP3bqVNdkFQMqHyvZk7cAqjIyPVfAdcXBUCMeOGMvNeqRbyJ0enw0S52WE1sk-nARKmdyoRPVIURSinQY2VrZN0-K0R9WwR8AdIcMM211HgibRb4h4EMJjVUlah85uIv0wWqvzVqZo48dQ1Z0ByIBP88GlJ6U0nP__QiPJWUZqHRyzxCT6N27BYmUaTTu5k_F73EmldFQD5eqkQs2bFYcgaVMXTwpQb89K7FRhpSWTdSRPp_5JLyvT_ry-B2POIagDpgXNx_BdoU7EosaY6ziigLTzjP-ItzSc4lyjW7BMiV0Rgr28GwWHIg82UxiKrt-w-mNn-_-G8yTneixG3jK1CKijC3qtejB8nl_BWUijnd37gO4bcu1LK6brtMF3Q6s-DU3bie1UHbLHEhgIs61mmOEudXsnQAFiT5V88KATICJJLvowqtBTuM3vztx3qN5kl3aPWZY5v1B5TJ8NXczOA5kM7zCZM40GMNro7E-PTnGBz6OeU";
        return webClient.get()
                .uri(apiUrl)
                .header("auth-token", apiToken)
                .retrieve()
                .bodyToMono(TrackerEvent.class)
                .block();
    }
}
