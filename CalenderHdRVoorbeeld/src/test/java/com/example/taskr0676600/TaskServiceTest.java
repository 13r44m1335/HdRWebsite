package com.example.taskr0676600;

import com.example.taskr0676600.domain.model.Subtask;
import com.example.taskr0676600.domain.model.Task;
import com.example.taskr0676600.domain.service.TaskService;
import com.example.taskr0676600.dto.SubtaskDTO;
import com.example.taskr0676600.dto.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertNull;

@Transactional
@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;

    @Test
    public void testGetTasks() {
        // setup is niet nodig aangezien er via de commandlinerunner al standaard taken worden meegegeven

        // method to be tested
        List<TaskDTO> tasks = taskService.getTasks();

        // checks
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());

        assertEquals(2, tasks.size()); //2 aangezien er 2 taken en een subtaak is meegegeven
        TaskDTO task = tasks.get(0);
        assertNotNull(task);
    }

    @Test
    public void testGetTask() {
        // setup is niet nodig aangezien er via de commandlinerunner al standaard taken worden meegegeven

        // method to be tested
        TaskDTO task = taskService.getTask(1);

        // checks
        assertNotNull(task);
        assertEquals("Ip-minor taak", task.getTitle());
        assertEquals("maken van een takenlijst", task.getDescription());
        assertEquals(LocalDateTime.of(2020, Month.MAY,31,23,45), task.getDueDate());
        assertEquals(1, task.getId());
    }

    @Test
    public void testUpdateTask() {
        // setup is niet nodig aangezien er via de commandlinerunner al standaard taken worden meegegeven
        TaskDTO taskDTO = taskService.getTask(1);
        taskDTO.setTitle("Ip-minor taak test");
        taskDTO.setDescription("kebab");
        taskDTO.setDueDate(LocalDateTime.of(2021,Month.MARCH,05,21,1));

        //method to be tested
        taskService.editTask(taskDTO.getId(),taskDTO);

        //checks
        TaskDTO task = taskService.getTask(taskDTO.getId());
        assertNotNull(task);
        assertEquals("Ip-minor taak test", task.getTitle());
        assertEquals("kebab", task.getDescription());
        assertEquals(LocalDateTime.of(2021,Month.MARCH,05,21,1), task.getDueDate());
        assertEquals(taskDTO.getId(), task.getId());
    }

    @Test
    public void testAddSubtask() {
        // setup
        TaskDTO taskDTO = taskService.getTask(3);

        SubtaskDTO subTaskDTO = new SubtaskDTO();
        subTaskDTO.setTitle("gitfile");
        subTaskDTO.setDescription("indienen gitfile");

        // method to be tested
        taskService.addSubtask(taskDTO.getId(),subTaskDTO);

        // checks
        TaskDTO task = taskService.getTask(taskDTO.getId());
        assertNotNull(task.getSubtasks());

        SubtaskDTO subTask = task.getSubtasks().get(0);
        assertNotNull(subTask);
        assertEquals("gitfile", subTask.getTitle());
        assertEquals("indienen gitfile", subTask.getDescription());
    }

    @Test
    public void testGetSubtask(){
        //setup niet nodig --> commandline runner
        SubtaskDTO subtaskDTO = new SubtaskDTO();
        subtaskDTO.setTitle("Story 1");
        subtaskDTO.setDescription("As a user\n" +
                "I can retrieve all tasks\n" +
                "So that I can see what I have left to do\n");

        //method
        taskService.getSubtask(taskService.getTaskById(1).getId(),2);

        //checks
        Subtask s = taskService.getSubtask(taskService.getTaskById(1).getId(),2);

        assertNotNull(s);
        assertEquals("Story 1",s.getTitle());
        assertEquals("As a user\n" +
                "I can retrieve all tasks\n" +
                "So that I can see what I have left to do\n",s.getDescription());



    }

    @Test
    public void testDeleteSubtask(){

        //method
        taskService.removeSubtask(taskService.getTaskById(1).getId(),2);

        //checks

        taskService.removeSubtask(taskService.getTaskById(1).getId(),2);

        assertNull("",taskService.getSubtask(taskService.getTaskById(1).getId(),2));



    }
}
