package com.nmmsoft.tasks.Model;

import com.nmmsoft.tasks.Priority;

public class Task {
    private int id;

    private String subject;
    private String description;
    private int image;
    private Priority priority;

    public Task() {
    }

    public Task(int id, String subject, String description, int image, Priority priority) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.image = image;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
