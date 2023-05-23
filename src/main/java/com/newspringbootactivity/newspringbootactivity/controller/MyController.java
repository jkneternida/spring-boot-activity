package com.newspringbootactivity.newspringbootactivity.controller;

import com.newspringbootactivity.newspringbootactivity.entity.Task;
import com.newspringbootactivity.newspringbootactivity.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

    @Controller
    public class MyController {
        public MyController(TaskService taskService) {
            this.taskService = taskService;
        }

       @Autowired
        private TaskService taskService;
        @GetMapping("/")
        public String TaskList(Model model){
            model.addAttribute("tasks", taskService.getAllTasks());
            return "index";
        }
    @GetMapping("/showNewTasksForm")
    public String showNewTasksForm(Model model){
            //create model attribute to bind data
            Task task = new Task();
            model.addAttribute("task", task);
            return "Task";
    }
    @PostMapping("/saveMyTask")
    public String saveMyTask(@ModelAttribute("task") Task task){
            //save employee to the database
        taskService.saveMyTask(task);
        return "redirect:/";


    }
}

