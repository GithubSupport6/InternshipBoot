package com.eurekabpo.internship.services;

import com.eurekabpo.internship.entities.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getTasks();
    public void save(Task task);
}

