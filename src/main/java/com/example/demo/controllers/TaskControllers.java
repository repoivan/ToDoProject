package com.example.demo.controllers;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Controller
@RequestMapping()
public class TaskControllers {
    private TaskService taskService;

    @Autowired
    public TaskControllers(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/allTasks")
    public void allTasks() {
        System.out.println(taskService.taskList().toString());
    }

    @PostMapping()
    public void saveTask() throws ParseException, IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/main/resources/todo.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Task task = new Task();
        JSONParser jsonParser = new JSONParser();
        JSONObject taskJsonObject = (JSONObject) jsonParser.parse(fileReader);

        task.setName((String) taskJsonObject.get("name"));
        taskService.save(task);
    }
}
