package com.example.taskr0676600.domain.service;

import com.example.taskr0676600.domain.model.Subtask;
import com.example.taskr0676600.domain.model.Task;
import com.example.taskr0676600.dto.SubtaskDTO;
import com.example.taskr0676600.dto.TaskDTO;
import com.example.taskr0676600.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service("TaskServiceImpl")
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {

        this.repository = repository;
    }


    @Override
    public List<TaskDTO> getTasks() {
        return repository.findAll().stream().map(h->{
            TaskDTO dto = new TaskDTO();
            dto.setDescription(h.getDescription());
            dto.setDueDate(h.getDueDate());
            dto.setTitle(h.getTitle());
            dto.setId(h.getId());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        repository.save(task);
    }

    @Override
    public TaskDTO getTask(int id) {
        Task task =  repository.getTaskById(id);
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setDueDate(task.getDueDate());

        dto.setSubtasks(task.getSubtasks()
                .stream().map(s -> {
                    SubtaskDTO subtaskDTO = new SubtaskDTO();
                    subtaskDTO.setId(s.getId());
                    subtaskDTO.setTitle(s.getTitle());
                    subtaskDTO.setDescription(s.getDescription());

                    return subtaskDTO;
                }).collect(Collectors.toList())
        );

        return dto;
    }

    @Override
    public Task getTaskById(int id) {
        return repository.getTaskById(id);
    }

    @Override
    @Transactional
    public void removeTask(int id) {
        Task task = new Task();
        task.setId(getTask(id).getId());
        task.setDueDate(getTask(id).getDueDate());
        task.setDescription(getTask(id).getDescription());
        task.setTitle(getTask(id).getTitle());
        repository.delete(task);

    }

    @Override
    @Transactional
    public void editTask(int id, TaskDTO t) {
        List<Subtask> subtasks = getTaskById(id).getSubtasks();
        Task task = new Task();
        task.setId(t.getId());
        task.setTitle(t.getTitle());
        task.setDescription(t.getDescription());
        task.setDueDate(t.getDueDate());
        task.setSubtasks(subtasks);
        repository.save(task);
    }

    @Override
    public Subtask getSubtask(int id, int subId) {
        return getTaskById(id).getSubtask(subId);
    }

    @Override
    @Transactional
    public void addSubtask(int id, SubtaskDTO subtaskDTO) {
        Subtask subtask = new Subtask();
        subtask.setTitle(subtaskDTO.getTitle());
        subtask.setDescription(subtaskDTO.getDescription());

        Task task = getTaskById(id);

        task.addSubtask(subtask);

        repository.save(task);
    }

    @Override
    public void editSubtask(int id, int subtaskid, SubtaskDTO subtask) {
        Task task = repository.getTaskById(id);
        List<Subtask> subtasks = task.getSubtasks();
        for (Subtask s:subtasks
             ) {
            if(s.getId() == subtaskid){
                s.setDescription(subtask.getDescription());
                s.setTitle(subtask.getTitle());
            }
        }
        task.setSubtasks(subtasks);
        repository.save(task);

    }

    @Override
    public void removeSubtask(int id, int subId) {
        Task task = repository.getTaskById(id);
        task.removeSubtask(subId);
        repository.save(task);
    }

    /*@Override
    public List<Subtask> getSubtasks(int taskId) {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return repository.getTasks();
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        List<Task> tasks = repository.getTasks();
        int x = -1;
        for (Task t: tasks
             ) {if(t.getId()>x)x=t.getId();

        }
        Task t = new Task(x+1,taskDTO.getTitle(),taskDTO.getDueDate(),taskDTO.getDetail());
        repository.addTask(t);

    }

    @Override
    public Task getTask(int id) {
        return repository.getTask(id);
    }

    @Override
    public void removeTask(int id) {
        repository.removeTask(id);

    }

    @Override
    public void editTask(int id, TaskDTO t) {
        repository.editTask(new Task(id,t.getTitle(),t.getDueDate(),t.getDetail()));

    }


    @Override
    public Subtask getSubTask(int id, int subId) {
        return repository.getTask(id).getSubtask(subId);
    }

    @Override
    public void addSubTask(int id, SubtaskDTO subtask) {
        repository.addSubtask(id,new Subtask(subtask.getId(),subtask.getTitle(),subtask.getDescription()));

    }

    @Override
    public void editSubTask(int id, SubtaskDTO subtask) {
        repository.editSubtask(id,new Subtask(subtask.getId(),subtask.getTitle(),subtask.getDescription()));

    }

    @Override
    public void removeSubTask(int id, int subId) {
        repository.removeSubtask(id,subId);

    }

    @Override
    public List<Subtask> getSubtasks(int taskId) {
        return repository.getTask(taskId).getSubtasks();
    }*/
}
