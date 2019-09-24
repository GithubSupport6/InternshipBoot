package com.eurekabpo.internship.controllers;

import com.eurekabpo.internship.services.MemoryService;
import com.eurekabpo.internship.services.NameService;
import com.eurekabpo.internship.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    TimeService timeService;

    @Autowired
    NameService nameService;

    @Autowired
    MemoryService memoryService;

    @GetMapping("/")
    public ModelAndView welcome(Model model)
    {
        model.addAttribute("name", nameService.getComputerName());
        model.addAttribute("date", timeService.getCurrDate());
        model.addAttribute("time", timeService.getCurrTime());
        model.addAttribute("allMem", memoryService.getAllMemory());
        model.addAttribute("freeMem", memoryService.getFreeMemory());
        return new ModelAndView("index.html", model.asMap());
    }
}
