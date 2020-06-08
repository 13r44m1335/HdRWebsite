package com.example.taskr0676600.domain.service;

import com.example.taskr0676600.domain.model.Subtask;
import com.example.taskr0676600.domain.model.Task;
import com.example.taskr0676600.dto.SubtaskDTO;
import com.example.taskr0676600.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks();

    void addTask(TaskDTO taskDTO);

    TaskDTO getTask(int id);

    Task getTaskById(int id);

    void removeTask(int id);

    void editTask(int id, TaskDTO t);


    Subtask getSubtask(int id, int subId);

    void addSubtask(int id, SubtaskDTO subTask);

    void editSubtask(int id, int subtaskid ,SubtaskDTO subTask);

    void removeSubtask(int id, int subId);




}
