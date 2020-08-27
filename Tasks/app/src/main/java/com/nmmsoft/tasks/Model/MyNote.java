package com.nmmsoft.tasks.Model;

import com.nmmsoft.tasks.Utils.ImagesPriority;
import com.nmmsoft.tasks.Utils.Priority;

public class MyNote {
    private int id;

    private String subject;
    private String description;
    private int image;
    private Priority priority;
    private String noteCreated;

    private String deadTime;

    public MyNote(String id, String work, String turn_off_computer, ImagesPriority easy, Priority easyPriority, String deadTime) {
        this.noteCreated = saveDateCreatedNote();
    }

    public MyNote(int id, String subject, String description, int image, Priority priority, String deadTime) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.image = image;
        this.priority = priority;

        this.noteCreated = saveDateCreatedNote();

        this.deadTime = deadTime;
    }

    public MyNote() {

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

    public String getNoteCreated() {
        return noteCreated;
    }

    public void setNoteCreated(String noteCreated) {
        this.noteCreated = noteCreated;
    }

    public String saveDateCreatedNote() {
        java.util.Date date = (java.util.Date) java.util.Calendar.getInstance().getTime();
        return date.toString();
    }

    public String getDeadTime() {
        return deadTime;
    }

    public void setDeadTime(String deadTime) {
        this.deadTime = deadTime;
    }
}
