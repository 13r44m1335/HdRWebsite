package com.example.taskr0676600.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "task")
public class Task {


    @NotEmpty
    private String description,title;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;

    @Id
    @GeneratedValue
    private int id;
    private String dueDateString;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Subtask> subtasks;


    public Task(/*int id, String title, LocalDateTime dueDate, String description*/) {
        /*this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;*/
        this.subtasks = new ArrayList<>();

    }

    public Task(@NotEmpty String title, @NotEmpty String description, LocalDateTime dueDate) {
        setDescription(description);
        setTitle(title);
        setDueDate(dueDate);
        this.subtasks = new ArrayList<>();
    }
    public Task(@NotEmpty String title, @NotEmpty String description, LocalDateTime dueDate, Subtask s) {
        setDescription(description);
        setTitle(title);
        setDueDate(dueDate);
        this.subtasks = new ArrayList<>();
        this.subtasks.add(s);
    }


    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDateString(LocalDateTime localDateTime){
        this.dueDateString = DateTimeFormatter.ISO_DATE.format(localDateTime) + " at " + DateTimeFormatter.ISO_TIME.format(localDateTime);
    }
    public String getDueDateString(){
        return dueDateString;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
       setDueDateString(dueDate);
    }

    public String getDescription(){return description;}

    public void setDescription(String description){ this.description = description;}

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getDueDate());
    }

    @Override
    public String toString() {
        return title + ": due to " + dueDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a"));
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public Subtask getSubtask(int id)
    {
        Subtask out = null;
        for (Subtask s:subtasks) {
            if(s.getId()==id)
            {
                out= s;
            }
        }
        return out;
    }

    public void addSubtask(Subtask subtask) {
       /*int x = 0;
        for (Subtask s:subtasks
             ) {if(x<s.getId()){
                 x = s.getId();
        }

        }
        subtask.setId(x+1);*/

        subtasks.add(subtask);
    }

    public void editSubtask(Subtask subtask) {
        this.getSubtask(subtask.getId()).setDescription(subtask.getDescription());
        this.getSubtask(subtask.getId()).setTitle(subtask.getTitle());

        /*
        for (int i = 0; i < subtasks.size(); i++) {
            if (subtasks.get(i).getId() == id) {
                subtasks.get(i).setDescription(subtask.getDescription());
                subtasks.get(i).setTitle(subtask.getTitle());

            }
        }*/

    }

    public void removeSubtask(int id) {
        for (int i = 0; i < subtasks.size(); i++) {
            if (subtasks.get(i).getId() == id) {
                subtasks.remove(i);

            }
        }
    }

}