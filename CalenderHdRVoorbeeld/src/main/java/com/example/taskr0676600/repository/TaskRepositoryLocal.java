/*
package com.example.taskr0676600.repository;

import com.example.taskr0676600.domain.model.Subtask;
import com.example.taskr0676600.domain.model.Task;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class TaskRepositoryLocal {
    private List<Task> list;


    public TaskRepositoryLocal() {
        list = new ArrayList<>();*/
/*
        list.add(new Task(2,"Task 2", LocalDateTime.of(2022, Month.MARCH,30,18,30),"blub"));
        list.get(0).addSubtask(new Subtask(1,"deeltje 1","fix deeltje 1"));
        list.get(0).addSubtask(new Subtask(2,"deeltje 2","fix deeltje 2"));
        list.get(0).addSubtask(new Subtask(3,"deeltje 3","fix deeltje 3"));
        list.add(new Task(1,"Task 1", LocalDateTime.of(2021, Month.MARCH,10,17,30), "no detail"));

        list.add(new Task(3,"Task 3", LocalDateTime.of(2023, Month.MARCH,20,16,30),"bobob"));*//*


    }

    public List<Task> getTasks() {
        return list;
    }

    public Task getTask(int id){
        Task out = null;
        for (Task t: list
             ) {
            if(t.getId() == id){
                out = t;

            }

        }
        return out;
    }


    public void addTask(Task task) {
        this.list.add(task);
    }

    public void editTask(Task task){
        for (Task t:list
             ) {
            if(t.getId() == task.getId()){
                t.setTitle(task.getTitle());
                t.setDueDate(task.getDueDate());
                t.setDescription(task.getDescription());
            }

        }
    }

    public void removeTask(int id){

        list.remove(getTask(id));
    }

    public void addSubtask(int id, Subtask subtask){
        if(subtask.getDescription()!= null && subtask.getTitle()!= null&& !subtask.getDescription().trim().isEmpty() && !subtask.getTitle().trim().isEmpty()){
        for (Task tx:list
             ) {if(tx.getId()==id){
                 tx.addSubtask(subtask);
            }
        }}
    }

    public void editSubtask(int id, Subtask subtask){
        */
/*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.get(i).editSubtask(subtask);
            }
        }*//*

        this.getTask(id).editSubtask(subtask);
        */
/*Task x = this.getTask(id);
            for (Subtask s:x.getSubtasks()
                 ) {if(s.getId()==subtask.getId()){
                     s.setTitle(subtask.getTitle());
                     s.setDescription(subtask.getDescription());
            }

            }*//*

        }



    public void removeSubtask(int id, int subtaskId){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.get(i).removeSubtask(subtaskId);
                return;
            }
        }


    }


}
*/
