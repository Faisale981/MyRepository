package com.poc.fcmpushnotifications.controller;

import com.poc.fcmpushnotifications.service.PushNotificationServiceImpl;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;

@RestController
public class WebController {

    private final String TOPIC = "test";

    @Autowired
    PushNotificationServiceImpl pushNotificationService;

    @RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> send() throws JSONException, IOException {

        pushNotificationService.sendPushNotification(Collections.singletonList("token-id-device"),"Update-Required","Please update your licence");
        return new ResponseEntity<>("Push Notification Send", HttpStatus.OK);
    }
}