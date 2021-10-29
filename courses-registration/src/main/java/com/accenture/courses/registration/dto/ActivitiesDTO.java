package com.accenture.courses.registration.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activities")
public class ActivitiesDTO {

    @Id
    private String title;

    private int status;

    public ActivitiesDTO(String title, int status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static ActivitiesDTO create(String title, int status){
        return new ActivitiesDTO(title, status);
    }
}