package com.example.taskr0676600.repository;

import com.example.taskr0676600.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task getTaskById(int id);

}
