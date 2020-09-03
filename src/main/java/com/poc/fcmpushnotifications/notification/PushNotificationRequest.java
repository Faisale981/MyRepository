package com.poc.fcmpushnotifications.notification;

import java.time.LocalDateTime;

public class PushNotificationRequest {

    private String id;
    private String title;
    private String description;
    private String images;
    private LocalDateTime time;

    public PushNotificationRequest() {
    }

    public PushNotificationRequest(String id, String title, String description, String images, LocalDateTime time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.images = images;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
