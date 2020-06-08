package com.example.taskr0676600.dto;

import javax.validation.constraints.NotNull;

public class SubtaskDTO {

    private int subtaskid;
    @NotNull
    private String title;
    @NotNull
    private String description;


    public int getId() {
        return subtaskid;
    }

    public void setId(int id) {
        this.subtaskid = id;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
