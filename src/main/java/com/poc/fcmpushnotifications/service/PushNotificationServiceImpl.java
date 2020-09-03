package com.poc.fcmpushnotifications.service;

import com.poc.fcmpushnotifications.notification.PushNotificationRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class PushNotificationServiceImpl {
    private final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
    @Value("${vowpay.commons.firebase.server.key}")
    private String FIREBASE_SERVER_KEY;

    public void sendPushNotification(List<String> keys, String messageTitle, String message) {

        JSONObject msg = new JSONObject();

        msg.put("title", messageTitle);
        msg.put("body", message);
        msg.put("notificationType", "Test");

        keys.forEach(key -> {
            System.out.println("\nCalling fcm Server >>>>>>>");
            String response = callToFcmServer(msg, key);
            System.out.println("Got response from fcm Server : " + response + "\n\n");
        });

    }

    private String callToFcmServer(JSONObject message, String receiverFcmKey) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "key=" + FIREBASE_SERVER_KEY);
        httpHeaders.set("Content-Type", "application/json");

        JSONObject json = new JSONObject();

        json.put("data", message);
        json.put("payload",new PushNotificationRequest());
        json.put("notification", message);
        json.put("to", receiverFcmKey);

        System.out.println("Sending :" + json.toString());

        HttpEntity<String> httpEntity = new HttpEntity<>(json.toString(), httpHeaders);
        return restTemplate.postForObject(FIREBASE_API_URL, httpEntity, String.class);
    }
}