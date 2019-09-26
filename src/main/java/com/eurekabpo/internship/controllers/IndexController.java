package com.eurekabpo.internship.controllers;

import com.eurekabpo.internship.entities.Task;
import com.eurekabpo.internship.services.MemoryService;
import com.eurekabpo.internship.services.NameService;
import com.eurekabpo.internship.services.TaskService;
import com.eurekabpo.internship.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class IndexController {

    @Autowired
    TimeService timeService;

    @Autowired
    NameService nameService;

    @Autowired
    MemoryService memoryService;

    @Autowired
    TaskService taskService;

    private static Logger logger = Logger.getLogger(IndexController.class.getName());

    @GetMapping("/")
    public ModelAndView welcome(Model model)
    {
        model.addAttribute("name", nameService.getComputerName());
        model.addAttribute("date", timeService.getCurrDate());
        model.addAttribute("time", timeService.getCurrTime());
        model.addAttribute("allMem", memoryService.getAllMemory());
        model.addAttribute("freeMem", memoryService.getFreeMemory());
        model.addAttribute("tasks", taskService.getTasks());
        return new ModelAndView("index.html", model.asMap());
    }

    @GetMapping("/get-data")
    public ModelMap getData()
    {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("data",taskService.getTasks());
        return modelMap;
    }


    @GetMapping("/delete")
    public void delete(@RequestParam("id") long id)
    {
        taskService.delete(id);
    }

    @PostMapping("/add-task")
    public void addNewTask(@RequestParam("taskId") long id, @RequestParam("description") String description, @RequestParam("date")Date date, Model model)
    {
        taskService.save(new Task(id,description,date));
        //return new ModelAndView("redirect:/");
    }
}
