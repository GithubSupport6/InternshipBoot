package com.eurekabpo.internship.services.implementations;

import com.eurekabpo.internship.entities.Task;
import com.eurekabpo.internship.repositories.TaskRepository;
import com.eurekabpo.internship.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TaskServiceImpl implements TaskService {
    private static Logger logger = Logger.getLogger(TaskRepository.class.getName());

    @Autowired
    private
    TaskRepository taskRepository;

    @Override
    public List<Task> getTasks() {
        logger.info("Getting llist of tasks...");
        LinkedList<Task> res = new LinkedList<>();
        taskRepository.findAll().forEach(res::add);
        return res;
    }

    @Override
    public void save(Task task) {
        logger.info("Saving new task: (" + task.getTaskId() + " : " + task.getDescription() + " : " + task.getDate() + ")");
        taskRepository.save(task);
    }

    @Override
    public void delete(long id) {
        logger.info("Deleting by id: (" + id + ")");
        taskRepository.deleteById(id);
    }
}
