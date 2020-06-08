package com.example.taskr0676600.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "subtask")
public class Subtask {
    @Id
    @GeneratedValue
    private int subtaskid;

    private int taskid;
    @NotEmpty
    private String title,description;


    public Subtask(/*int id, String title, String description*/) {
        /*this.id = id;
        this.title = title;
        this.description = description;*/
    }

    public Subtask(@NotEmpty String title, @NotEmpty String description) {
        this.title = title;
        this.description = description;
    }

    /*public Subtask(String title, String description) {
        this.title = title;
        this.description = description;
    }*/

    public int getId() {
        return subtaskid;
    }

    public void setId(int id) {
        this.subtaskid = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
