package com.newspringbootactivity.newspringbootactivity.controller;


import com.newspringbootactivity.newspringbootactivity.entity.Task;
import com.newspringbootactivity.newspringbootactivity.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    public class TaskController {

        @Autowired
        private TaskService taskService;

        @PostMapping("/addTask")
        public Task addTask(@RequestBody Task task) {
            return taskService.saveTask(task);
        }
        @PostMapping("/addTasks")
        public List<Task> addTasks(@RequestBody List<Task> tasks) {
            return taskService.saveTasks(tasks);
        }

        @GetMapping("/tasks")
        public List<Task> findAllTasks() {
            return taskService.getAllTasks();
        }

        @GetMapping("/taskByid/{id}")
        public Task findTaskById(@PathVariable Long id) {
            return taskService.getTaskById(id);
        }
        @GetMapping("/taskByTitle/{title}")
        public Task findTaskByTitle(@PathVariable String title) {
            return taskService.getTaskByTitle(title);
        }

        @PutMapping("/update")
        public Task updateTask( @RequestBody Task task) {
            return taskService.updateTask(task);
        }

        @DeleteMapping("/delete/{id}")
        public void deleteTask(@PathVariable Long id) {
            taskService.deleteTask(id);
        }

        @GetMapping("/completed")
        public List<Task> getCompleted(){
            return taskService.getCompleteTasks();
        }
    }

