package com.example.telegrambot.service;

import com.example.telegrambot.models.TrackerEvent;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RiskManagementService {
    private final RestTemplate restTemplate;

    public RiskManagementService() {
        this.restTemplate = new RestTemplate();
    }

//    public List<TrackerEvent> getTrackerEvent() {
//        String apiUrl = "https://risk-management-api-v1.new-york.agiliumtrade.ai";
//        String endpoint = "/users/current/tracker-events/stream?previousSequenceNumber=0&limit=1000";
//        String token = "eyJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiJhMDkxZWU3NDcwZGYyMGQ3NDIxY2Y3MDAwODA2OTdkMyIsInBlcm1pc3Npb25zIjpbXSwiYWNjZXNzUnVsZXMiOlt7Im1ldGhvZHMiOlsicmlzay1tYW5hZ2VtZW50LWFwaTpyZXN0OnB1YmxpYzoqOioiXSwicm9sZXMiOlsicmVhZGVyIiwid3JpdGVyIl0sInJlc291cmNlcyI6WyIqOiRVU0VSX0lEJDo2YTI5Y2Y2Yy1lZTczLTRlNzEtOTYzYi1jOWM1ZmQ5NDkwNTUiXX1dLCJ0b2tlbklkIjoiMjAyMTAyMTMiLCJpbXBlcnNvbmF0ZWQiOmZhbHNlLCJyZWFsVXNlcklkIjoiYTA5MWVlNzQ3MGRmMjBkNzQyMWNmNzAwMDgwNjk3ZDMiLCJpYXQiOjE2ODUwMzAyOTh9.bZGHNa_Dr2G6x3_bPe0_dh6kQLfIP2R04-RmSamNBecoo2aeBIKiOngquVwQouRfqfkqVCf55QzOIMgAFcfftQ4RDLurKu2gktfA3eWrplwlgSFK3HOTfXCqROSFhWveHvS0s0AUbzQb0Tuqu5SHY8F-HdUnUzmMPo85ru7I1ibvCV42nejIxO1qKP3bqVNdkFQMqHyvZk7cAqjIyPVfAdcXBUCMeOGMvNeqRbyJ0enw0S52WE1sk-nARKmdyoRPVIURSinQY2VrZN0-K0R9WwR8AdIcMM211HgibRb4h4EMJjVUlah85uIv0wWqvzVqZo48dQ1Z0ByIBP88GlJ6U0nP__QiPJWUZqHRyzxCT6N27BYmUaTTu5k_F73EmldFQD5eqkQs2bFYcgaVMXTwpQb89K7FRhpSWTdSRPp_5JLyvT_ry-B2POIagDpgXNx_BdoU7EosaY6ziigLTzjP-ItzSc4lyjW7BMiV0Rgr28GwWHIg82UxiKrt-w-mNn-_-G8yTneixG3jK1CKijC3qtejB8nl_BWUijnd37gO4bcu1LK6brtMF3Q6s-DU3bie1UHbLHEhgIs61mmOEudXsnQAFiT5V88KATICJJLvowqtBTuM3vztx3qN5kl3aPWZY5v1B5TJ8NXczOA5kM7zCZM40GMNro7E-PTnGBz6OeU";
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("auth-token", token);
//        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
//        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(apiUrl + endpoint));
//
//
//        Class<TrackerEvent[]> responseType = (Class<TrackerEvent[]>) Array.newInstance(TrackerEvent.class, 0).getClass();
//        TrackerEvent[] eventArray = restTemplate.exchange(requestEntity, responseType).getBody();
//        if (eventArray != null) {
//            return Arrays.asList(eventArray);
//        }
//        return new ArrayList<>();
////        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, URI.create(apiUrl + endpoint));
////        return restTemplate.exchange(requestEntity, TrackerEvent.class).getBody();
//    }

    public List<TrackerEvent> getTrackerEvents() {
        String apiUrl = "https://risk-management-api-v1.new-york.agiliumtrade.ai/users/current/tracker-events/stream";
        String token = "eyJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiJhMDkxZWU3NDcwZGYyMGQ3NDIxY2Y3MDAwODA2OTdkMyIsInBlcm1pc3Npb25zIjpbXSwiYWNjZXNzUnVsZXMiOlt7Im1ldGhvZHMiOlsicmlzay1tYW5hZ2VtZW50LWFwaTpyZXN0OnB1YmxpYzoqOioiXSwicm9sZXMiOlsicmVhZGVyIiwid3JpdGVyIl0sInJlc291cmNlcyI6WyIqOiRVU0VSX0lEJDo2YTI5Y2Y2Yy1lZTczLTRlNzEtOTYzYi1jOWM1ZmQ5NDkwNTUiXX1dLCJ0b2tlbklkIjoiMjAyMTAyMTMiLCJpbXBlcnNvbmF0ZWQiOmZhbHNlLCJyZWFsVXNlcklkIjoiYTA5MWVlNzQ3MGRmMjBkNzQyMWNmNzAwMDgwNjk3ZDMiLCJpYXQiOjE2ODUwMzAyOTh9.bZGHNa_Dr2G6x3_bPe0_dh6kQLfIP2R04-RmSamNBecoo2aeBIKiOngquVwQouRfqfkqVCf55QzOIMgAFcfftQ4RDLurKu2gktfA3eWrplwlgSFK3HOTfXCqROSFhWveHvS0s0AUbzQb0Tuqu5SHY8F-HdUnUzmMPo85ru7I1ibvCV42nejIxO1qKP3bqVNdkFQMqHyvZk7cAqjIyPVfAdcXBUCMeOGMvNeqRbyJ0enw0S52WE1sk-nARKmdyoRPVIURSinQY2VrZN0-K0R9WwR8AdIcMM211HgibRb4h4EMJjVUlah85uIv0wWqvzVqZo48dQ1Z0ByIBP88GlJ6U0nP__QiPJWUZqHRyzxCT6N27BYmUaTTu5k_F73EmldFQD5eqkQs2bFYcgaVMXTwpQb89K7FRhpSWTdSRPp_5JLyvT_ry-B2POIagDpgXNx_BdoU7EosaY6ziigLTzjP-ItzSc4lyjW7BMiV0Rgr28GwWHIg82UxiKrt-w-mNn-_-G8yTneixG3jK1CKijC3qtejB8nl_BWUijnd37gO4bcu1LK6brtMF3Q6s-DU3bie1UHbLHEhgIs61mmOEudXsnQAFiT5V88KATICJJLvowqtBTuM3vztx3qN5kl3aPWZY5v1B5TJ8NXczOA5kM7zCZM40GMNro7E-PTnGBz6OeU";

        HttpHeaders headers = new HttpHeaders();
        headers.set("auth-token", token);
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<TrackerEvent>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }
        );
        System.out.println("RESPONSE: " + response);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to retrieve tracker events: " + response.getStatusCode());
        }
    }
}
