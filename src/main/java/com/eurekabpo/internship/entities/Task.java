package com.eurekabpo.internship.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Task {
    @Id
    private long taskId;
    private String description;
    private Date date;

    public Task(){};

    public Task(long id, String description, Date date)
    {
        this.taskId = id;
        this.description = description;
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public long getTaskId() {
        return taskId;
    }
}
