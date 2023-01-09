package com.example.demo.service;

import com.example.demo.dao.TaskDAO;
import com.example.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskDAO taskDAO;
    @Autowired
    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public void createTaskTable() {
        taskDAO.createTaskTable();
    }

    @Override
    @Transactional
    public List<Task> taskList() {
        return taskDAO.taskList();
    }

    @Override
    public Task taskByName(int id) {
        return null;
    }

    @Override
    @Transactional
    public void save(Task task) {
        taskDAO.save(task);
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(int id) {

    }
}
