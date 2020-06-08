package com.example.taskr0676600.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskDTO {
    private int id;
    @NotNull
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dueDate;
    private String description, dueDateString;
    private List<SubtaskDTO> subtasks;


    public TaskDTO(){
        subtasks = new ArrayList<>();
    }
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @FutureOrPresent
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public String getDueDateString(){
        return dueDateString;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }


    public void setDueDateString(LocalDateTime localDateTime){
        this.dueDateString = DateTimeFormatter.ISO_DATE.format(localDateTime) + " at " + DateTimeFormatter.ISO_TIME.format(localDateTime);
    }

    public void setDueDate(LocalDateTime dueDate) {
        /*dateString = dateString.replace('T',' ');
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dueDate = LocalDateTime.parse(dateString, formatter);*/
        this.dueDate = dueDate;
       setDueDateString(dueDate);
    }


    public void addSubtask(SubtaskDTO subtask){
        subtasks.add(subtask);
    }
    public void deleteSubtask(String subtask){
        SubtaskDTO subtask1 = null;
        for(SubtaskDTO s : subtasks){
            if(s.getTitle().equalsIgnoreCase(subtask)){
                subtask1 = s;

            }

        }
        subtasks.remove(subtask1);

    }
    public SubtaskDTO getSubtask(int id){
        for(SubtaskDTO s : subtasks){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }


    public List<SubtaskDTO> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<SubtaskDTO> subtasks){
        this.subtasks = subtasks;
    }

}
