package com.example.demo.service;

import com.example.demo.model.Task;

import java.util.List;

public interface TaskService {
    void createTaskTable();
    List<Task> taskList();
    Task taskByName(int id);
    void save(Task task);
    void update(Task task);
    void delete(int id);
}
