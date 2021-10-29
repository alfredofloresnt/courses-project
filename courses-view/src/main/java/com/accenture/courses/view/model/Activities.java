package com.accenture.courses.view.model;

public class Activities {
    private String title;
    private int status;

    public Activities(){

    }
    public Activities(String title, int status){
        this.title = title;
        this.status = status;
    }

    public static Activities create(String title, int status){
        return new Activities(title, status);
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
}
