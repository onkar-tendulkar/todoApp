package com.todo.todoApp;

import java.util.Date;

public class ToDo {
    private String name;
    private String details;
    private Date time;
    private boolean done;

    public ToDo(String name, String details, Date time) {
        this.name = name;
        this.details = details;
        this.time = time;
        this.done = false;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public Date getTime() {
        return time;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }
}
