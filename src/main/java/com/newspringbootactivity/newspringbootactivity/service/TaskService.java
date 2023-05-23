package com.newspringbootactivity.newspringbootactivity.service;

import com.newspringbootactivity.newspringbootactivity.entity.Task;
import com.newspringbootactivity.newspringbootactivity.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

    @Service
    public class TaskService {
        @Autowired
        private TaskRepository taskRepository;


        public Task saveTask(Task task) { // POST METHOD
            return taskRepository.save(task);
        }

        public List<Task> saveTasks(List<Task> tasks) { // POST METHOD
            return taskRepository.saveAll(tasks);
        }

        public List<Task> getAllTasks() { //GET METHOD
            return taskRepository.findAll();
        }

        public Task getTaskById(Long id) { //GET METHOD
            return taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Task not found:" + id));

        }

        public Task getTaskByTitle(String title) { //GET METHOD
            return taskRepository.findByTitle(title);
        }

        public Task updateTask(Task task) {  //UPDATE METHOD
            Task existingTask = taskRepository.findById(task.getId()).orElseThrow(() -> new EntityNotFoundException("Task not foud"));
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setCompleted(task.isCompleted());
            return taskRepository.save(existingTask);
        }

        public String deleteTask(Long id) { // DELETE METHOD
            taskRepository.deleteById(id);
            return "task removed " + id;
        }

        public List<Task> getCompleteTasks() {
            return taskRepository.findByCompleted(true);
        }

        public void saveMyTask(Task task) {
            this.taskRepository.save(task);
        }

    }

