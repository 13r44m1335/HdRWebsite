package com.example.taskr0676600.controller;

import com.example.taskr0676600.domain.service.TaskService;
import com.example.taskr0676600.dto.TaskDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {
    private final TaskService taskService;

    public TaskRestController(TaskService service) {
        this.taskService = service;
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<TaskDTO> getHeads() {
        return taskService.getTasks();
    }

    @PostMapping("/tasks")
    public void createNewTask(@RequestBody @Valid TaskDTO taskDTO){
         taskService.addTask(taskDTO);
    }
}
