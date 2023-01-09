package com.example.demo.dao;

import com.example.demo.model.Task;

import java.util.List;

public interface TaskDAO {
    void createTaskTable();
    List<Task> taskList();
    Task taskByName(int id);
    void save(Task task);
    void update(Task task);
    void delete(int id);
}
